package solution277;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 1937 욕심쟁이 판다 (dp,dfs)
public class Main {

    static int dp[][];
    static int n;
    static int map[][];
    static int a[] = {0,0,-1,1};
    static int b[] = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n][n];
        map = new int[n][n];

        for(int i = 0 ; i < n; i++){
            String tmp[] = br.readLine().split(" ");
            for(int j = 0 ;j < n ;j++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }

        }

        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < n ;j++){
                if(dp[i][j] == 0){

                    dfs(i,j);
                }
            }
        }

        int max = 0;
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < n ;j++){
                max = Math.max(max,dp[i][j]);
            }
        }

        System.out.println(max);


    }

    public static int dfs(int r,int c){

        if(dp[r][c] != 0){
            return dp[r][c];
        }

        dp[r][c] = 1;

        int max = 0;
        for(int i = 0 ; i < 4 ; i++){
            int mr = r+a[i];
            int mc = c+b[i];

            if(mr>= n || mc >= n || mc <0 || mr <0) continue;
            if(map[r][c] < map[mr][mc]){
                dp[r][c] = Math.max(dfs(mr,mc)+1,dp[r][c]);

            }

        }




        return dp[r][c];
    }


}
