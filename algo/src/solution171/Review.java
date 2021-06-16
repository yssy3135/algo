package solution171;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 14567 선수과목(위상정렬,dp) 복습
public class Review {
    static ArrayList<Integer> list[];
    static int level[];
    static int num[];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        level = new int[n+1];
        num = new int[n+1];
        for(int i = 1 ; i <=n;i++){
            list[i] = new ArrayList<>();
        }


        for(int i = 0 ; i < m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            num[b]++;
        }

        topology();

        for(int i = 1 ; i <= n; i++){
            System.out.print(level[i]+" ");
        }

    }

    public static void topology(){
        Queue<Integer> que = new LinkedList<>();
        for(int i = 1 ;  i <= n ;i++){
            if(num[i] == 0){
                que.add(i);
                level[i] = 1;
            }
        }

        while(!que.isEmpty()){
            int cur = que.poll();

            for(int i = 0 ; i <list[cur].size() ;i++){
                int get = list[cur].get(i);
                num[get]--;

                if(num[get] == 0){
                    que.add(get);
                    level[get] = level[cur]+1;
                }
            }


        }



    }

}
