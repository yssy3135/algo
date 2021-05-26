package solution264;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//백준 2234 성곽 (그래프,bfs,비트연산)
public class Main {
    static int map[][];
    static boolean visited[][];
    static int a[] = {0,-1,0,1};
    static int b[] = {-1,0,1,0};
    static int m;
    static int n;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited= new boolean[m][n];

        for(int i = 0 ; i < m; i++){
            String tmp[] = br.readLine().split(" ");
            for(int j = 0 ; j < n;j++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        int cnt = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n; j++){
                if(!visited[i][j]){
                   visited[i][j] = true;
                    bfs(i,j);
                    cnt++;

                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);


        for(int i = 0 ;i < m; i++){
            for(int j = 0 ; j < n ;j++){
                breakWall(i,j);
            }
        }
        System.out.println(max);

    }

    public static void breakWall(int r,int c){

        for(int i = 0 ; i < 4 ;i++){
            visited = new boolean[m][n];
            if( (map[r][c] & (1 << i) ) != 0 ){
                map[r][c] = map[r][c] - (1 << i);
                visited[r][c] = true;
                bfs(r,c);
                map[r][c] = map[r][c] + (1 << i);
            }

        }


    }

    public static void bfs(int r,int c){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {r,c});

        int size = 0;
        while(!que.isEmpty()){
            int cur[] = que.poll();


            size++;
            for(int i = 0 ; i < 4 ;i++){


                int mr = cur[0] + a[i];
                int mc = cur[1] + b[i];

                if(mr>= m || mc >=n || mr <0 || mc <0) continue;
                //i값만큼 shift 연산하여 동서남북 하고 and연산

                if(!visited[mr][mc] && ( (map[cur[0]][cur[1]] & (1 << i) ) == 0 )){
                    visited[mr][mc] = true;
                    que.add(new int[]{mr,mc});

                }
            }
        }

        max = Math.max(max,size);
    }



}
