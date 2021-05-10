package solution236;

import java.lang.reflect.AnnotatedArrayType;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        int fares[][] = {	{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9} };
        solution(6,4,5,6,fares);


    }

    static class Node {
        int conNode;
        int weight;

        public Node(int conNode, int weight) {
            this.conNode = conNode;
            this.weight = weight;
        }
    }

    static ArrayList<Node> list[];
    static int dis[];
    static boolean visited[];
    static int floydArr[][];
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;

        list = new ArrayList[n+1];
        dis = new int[n+1];
        visited = new boolean[n+1];
        floydArr= new int[n+1][n+1];

        for(int arr[] : floydArr){
            Arrays.fill(arr,20000001);
        }

        for(int i = 1 ; i < n+1;i++){
            list[i] = new ArrayList<Node>();
        }

        for(int i = 0 ; i < fares.length;i++) {
            int c = fares[i][0];
            int d = fares[i][1];
            int f = fares[i][2];

            list[c].add(new Node(d,f));
            list[d].add(new Node(c,f));

            floydArr[c][d] = Math.min(floydArr[c][d],f);
            floydArr[d][c] = Math.min(floydArr[d][c],f);
        }

        //다익스트라
        dijkstra(a);
        int Aarr[] = dis.clone();
        System.out.println(Arrays.toString(dis));
        dijkstra(b);
        int Barr[] = dis.clone();
        dijkstra(s);
        int Sarr[] = dis.clone();

        int sharemin = Integer.MAX_VALUE;
        int solomin = Integer.MAX_VALUE;

        for(int i = 1 ; i <=n ;i++){
            if(Sarr[i] == 20000001 || Aarr[i] == 20000001 ||Barr[i] == 20000001) continue;

            sharemin = Math.min(sharemin,Sarr[i]+Aarr[i]+Barr[i]);
        }
        solomin = Sarr[a] +Sarr[b];

        answer = Math.min(sharemin,solomin);

        System.out.println(answer);
        //다익스트라


        // 플로이드
//        floyd(n,s,a,b);
//
//        int sharemin = Integer.MAX_VALUE;
//        int solomin = Integer.MAX_VALUE;
//        for(int i = 1 ; i <=n ;i++){
//            if(floydArr[s][i] == 20000001 || floydArr[s][a] == 20000001 || floydArr[s][b] == 20000001) continue;
//
//            sharemin = Math.min(sharemin,floydArr[s][i]+floydArr[a][i]+floydArr[b][i]);
//        }
//        solomin = floydArr[s][a] +floydArr[s][b];
//
//        answer = Math.min(sharemin,solomin);
//
//        System.out.println(answer);
        // 플로이드



        return answer;
    }

    public static void floyd(int n,int s,int a,int b){
        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ;j <= n;j++){
                for(int k = 1 ; k <= n ; k++){
                    if(j==k ) {
                        floydArr[j][k] = 0;
                        continue;
                    }
                    floydArr[j][k] = Math.min(floydArr[j][k],floydArr[j][i]+floydArr[i][k]);

                }
            }
        }

    }



    public static void dijkstra(int start){
        Arrays.fill(dis,Integer.MAX_VALUE);
        Queue<Node> pq=  new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.weight,o2.weight);
            }
        });
        dis[start]= 0;
        pq.add(new Node(start,0));
        while (!pq.isEmpty()){
            int cur = pq.peek().conNode;
            int weight = pq.peek().weight;

            pq.poll();

            if(dis[cur]< weight) continue;

            for(int i = 0 ; i < list[cur].size();i++){
                int get = list[cur].get(i).conNode;
                int getWeight = list[cur].get(i).weight;


                if(dis[get] > weight + getWeight){

                    dis[get] = weight + getWeight;
                    pq.add(new Node(get,dis[get]));
                }


            }


        }

    }


}

