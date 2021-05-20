package solution249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static ArrayList<Integer> list[];
    static boolean visited[];
    static int ans = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i = 1 ; i <= n;i++){
            list[i] = new ArrayList<>();
        }


        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < m ;i++){
            st = new StringTokenizer(br.readLine());

            int inputa = Integer.parseInt(st.nextToken());
            int inputb = Integer.parseInt(st.nextToken());

            list[inputa].add(inputb);
            list[inputb].add(inputa);
        }


        visited[a] = true;
        dfs(a,b,0);
        System.out.println(ans);

    }

    public static void dfs(int num,int target,int cnt){

        if(num == target){
            ans = cnt;
            return ;
        }


        for(int i = 0 ;i  < list[num].size();i++){
            int get = list[num].get(i);
            if(!visited[get]){
                visited[get] = true;
                dfs(get,target,cnt+1);
            }


        }


    }




}
