package solution226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> list[];
    static boolean visited[];
    static int cnt = 1;
    static int num[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 수
        int n = Integer.parseInt(st.nextToken());
        //루트의 번호
        int r = Integer.parseInt(st.nextToken());
        //쿼리의 수
        int q = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        num = new int[n+1];


        for(int i = 1 ; i <= n;i++){
            list[i] = new ArrayList<Integer>();

        }

        for(int i = 0 ; i < n-1;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);

        }
        Arrays.fill(num,1);

        visited[r] = true;
        dfs(r);


        for(int i = 0 ; i < q;i++){
            int root = Integer.parseInt(br.readLine());
            System.out.println(num[root]);
//            System.out.println(Arrays.toString(num));
        }


    }
    public static int dfs(int start){
        for(int i = 0 ; i < list[start].size();i++){
            if(!visited[list[start].get(i)]){

                cnt++;
                visited[list[start].get(i)] =true;
                num[start]+=dfs(list[start].get(i));
            }
        }

        return  num[start];

    }


}




