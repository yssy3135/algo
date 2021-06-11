package solution289;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 9470 Strahler 순서 (위상정렬)
public class Main {
    static int num[];
    static int level[];
    static int levelCnt[];
    static ArrayList<Integer> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < t ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            num = new int[m+1];
            list = new ArrayList[m+1];
            level = new int[m+1];
            levelCnt = new int[m+1];
            for(int j = 1 ; j <= m ; j++){
                list[j] = new ArrayList<>();
            }

            for(int z = 0 ; z < p ; z++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                num[b]++;

            }


            System.out.println(k+" "+ topology(m));
        }




    }


    public static int topology(int m){
        Queue<Integer> que = new LinkedList<>();
        for(int i = 1 ; i <= m;i++){
            if(num[i] == 0){
                que.add(i);
                level[i]++;
            }
        }
        int ans = 0;
        while(!que.isEmpty()){
            int cur = que.poll();

            boolean flag = false;
            for(int i = 0 ; i < list[cur].size();i++){
                int get = list[cur].get(i);
                num[get]--;

                if(level[get] < level[cur]){
                    level[get] = level[cur];
                    levelCnt[get] = 1;
                }else if (level[get] == level[cur]){
                    levelCnt[get]++;
                }

                if(num[get] == 0){
                    flag = true;
                    que.add(get);
                    if(levelCnt[get] >1){
                        level[get] +=1;
                    }

                }

            }
            if(!flag){
                ans = level[cur];
            }



        }

        return ans;

    }

}
