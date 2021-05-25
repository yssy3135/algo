package solution258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//백준 1766 문제집(위상정렬)
public class Main {
    static int num[];
    static ArrayList<Integer> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];

        for(int i = 1 ; i <=n ;i++){
            list[i] = new ArrayList<>();
        }

        num = new int[n+1];
        for(int i = 0 ; i < m ;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            num[b]++;


        }

        System.out.println(topology(n));

    }

    public static String topology(int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 1 ; i <= n;i++){
            if(num[i] ==0 ){
                pq.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int cur = pq.poll();
            sb.append(cur+" ");
            for(int i = 0 ; i< list[cur].size();i++){
                int get = list[cur].get(i);
                num[get]--;

                if(num[get] == 0){
                    pq.add(get);
                }

            }

        }


        return sb.toString();
    }


}
