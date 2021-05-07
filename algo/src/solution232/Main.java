package solution232;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int map[][];
    static int a[] = { 0, 0, -1,1,-1,1};
    static int b[] = { 1, -1, 0,0,0,0};
    static boolean visited[][];
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        map = new int[height+2][width+2];
        visited = new boolean[height+2][width+2];

        for(int i = 1 ; i <= height;i++){
            String tmp[] = br.readLine().split(" ");
            for(int j = 1 ; j <= width ;j++){
                map[i][j] = Integer.parseInt(tmp[j-1]);
            }
        }

        //바로위 왼쪽위 왼쪽, 오른쪽 아래, 아래, 오른쪽 6군데


        for(int i = 0 ; i < width+2;i++){
                if(!visited[0][i] && map[0][i] == 0 ){

                    visited[0][i] = true;
                    dfs(0,i,width+2,height+2);
                }
        }
        for(int i = 0 ; i < width+2;i++){
                if(!visited[height+1][i] && map[height+1][i] == 0 ){

                    visited[height+1][i] = true;
                    dfs(height+1,i,width+2,height+2);
                }
        }
        for(int i = 0 ; i < height+2;i++){
                if(!visited[i][0] && map[i][0] == 0 ){

                    visited[i][0] = true;
                    dfs(i,0,width+2,height+2);
                }
        }
        for(int i = 0 ; i < height+2;i++){
                if(!visited[i][width+1] && map[i][width+1] == 0 ){

                    visited[i][width+1] = true;
                    dfs(i,width+1,width+2,height+2);
                }
        }

      

        System.out.println(cnt);

    }

    public static void dfs(int r,int c,int width,int height){


        for(int i = 0 ; i < 6 ; i++){
            int mr = r+a[i];

            //4일때 위 5일때 아래
            if( i== 4 || i== 5){
                if(mr %2 == 1){
                    b[i] = -1;
                }else{
                    b[i] = 1;
                }
            }

            int mc = c+b[i];
            if(mr <0 || mc <0 || mr >= height || mc >= width) continue;

                if(!visited[mr][mc] && map[mr][mc] == 0){
                    visited[mr][mc] = true;
                    dfs(mr,mc,width,height);

                }else if(map[mr][mc] == 1)cnt++;



        }


    }


}
