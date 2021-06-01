package solution275;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.StringTokenizer;


//백준 12784 인하니카 공화국(dp,dfs)
public class Main {
    static class Node{
        int island;
        int dy;

        public Node(int island, int dy) {
            this.island = island;
            this.dy = dy;
        }
    }

    static ArrayList<Node> list[];
    static int num[];
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());


        for(int tc = 0 ; tc < t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken() );
            num = new int[n+1];
            visited = new boolean[n+1];
            list = new ArrayList[n+1];

            for(int i = 1 ; i <= n ;i++){
                list[i] = new ArrayList<>();
            }


            for(int i = 0 ; i < m ; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int dy = Integer.parseInt(st.nextToken());

                list[a].add(new Node(b,dy));
                list[b].add(new Node(a,dy));


            }


            int ans = 0;
            visited[1] = true;
            for(int i = 0 ; i < list[1].size();i++){
                visited[list[1].get(i).island]  = true;
                ans +=dfs(list[1].get(i).island,list[1].get(i).dy);

            }

            System.out.println(ans);

        }

    }

    public static int dfs(int num,int parentSum){



        int sum = 0;
        boolean flag = false;
        for(int i = 0 ; i < list[num].size();i++){
            Node get = list[num].get(i);

            if(!visited[get.island]){
                visited[get.island] = true;
                sum += dfs(get.island,get.dy);
                flag = true;
            }


        }
        if(!flag){
            return parentSum;
        }


        return sum <parentSum ? sum :parentSum;
    }


}
