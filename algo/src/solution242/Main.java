package solution242;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {


    static int score[];
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        score = new int[n+1];
        dp = new int[n+1];
        for(int i = 1 ; i <= n ;i++){
            int input = Integer.parseInt(br.readLine());
            score[i] = input;
        }

        dp[1] = score[1];
        if(n >1){

            dp[2] = dp[1]+score[2];

            for(int i = 3 ; i <= n ; i++){
                dp[i] = Math.max(dp[i-3]+score[i-1]+score[i],dp[i-2]+score[i]);
            }
        }


        System.out.println(dp[n]);

    }




}
