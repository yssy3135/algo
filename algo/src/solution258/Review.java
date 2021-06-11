package solution258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//백준 1766 문제집(위상정렬) 복습
public class Review {

    static int num[];
    static ArrayList<Integer> list[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        num =  new int[n+1];


        for(int i = 1 ; i <=n ;i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m ;i++){
            st= new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            num[b]++;
        }

        topology(n);

        System.out.println(sb.toString());


    }

    public static void topology(int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 더이상 연결된 것이 없을 때 pq에 들어가는데 숫자가 작을수록 난이도가 작으니까
        // 작은게 먼저 나오기 위해서 priorityque 사용
        for(int i = 1 ; i <=n ;i++ ){
            if(num[i] == 0){
                pq.add(i);
            }
        }

        while(!pq.isEmpty()){
            int cur = pq.poll();
            sb.append(cur+" ");

            for(int i = 0 ; i < list[cur].size();i++){
                int get = list[cur].get(i);
                num[get]--;

                if(num[get] == 0 ){

                    pq.add(get);
                }
            }


        }



    }


}
