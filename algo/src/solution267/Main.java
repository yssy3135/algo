package solution267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 2193 이친수(dp)
public class Main {
    static int ans =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long dp[] = new long[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2 ; i <=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        System.out.println(dp[n]);
    }



}
