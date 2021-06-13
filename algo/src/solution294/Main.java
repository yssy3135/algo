package solution294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//백준 16929 TwoDots (dfs)
public class Main {

    static char map[][];
    static boolean visited[][];
    static int a[] = {1,-1,0,0};
    static int b[] = {0,0,-1,1};
    static int n;
    static int m;
    static String ans = "No";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for(int i = 0 ; i < n ;i++){
            map[i] = br.readLine().toCharArray();
        }



        Loop:
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < m;j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    if(dfs(i,j,map[i][j],1,i,j) ){
                        ans = "Yes";
                        break Loop;
                    }
                }
                visited = new boolean[n][m];
            }
        }


        System.out.println(ans);

    }

    public static boolean dfs(int r,int c,char target,int cnt,int startR,int startC){



        for(int i = 0 ; i < 4 ;i++){
            int mr = r + a[i];
            int mc = c + b[i];

            if(cnt >= 4 && mr == startR && mc == startC){

                ans = "Yes";
                return true;
            }
            if(mr <0 || mc <0 || mr >= n || mc >=m) continue;

                if(!visited[mr][mc] && map[mr][mc] == target){
                    visited[mr][mc] = true;
                    dfs(mr,mc,target,cnt+1,startR,startC);
                }
        }



        return false;
    }


}
