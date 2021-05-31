package solution271;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        recursive(n);
        System.out.println(dp[n]);
    }

    public static int recursive(int num){
        if(num == 0 )return 0;
        if( num == 1 ) return dp[1] = 1;

        if(dp[num] != 0) return dp[num];

        int root = (int) Math.sqrt(num);

        int min = Integer.MAX_VALUE;

        for(int i = 1 ; i <=root ; i++){
            min =  Math.min(recursive(num-(int) Math.pow(i,2))+1,min);
        }

        dp[num] = min;

        return min;
    }

}
