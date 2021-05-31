package solution271;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 1699 제곱수의합 Bottom-Top(dp)
public class Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n+1];

        dp[1] = 1;

        for(int i = 2 ;i <=n ;i++){
            dp[i] = i;
            int root = (int)Math.sqrt(i);
            for(int j = 1 ; j <= root ; j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }

        }

        System.out.println(dp[n]);




    }
}
