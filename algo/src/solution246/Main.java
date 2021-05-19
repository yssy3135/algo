package solution246;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 2156 포도주 시식 (dp)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int num[] = new int[n+1];
        for(int i = 1 ; i <= n ; i++ ){
            num[i] = Integer.parseInt(br.readLine());
        }
        int dp[] = new int[n+1];


        dp[1] = num[1];
        if(n>2){
            dp[2] = num[1] + num[2];

        }

        for(int i = 3 ; i <= n;i++){


            //한잔 먹는 경우 전 잔을 먹으면 2잔 먹는게 되므로 먹으면 안된
            // num[i]+dp[i-2];
            //두잔 먹는 경우 전잔을 먹고

            dp[i] = Math.max(num[i]+num[i-1]+dp[i-3],num[i]+dp[i-2]);

            //안먹을 경우
            dp[i] = Math.max(dp[i],dp[i-1]);

        }

        System.out.println(dp[n]);


    }
}
