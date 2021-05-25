package solution255;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

// 백준 16236 아기상어
public class Main {

    static int map[][];
    static int shark[];
    static ArrayList<int[]> feed;
    static int n;
    static boolean visited[][];
    static int a[] = {0,0,-1,1};
    static int b[] = {1,-1,0,0};
    static int moveCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        shark = new int[2];

        for(int i = 0 ; i < n ;i++){
            String tmp[] = br.readLine().split(" ");
            for(int j = 0 ; j < n;j++){
                map[i][j] = Integer.parseInt(tmp[j]);
                if(map[i][j] == 9){
                    shark[0] = i;
                    shark[1] = j;
                }
            }
        }


        int eatCnt= 0;
        int sharkSize = 2;

        while(true){
            feed = new ArrayList<>();


            //자신보다 작은 물고기를 찾는다.
            visited = new boolean[n][n];
            visited[shark[0]][shark[1]] = true;
            bfs(shark[0],shark[1],sharkSize);


            if(feed.size() > 1){

                feed.sort(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return Integer.compare(o1[2],o2[2]) == 0 ? Integer.compare(o1[0],o2[0]) == 0 ? Integer.compare(o1[1],o2[1]) : Integer.compare(o1[0],o2[0]): Integer.compare(o1[2],o2[2]);
                    }
                });

            }else if (feed.isEmpty()){
                break;
            }


            int eat[] = feed.get(0);

            moveCnt +=eat[2];
            eatCnt +=1;
            map[shark[0]][shark[1]] = 0;

            shark[0] = eat[0];
            shark[1] = eat[1];
            map[eat[0]][eat[1]] = 9;

            if(eatCnt == sharkSize){
                sharkSize +=1;
                eatCnt = 0;
            }



        }
        System.out.println(moveCnt);


    }

    public static void bfs(int r,int c,int size){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {r,c,0});

        while(!que.isEmpty()){
            int cur[] = que.poll();



            for(int i = 0 ; i < 4 ;i++){
                int mr = cur[0]+a[i];
                int mc = cur[1]+b[i];
                if(mr >= n || mc >= n || mr <0 || mc <0)continue;

                if(!visited[mr][mc] && map[mr][mc] < size && map[mr][mc] !=0){
                    visited[mr][mc] = true;
                    feed.add(new int[]{mr,mc,cur[2]+1});
                }else if(!visited[mr][mc] && (map[mr][mc] ==  size || map[mr][mc] == 0 ) ){
                    visited[mr][mc] = true;
                    que.add(new int[]{mr,mc,cur[2]+1});
                }



            }

        }


    }



}
