package solution266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//백준 9465 스티커 (dp)
public class Main {
    static int map[][];
    static int dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int t = Integer.parseInt(br.readLine());


        for(int i = 0 ; i < t ; i++){
            int n = Integer.parseInt(br.readLine());
            map = new int[2][n];
            dp = new int[2][n];
            int max = 0;
            for(int j =0; j < 2 ;j++){
                String input[] = br.readLine().split(" ");
                for(int k = 0 ; k < n; k++){
                    map[j][k] = Integer.parseInt(input[k]);
                }
            }


            //시작을 row가 [0]일때 [1]일때 에서 할 수 있다.
            attach(n);


        }





    }


    public static void attach(int n){

        dp[0][1] = map[0][1]+map[1][0];
        dp[1][1] = map[1][1]+map[0][0];

        dp[0][0] = map[0][0];
        dp[1][0] = map[1][0];




        for(int i = 2 ; i < n;i++){
            dp[0][i] = map[0][i]+Math.max(dp[1][i-1],dp[1][i-2]);
            dp[1][i] = map[1][i]+Math.max(dp[0][i-1],dp[0][i-2]);
        }

        System.out.println(Math.max(dp[0][n-1],dp[1][n-1]));
    }




}
