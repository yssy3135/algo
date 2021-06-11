package solution142;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//백준 2252 줄 세우기 (위상정렬) 복습
public class Reveiw {
    static int num[];
    static ArrayList<Integer> list[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        num = new int[n+1];
        list = new ArrayList[n+1];

        for(int i = 1 ; i <=n ;i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m ;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            num[b]++;
        }

        topology(n);

        System.out.println(sb.toString());

    }

    public static void topology(int n){
        Queue<Integer> que = new LinkedList<>();

        for(int i = 1 ; i <= n ;i++){
            if(num[i] == 0){
                sb.append(i+" ");
                que.add(i);
            }
        }

        while(!que.isEmpty()){

            int cur = que.poll();


            for(int i = 0 ; i < list[cur].size();i++){
                int get = list[cur].get(i);

                num[get]--;

                if(num[get] == 0){
                    sb.append(get+" ");
                    que.add(get);
                }

            }




        }



    }

}
