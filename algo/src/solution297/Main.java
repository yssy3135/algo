package solution297;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 1948 임계경로 (위상정렬) 복습필수
public class Main {
    static class Node{
        int Node;
        int time;

        public Node(int Node, int time) {
            this.Node = Node;
            this.time = time;
        }
    }


    static ArrayList<Node> list[];
    static ArrayList<Node> reversList[];
    static int num[];
    static int reverseNum[];
    static int nodeSum[];
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        num = new int[n+1];
        reverseNum = new int[n+1];
        list = new ArrayList[n+1];
        reversList = new ArrayList[n+1];
        visited = new boolean[n+1];
        nodeSum = new int[n+1];
        for(int i = 1 ; i <=n ;i++){
            list[i] = new ArrayList<>();
            reversList[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b,c));
            reversList[b].add(new Node(a,c));
            num[b]++;
            reverseNum[a]++;

        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        topology(start,end);

    }

    public static void topology(int start,int end){
        Queue<Node> que = new LinkedList<>();

        que.add(new Node(start,0));

        while(!que.isEmpty()){
            Node cur = que.poll();

            for(int i = 0 ; i < list[cur.Node].size();i++){
                Node next = list[cur.Node].get(i);
                num[next.Node]--;

                nodeSum[next.Node] = Math.max(nodeSum[next.Node],nodeSum[cur.Node]+next.time);
                if(num[next.Node] == 0) {

                    que.add(next);
                }

            }

        }
        //역추적
        int max = nodeSum[end];
        int cnt = 0;
        que.add(new Node(end,0));

        while(!que.isEmpty()){
            Node cur = que.poll();

            for(int i = 0 ; i < reversList[cur.Node].size();i++){
                Node next = reversList[cur.Node].get(i);
                reverseNum[next.Node]--;


                    if(nodeSum[next.Node] == nodeSum[cur.Node] - next.time){
                        cnt++;
                        //방문 카운트를 한번만 해줘야하기때문에
                        if(!visited[next.Node]){
                            visited[next.Node] = true;
                            que.add(next);
                        }
                    }
            }

        }

        System.out.println(max);
        System.out.println(cnt);


    }



}
