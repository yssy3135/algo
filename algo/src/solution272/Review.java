package solution272;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//백준 10844 쉬운 계단수(dp) Bottom-Up
public class Review {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long dp[][] = new long[n+1][10];


        Arrays.fill(dp[1],1);


        for(int i = 2 ; i <=n ;i++){
            for(int j = 0 ; j <=9;j++){

                if(j== 0){
                    dp[i][j] = dp[i-1][1];
                }else if (j==9){
                    dp[i][j] = dp[i-1][8];
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) %1000000000;
                }



            }
        }
        long sum = 0;
        for(int i = 1 ; i <=9;i++){
            sum +=dp[n][i];
        }

        System.out.println(sum%1000000000);

    }
}
