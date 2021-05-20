package solution248;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int T[] = new int[n+1];
        int P[] = new int[n+1];

        for(int i = 0 ; i < n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());

            T[i+1] = time;
            P[i+1] = pay;

        }

        int dp[] = new int[n+2];
        int max = 0;
        for(int i = 1 ; i <=n;i++){

            if(T[i]+i <= n+1){
                dp[T[i]+i] = Math.max(P[i]+dp[i] ,dp[T[i]+i]);
            }
            if(max < dp[i]) {
                max = dp[i];
            }
        }

        System.out.println(max);
        System.out.println(Arrays.toString(dp));
        ;



    }
}
