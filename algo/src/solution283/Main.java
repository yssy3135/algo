package solution283;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 13911 집 구하기 (다익스트라) 복습하기
public class Main {
    static class Node{
        int num;
        int dis;


        public Node(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }
    }

    static ArrayList<Node> list[];
    static int num[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정점의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());

        list = new ArrayList[v+3];
        num = new int[v+3];
        boolean chkHome[] = new boolean[v+3];
        for(int i = 1 ; i <=v+2;i++){
            list[i] = new ArrayList<>();
        }


        //도로의 개수
        int e = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < e ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b,cost));
            list[b].add(new Node(a,cost));

        }

        st = new StringTokenizer(br.readLine());
        // 맥도날드 수
        int m = Integer.parseInt(st.nextToken());
        // 맥세권일 조건
        int x = Integer.parseInt(st.nextToken());
        int mac[] = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m ;i++){
            int macNum = Integer.parseInt(st.nextToken());
            list[v+1].add(new Node(macNum,0));
            chkHome[macNum] = true;
        }

        dijkstra(v+1);
        int mdis[] = num.clone();

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int starbucks[] = new int[s];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < s;i ++){
            int startNum = Integer.parseInt(st.nextToken());
            list[v+2].add(new Node(startNum,0));
            chkHome[startNum] = true;
        }

        dijkstra(v+2);
        int sDis[] = num.clone();

        dijkstra(v+1);
        int mDis[] = num.clone();


        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i<=v;i++){
            if(sDis[i] <=y && mDis[i] <= x){
                if(!chkHome[i]){
                    min = Math.min(sDis[i]+mDis[i],min);
                }
            }


        }
        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{

            System.out.println(min);
        }





    }


    public static void dijkstra(int start){
        Arrays.fill(num,Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dis-o2.dis;
            }
        });
        pq.add(new Node(start,0));
        num[start] = 0;
        while(!pq.isEmpty()){
            int cur = pq.peek().num;
            int curDis = pq.peek().dis;
            pq.poll();

            if(num[cur] < curDis) continue;

            for(int i = 0 ; i < list[cur].size();i++){
                int getNum = list[cur].get(i).num;
                int getDis = list[cur].get(i).dis;

                if(num[getNum] > curDis + getDis){
                    num[getNum] = curDis + getDis;

                    pq.add(new Node(getNum,num[getNum]));

                }


            }



        }





    }



}
