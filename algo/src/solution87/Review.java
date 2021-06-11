package solution87;


import java.util.Arrays;

//프로그래머스 등굣길(dp) Top-down
public class Review {
    public static void main(String[] args) {
        solution(4,3,new int[][]{{2,2}});

    }


    static int dp[][];
    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;


        dp = new int[m+1][n+1];


        for(int i = 0 ; i < puddles.length;i++){
            dp[puddles[i][0]][puddles[i][1]] = -1;
        }

      dp[1][1] = 1;


        System.out.println( recursive(m,n,m,n));


        for(int a[] : dp){
            System.out.println(Arrays.toString(a));
        }

        return recursive(m,n,m,n);
    }


    public static int recursive(int r,int c,int m,int n){




        if(r < 1 || c <1  || r >m || c > n  ) return 0;
        if(dp[r][c] == -1) return 0;


        if(dp[r][c] != 0){

            return dp[r][c]%1000000007;
        }


        dp[r][c] = recursive(r-1,c,m,n) + recursive(r,c-1,m,n);



        return dp[r][c]%1000000007;

    }


}
