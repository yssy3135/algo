package solution269;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//백준 11727 2xn타일링2
public class Main {

    static int n;
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dp = new int[n+1];

        System.out.println(recursive(n));


    }

    public static int recursive(int level){
        if(level == 1) return 1;
        if(level == 2) return 3;

        if(dp[level] != 0){
            return dp[level];
        }


        return dp[level] = (recursive(level-1)+recursive(level-2)+recursive(level-2))%10007;
    }
}
