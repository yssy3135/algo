package solution284;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 1162 도로포장 (다익스트라,dp)꼭 다시풀기
public class Main {
    static class Node{
        int nodeNum;
        long cost;
        int cnt;

        public Node(int nodeNum, long cost, int cnt) {
            this.nodeNum = nodeNum;
            this.cost = cost;
            this.cnt = cnt;
        }
    }

    static ArrayList<Node> list[];
    static long dist[][];
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //포장할 도로의 수
        k = Integer.parseInt(st.nextToken());

        dist = new long[n+1][k+1];
        list = new ArrayList[n+1];

        for(int i = 1 ; i <= n ;i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b,c,0));
            list[b].add(new Node(a,c,0));

        }
        dijkstra(1);
        long ans = Long.MAX_VALUE;
        for(int i = 0 ; i <= k ; i++){
            ans = Math.min(ans,dist[n][i]);
        }

        System.out.println(ans);
    }



    public static void dijkstra(int start){
        for(int i  =0 ; i < dist.length ; i++){
            Arrays.fill(dist[i],Long.MAX_VALUE);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return (int) (o1.cost-o2.cost);
            }
        });

        Arrays.fill(dist[start],0);
        pq.add(new Node(start,0,0));


        while(!pq.isEmpty()){
            int cur = pq.peek().nodeNum;
            long curCost = pq.peek().cost;
            int curCnt = pq.peek().cnt;
            pq.poll();


            if(dist[cur][curCnt] < curCost) continue;

            for(int i = 0 ; i < list[cur].size();i++){
                int get = list[cur].get(i).nodeNum;
                long getCost = list[cur].get(i).cost;


                //도로 포장을 하는 경우
                if(curCnt+1 <= k &&dist[get][curCnt+1] > dist[cur][curCnt]){
                    dist[get][curCnt+1] = dist[cur][curCnt];
                    pq.add(new Node(get,dist[get][curCnt+1],curCnt+1));

                }


                //도로 포장을 하지 않는 경우
                if(dist[get][curCnt] > dist[cur][curCnt] + getCost){
                    dist[get][curCnt] = dist[cur][curCnt] + getCost;
                    pq.add(new Node(get,dist[get][curCnt],curCnt));
                }

            }


        }






    }

}
