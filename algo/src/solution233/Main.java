package solution233;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int map[][][];
    static int m;
    static int n;
    static int h;
    static int a[] = {1,-1,0,0};
    static int b[] = {0,0,1,-1};
    static int ans = -1;
    static int cntChk = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][n][m];


        for(int i = 0 ; i < h ; i++){
            for(int j = 0 ; j < n ; j++){
                String tmp[] = br.readLine().split(" ");
                for(int k = 0 ; k <m; k ++){
                    map[i][j][k] = Integer.parseInt(tmp[k]);
                }
            }
        }


        bfs();

        System.out.println(ans);





    }

    public static void bfs(){
        Queue<int[]> que = new LinkedList<int[]>();
        for(int i = 0 ; i < h ; i++){
            for(int j = 0 ; j < n ; j++){
                for(int k = 0 ; k <m; k ++){
                    if(map[i][j][k] == 1){

                        que.add(new int[]{i,j,k,0});
                    }
                }
            }
        }

        while(!que.isEmpty()){
            int cur[] = que.poll();

            int z = cur[0];
            int r = cur[1];
            int c = cur[2];
            int cnt = cur[3];

            if(cntChk !=cnt){
                cntChk = cnt;
                if(isFinish()){
                    ans = cnt;

                    return ;
                }

            }


            for(int i = 0 ; i < 6 ;i++){


                if( i== 4 || i == 5){
                    int mz = z;
                    if(i == 4) {
                        mz = z+1;
                    }
                    if(i == 5) {
                        mz = z-1;
                    }

                    if(mz >= 0 && mz <h){

                        if( map[mz][r][c] == 0){
                            map[mz][r][c] = cnt+1;
                            que.add(new int[] {mz,r,c,cnt+1});
                        }

                    }
                }else{
                    int mr = r+a[i];
                    int mc = c+b[i];
                    if( mr >=0  && mc>=0 && mr<n && mc<m){
                        if( map[z][mr][mc] == 0){
                            map[z][mr][mc] = cnt+1;
                            que.add(new int[] {z,mr,mc,cnt+1});
                        }
                    }


                }


            }

        }



    }


    public static boolean isFinish(){

//        if(cnt != ans){
//            ans = cnt;
//            System.out.println(cnt);
//            for(int i = 0 ; i < h ; i++){
//                for(int j = 0 ; j < n ; j++){
//                    for(int k = 0 ; k <m; k ++){
//                        System.out.print(map[i][j][k]);
//                    }
//                    System.out.println();
//                }
//            }
//            System.out.println("------------------------------------");
//
//        }

        for(int i = 0 ; i < h ; i++){
            for(int j = 0 ; j < n ; j++){
                for(int k = 0 ; k <m; k ++){
                    if(map[i][j][k] == 0) return false;
                }
            }
        }






        return true;

    }





}
