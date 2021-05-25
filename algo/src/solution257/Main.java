package solution257;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 2573 빙산
public class Main {
    static int map[][];
    static boolean visited[][];
    static int zero[][];
    static int a[] = {0,0,1,-1};
    static int b[] = {1,-1,0,0};
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0 ; i < n ;i++){
            String tmp[] = br.readLine().split(" ");
            for(int j = 0 ; j < m;j++){

                map[i][j] = Integer.parseInt(tmp[j]);

            }
        }
        int year = 0;
        while(true){

            year++;

            visited = new boolean[n][m];
            zero = new int[n][m];
            //false 이면 0인부분


            for(int i = 0 ; i < n ;i++){
                for(int j = 0 ; j < m;j++){
                    if(!visited[i][j] && map[i][j] == 0){
                        visited[i][j] = true;
                        dfs(i,j,false);
                    }
                }
            }

            for(int i = 0 ; i < n ;i++){
                for(int j = 0 ; j < m;j++){
                    map[i][j] = map[i][j]+zero[i][j]  <0 ? 0 :map[i][j]+zero[i][j];
                }
            }


            //true 이면 나뉘었는지 체크
            int divChk = 0;
            for(int i = 0 ; i < n ;i++){
                for(int j = 0 ; j < m;j++){
                    if(!visited[i][j] && map[i][j] > 0){
                        visited[i][j] = true;
                        dfs(i,j,true);
                        divChk++;
                    }
                }
            }


            if(divChk >1){
                System.out.println(year);
                break;
            }else if(divChk == 0){
                System.out.println(0);
                break;
            }


        }



    }


    public static void dfs(int r,int c,boolean flag){

        for(int i = 0 ;i < 4 ; i++){
            int mr = r+ a[i];
            int mc = c+ b[i];

            if(mr >=n || mc >= m || mr <0 || mc <0) continue;

            if(!flag){
                if(!visited[mr][mc] && map[mr][mc] == 0) {
                    visited[mr][mc] = true;
                    dfs(mr, mc, flag);
                }

                if(map[mr][mc] >0){
                    zero[mr][mc] -=1;
                }

            }else{
                 if(!visited[mr][mc] && map[mr][mc] > 0){
                    visited[mr][mc] = true;
                    dfs(mr,mc,flag);

                }




            }


        }


    }

}
