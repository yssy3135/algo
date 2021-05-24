package solution253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1012 유기농 배추
public class Main {
    static int map[][];
    static boolean visited[][];
    static int a[] = {1,-1,0,0};
    static int b[] = {0,0,-1,1};
    static int height;
    static int width;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int t  = Integer.parseInt(br.readLine());



        for(int i =0 ; i < t ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            map = new int[height][width];
            visited = new boolean[height][width];
            int cnt = 0;
            for(int j = 0 ; j < k ;j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            for(int j = 0 ; j < height ; j++){
                for(int z = 0 ; z < width ; z++){
                    if(map[j][z] == 1 && !visited[j][z]){
                        cnt++;
                        dfs(j,z);
                    }
                }
            }

            System.out.println(cnt);

        }


    }
    public static void dfs(int r,int c){

        for(int i = 0 ; i < 4 ; i++){
            int mr = r+a[i];
            int mc = c+b[i];

            if(mr < 0 || mc <0 || mr >= height || mc >=width ) continue;
            if(!visited[mr][mc] && map[mr][mc] == 1){
                visited[mr][mc] = true;
                dfs(mr,mc);
            }


        }

    }


}
