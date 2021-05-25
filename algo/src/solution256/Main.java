package solution256;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 2206 벽 부수고 이동하기
public class Main {

    static class Info{
        int r;
        int c;
        int flag;
        int cnt;

        public Info(int r, int c, int flag, int cnt) {
            this.r = r;
            this.c = c;
            this.flag = flag;
            this.cnt = cnt;
        }
    }


    static int map[][];
    static boolean visited[][][];
    static int a[] = {0,0,-1,1};
    static int b[] = {1,-1,0,0};
    static int n;
    static int m;
    static int ans = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m][2];

        for(int i = 0 ; i < n; i++){
            String tmp[] = br.readLine().split("");
            for(int j = 0 ; j < m;j++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }



        bfs();
        System.out.println(ans);

    }

    public static void bfs(){
        Queue<Info> que = new LinkedList<>();
        que.add(new Info(0,0,0,1));
        visited[0][0][0]= true;
        visited[0][0][1]= true;

        while(!que.isEmpty()){
            Info info = que.poll();

            if(info.r == n-1 && info.c == m-1){

                ans = info.cnt;
                return;
            }

            for(int i = 0 ; i < 4;i++){
                int mr = info.r+a[i];
                int mc = info.c+b[i];
                if(mr <0 || mc <0 || mr >=n || mc >= m)continue;


                //벽을 깨고 이동했을 때와 벽을 깨지 않고 이동했을 때 두가지 경우를 생각해줘야함.
                if(map[mr][mc] == 1){
                    //벽일경우
                    //벽을 깬적이 없고 visited[mr][mc][1]은 벽을 깨고 방분한 경우 최소값을 찾아야하기때문에 처음 방문해야함함
                    if(info.flag ==0 && !visited[mr][mc][1]){
                        visited[mr][mc][1] = true;
                        que.add(new Info(mr,mc,1,info.cnt+1));
                    }

                }else {
                    //벽이 아닐 경우
                    if(!visited[mr][mc][info.flag]){
                        visited[mr][mc][info.flag] = true;
                        que.add(new Info(mr,mc,info.flag,info.cnt+1));
                    }
                }



            }

        }

    }



}
