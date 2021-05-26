package solution263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 3055 탈출 (bfs)
public class Main {

    static String map[][];
    static int sr;
    static int sc;
    static int dr;
    static int dc;
    static int a[] = {0,0,-1,1};
    static int b[] = {1,-1,0,0};
    static boolean visited[][];
    static int ans = -1;
    static ArrayList<int[]>  waterList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        waterList = new ArrayList<>();
        map = new String[r][c];
        visited = new boolean[r][c];

        for(int i = 0 ; i < r ; i++){
            String tmp[] = br.readLine().split("");
            for(int j = 0 ; j < c; j++){
                map[i][j] = tmp[j];
                if(tmp[j].equals("S")){
                    sr = i;
                    sc = j;
                }else if (tmp[j].equals("D")){
                    dr = i;
                    dc = j;
                }else if (tmp[j].equals("*")){
                    waterList.add(new int[] {i,j});
                }
            }
        }

        bfs(r,c);
        if(ans == -1){
            System.out.println("KAKTUS");
        }else{
            System.out.println(ans);
        }

    }

    public static void bfs(int r,int c){
        Queue<int[]> que = new LinkedList<>();

        que.add(new int[] {sr,sc,0});
        int curCnt = -1;

        while(!que.isEmpty()){
            int cur[] = que.poll();
            if(curCnt < cur[2]){
                water(r,c);

                curCnt = cur[2];
            }
            if(map[cur[0]][cur[1]].equals("D")){

                ans = cur[2];
                return;
            }

            for(int i = 0 ; i < 4;i++){
                int mr = cur[0] +a[i];
                int mc = cur[1] +b[i];
                if(mr >= r || mc >= c || mr < 0 || mc <0) continue;
                if(!visited[mr][mc] && (map[mr][mc].equals(".") || map[mr][mc].equals("D")) ){
                    visited[mr][mc] = true;
                    que.add(new int[] { mr,mc,cur[2]+1});
                }


            }


        }

    }

    public static void water(int r,int c){

        ArrayList<int[]> newWater = new ArrayList<>();
        for(int i = 0 ; i < waterList.size();i++){
            int water[] = waterList.get(i);
            for(int j = 0 ; j < 4 ;j++){
                int mi  = water[0] + a[j];
                int mj = water[1] + b[j];
                if(mi >= r || mj >= c || mi < 0 || mj <0) continue;
                if (map[mi][mj].equals(".")) {
                    map[mi][mj] = "*";
                    newWater.add(new int[] { mi,mj});
                }

            }

        }

        waterList  = newWater;

    }




}


