package solution261;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 4991 로봇 청소기(그래프,완전탐색)
public class Main {
    static String map[][];
    static ArrayList<int[]> list;
    static int dis[][];
    static boolean visited[];
    static int ans = Integer.MAX_VALUE;
    static boolean chkMap[][];
    static int a[] = {0,-1,0,1};
    static int b[] = {-1,0,1,0};
    static int w;
    static int h;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            ans = Integer.MAX_VALUE;

            if(w == 0 || h ==0) break;

            map = new String[h][w];

            for(int i = 0 ; i < h; i++){
                map[i] = br.readLine().split("");
            }


            //        1. 더러운칸들에 번호를 부여합니다
            //        2. 각각의 더러운칸에서 출발해 다른 모든 더러운칸들로 가는 거리를 구해놓습니다(2차원배열)
            //        3. 더러운칸의 방문순서의 모든 경우를 발생시킵니다(차이를최대로문제처럼)
            //        4. 2번에서 구해놓은 더러운칸들사이의 거리를 통해 해당 순서로 더러운칸을 방문했을 경우 전체거리를 구할 수 있습니다
            //        5. 이 경우의수를 min 값에 업데이트 시킵니다

            list = new ArrayList<>();

            for(int i = 0 ; i < h; i++){
                for(int j = 0 ; j < w ; j++){
                    if(map[i][j].equals("*")){
                        list.add(new int[] {i,j});
                    }else if (map[i][j].equals("o")){
                        list.add(0,new int[] {i,j});
                    }
                }
            }
            int size = list.size();
            dis = new int[size][size];



            for(int i = 0 ; i < size;i++){
                bfs(i);
            }

            visited = new boolean[size];
            int arr[] = new int[size];
            arr[0] = 0;
            permu(size,1,arr);


            sb.append(ans+"\n");

        }

        System.out.println(sb.toString());

    }

    public static void permu(int n,int depth,int output[]){
        if (depth == n) {

            int sum = 0;
            for(int i = 0 ; i < n-1;i++){
                if( dis[output[i]][output[i+1]] == 0){
                    ans = -1;
                    return;
                }
                sum += dis[output[i]][output[i+1]];
            }
            ans = Math.min(sum,ans);

            return;
        }

        for(int i = 1 ;i < n ;i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = i;
                permu(n,depth+1,output);
                visited[i] = false;
            }
        }

    }

    public static int bfs(int sNum){
        chkMap = new boolean[h][w];
        Queue<int[]> que = new LinkedList<>();
        int sr = list.get(sNum)[0];
        int sc = list.get(sNum)[1];
        que.add(new int[]{sr,sc,0});
        chkMap[sr][sc]= true;

        while(!que.isEmpty()){
            int cur[] = que.poll();

            for(int i = 0 ; i < list.size();i++){
                if(list.get(i)[0] == cur[0] && list.get(i)[1] == cur[1]){
                    dis[sNum][i] = cur[2];
                    dis[i][sNum] = cur[2];
                }
            }


            for(int i = 0 ; i < 4; i++){
                int mr = cur[0] + a[i];
                int mc = cur[1] + b[i];
                if(mr <0 || mc <0 || mr >= h || mc >= w) continue;

                if(!chkMap[mr][mc] && !map[mr][mc].equals("x") ){
                    chkMap[mr][mc] = true;
                    que.add(new int[]{mr,mc,cur[2]+1});
                }

            }

        }

        return -1;
    }




}


