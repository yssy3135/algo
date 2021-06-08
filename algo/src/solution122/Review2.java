package solution122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 1504 특정한최단경로(다익스트라)복습
public class Review2 {
    static class Node implements Comparable<Node>{
        int num;
        int dis;

        public Node(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return dis-o.dis;
        }
    }

    static ArrayList<Node> list[];
    static int num[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i = 0 ;i <= n ;i++){
            list[i] = new ArrayList<>();
        }
        num = new int[n+1];

        for(int i = 0 ; i < e; i++){
            String tmp[] = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int dis = Integer.parseInt(tmp[2]);

            list[a].add(new Node(b,dis));
            list[b].add(new Node(a,dis));

        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());


        if( e== 0){
            System.out.println(-1);
        }else{
            int sum1 = 0;
            int sum2 = 0;

            dijkstra(1);
            sum1+=num[v1];
            sum2+=num[v2];

            dijkstra(v1);

            sum1 +=num[v2];
            sum2 +=num[n];

            dijkstra(v2);
            sum2 +=num[v1];
            sum1+=num[n];

            System.out.println(Math.min(sum1,sum2));

        }


    }


    public static void dijkstra(int start){
        Arrays.fill(num,Integer.MAX_VALUE);
        num[start]= 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dis-o2.dis;
            }
        });
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            int cur = pq.peek().num;
            int curDis = pq.peek().dis;
            pq.poll();
            if(num[cur] < curDis) continue;

            for(int i = 0 ; i < list[cur].size();i++){
                Node get = list[cur].get(i);

                if(num[get.num] > curDis + get.dis){
                    num[get.num] = curDis +get.dis;

                    pq.add(new Node(get.num,curDis+get.dis));
                }


            }


        }




    }


}
