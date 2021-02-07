package solution105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String map[][];
    static int a[] = {0,0,1,-1};
    static int b[] = {1,-1,0,0};
    static boolean  visited[][];
    static int c;
    static int r;

    public static class Jf {
            int r;
            int c;
            int type;
            int cnt;

        public Jf(int r, int c, int type, int cnt) {
            this.r = r;
            this.c = c;
            this.type = type;
            this.cnt = cnt;
        }
    };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new String[r][c];
        visited = new boolean[r][c];

        ArrayList<int[]> list = new ArrayList<int[]>();


        int jihoon[] = new int[2];
        int fire[] = new int[2];
        for(int i = 0 ; i< r ; i++){
            String tmp[] = br.readLine().split("");
            for(int j = 0 ; j < tmp.length; j++){
                map[i][j] = tmp[j];
                if(tmp[j].equals("J")){
                    map[i][j] = ".";
                    jihoon[0] = i;
                    jihoon[1] = j;
                }else if (tmp[j].equals("F")){
                    map[i][j] = "F";
                    list.add(new int[] {i,j});
                }

            }

        }// for end

        bfs(jihoon,fire,list);


    }


    public static void bfs(int jihoon[],int fire[],ArrayList<int[]> list){
        Queue<Jf> que = new LinkedList<Jf>();

        for(int i = 0 ; i <list.size();i++){
            que.add(new Jf(list.get(i)[0],list.get(i)[1],1,0));
        }

        que.add(new Jf(jihoon[0],jihoon[1],0,0));

        visited[jihoon[0]][jihoon[1]]= true;

        while(!que.isEmpty()){
            Jf jf = que.poll();
            int nr = jf.r;
            int nc = jf.c;

            if((nr == r-1 || nc == c-1|| nr == 0 || nc == 0) &&  jf.type == 0){
                System.out.println(jf.cnt+1);
                return ;
            }


            for(int i = 0 ; i < 4; i++){
                int mc = nc+a[i];
                int mr = nr+b[i];

                if(jf.type == 1) {
                    if(mc >=0 && mr >=0 && mc < c && mr <r ){
                        if(map[mr][mc].equals(".")){
                            map[mr][mc] = "F";
                            que.add(new Jf(mr,mc,jf.type,jf.cnt+1));

                        }
                    }
                }else{
                    if(mc >=0 && mr >=0 && mc < c && mr <r ){
                        if(map[mr][mc].equals(".") && !visited[mr][mc]){
                            System.out.println("mr"+mr+"mc"+mc);
                            visited[mr][mc] = true;
                            que.add(new Jf(mr,mc,jf.type,jf.cnt+1));
                        }


                    }
                }

            }
        }
        System.out.println("IMPOSSIBLE");



    }




}
