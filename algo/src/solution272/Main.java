package solution272;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//백준 10844 쉬운 계단수(dp) Top-Bottom
public class Main {
    static long dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new long[n+1][10];
        long sum  = 0;

        Arrays.fill(dp[1],1);

        for(int i = 1 ; i <=9 ;i++){
            sum += recursive(i,n);
        }


        System.out.println(sum%1000000000);
    }

    public static long recursive(int num,int len){
            if(len == 1){

                return dp[len][num] %1000000000;
            }

            if(dp[len][num] == 0){
                if(num == 0 ){
                    dp[len][num] = recursive(1,len-1);
                }else if (num == 9){
                    dp[len][num] = recursive(8,len-1);
                }else{
                    dp[len][num] = recursive(num+1,len-1) + recursive(num-1,len-1);
                }
            }

            return dp[len][num] %1000000000;

    }



}
