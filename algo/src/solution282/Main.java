package solution282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


//백준 2616 소형기관차 (dp,누적합) 다시풀기
public class Main {
    static int num[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        num = new int[n+1];
        int dp[][] = new int[4][n+1];
        String tmp[] = br.readLine().split(" ");

        for(int i = 1 ; i <= n;i++){
            num[i] = Integer.parseInt(tmp[i-1]);
        }


        int max = Integer.parseInt(br.readLine());

        //누적합을 구한다. (손님수의 합)
        for(int i = 1 ; i <= n;i++){
            num[i] += num[i-1];
        }


        //소형 i대로 j칸의 객차를 끌수 있는경우
        for(int i = 1 ; i< 4; i++){
            for(int j = i * max ; j<=n;j++){
                                                            // j-max칸부터 j칸까지 손님의 합. (max개의 칸을 운송했을 때 손님의 합)
                dp[i][j]= Math.max(dp[i][j-1],dp[i-1][j-max]+(num[j]-num[j-max]));


            }
        }


        System.out.println(dp[3][n]);





    }
}
