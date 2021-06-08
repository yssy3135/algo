package solution279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


//백준 1368 물대기(MST)
public class Main {
    static class Node{
        int a;
        int b;
        int cost;

        public Node(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }



    static int num[];
    static int digCost[];
    static ArrayList<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n =  Integer.parseInt(br.readLine());

        num = new int[n+1];
        digCost = new int[n+1];
        list = new ArrayList<>();



        for(int i = 1 ; i  <= n ;i++){
            num[i] = i;
            digCost[i] = Integer.parseInt(br.readLine());
            list.add(new Node(i,i,digCost[i]));
        }


        for(int i = 1 ; i <= n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n ;j++){
                int cost = Integer.parseInt(st.nextToken());
                if (i == j){
                    list.add(new Node(0,j,digCost[i]));
                }else{
                    list.add(new Node(i,j,cost));

                }
            }
        }

        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost-o2.cost;
            }
        });

        int sum = 0;
        for(int i = 0 ; i < list.size();i++){
            int a = list.get(i).a;
            int b = list.get(i).b;
            int cost = list.get(i).cost;

            if(!isUnion(a,b)){
                union(a,b);
                sum +=cost;
            }
        }

        System.out.println(sum);



    }


    public static int find(int x){
        if(num[x] == x) return x;

        return num[x] = find(num[x]);
    }


    public static void union(int a,int b){
        a = find(a);
        b = find(b);

        if(a<b){
            num[b] =a;
        }else{
            num[a] =b;
        }

    }

    public static boolean isUnion(int a,int b){
        a = find(a);
        b = find(b);

        if (a == b) {
            return true;
        }else{
            return false;
        }


    }




}
