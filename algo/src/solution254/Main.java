package solution254;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 2468 안전영역
public class Main {
    static int map[][];
    static int n;
    static int a[] = {1,-1,0,0};
    static int b[] = {0,0,-1,1};
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int max = 0;
        int min = Integer.MAX_VALUE;
        map = new int[n][n];
        for(int i = 0 ; i < n ;i++){
            String tmp[] = br.readLine().split(" ");
            for(int j = 0 ; j < n; j++){
                map[i][j] = Integer.parseInt(tmp[j]);
                max = Math.max(map[i][j],max);
                min = Math.min(map[i][j],min);
            }
        }

        int maxZone = 1;
        for(int i = min ; i <=max ;i++){
            int newMap[][] = chk(i);
            visited = new boolean[n][n];
            int cnt = 0;
            for(int j = 0 ; j < n ; j++){
                for(int k = 0 ; k < n;k++){
                    if(newMap[j][k] !=0 && !visited[j][k]){
                        visited[j][k] = true;
                        dfs(j,k,newMap);
                        cnt++;
                    }
                }
            }
            maxZone = Math.max(maxZone,cnt);

        }
        System.out.println(maxZone);

    }

    public static void dfs(int r,int c,int newMap[][]){

        for(int i = 0 ; i < 4;i++){
            int mr = r+a[i];
            int mc = c+b[i];
            if(mr >= n || mc >=n || mr <0 || mc <0) continue;
            if(!visited[mr][mc] && newMap[mr][mc]!=0 ){
                visited[mr][mc] = true;
                dfs(mr,mc,newMap);
            }

        }


    }


    public static int[][] chk(int height){
        int newMap[][] = new int[n][n];
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ;j < n ;j++){
                if(map[i][j] > height){
                    newMap[i][j] = map[i][j];
                }
            }
        }

        return newMap;
    }
}
