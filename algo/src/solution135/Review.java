package solution135;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


//백준 2667 단지번호 붙이기
public class Review {
    static int map[][];
    static boolean visited[][];
    static int a[] ={1,-1,0,0};
    static int b[] = {0,0,1,-1};
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0 ; i < n; i++){
            String tmp[] = br.readLine().split("");
            for(int j = 0 ; j < n ;j++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 0;
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < n;j++){
                if(!visited[i][j] && map[i][j] == 1){
                    visited[i][j] = true;
                    cnt++;
                    list.add(dfs(i,j));
                }
            }
        }

        list.sort(null);
        System.out.println(cnt);
        for(int num : list){
            System.out.println(num);
        }

    }


    public static int dfs(int r,int c){

        int sum = 1;
        for(int i = 0 ; i < 4;i++){

            int mr = r+a[i];
            int mc = c+b[i];
            if(mr >=n || mc >= n || mr <0 || mc<0)continue;
            if(map[mr][mc]!=0 && !visited[mr][mc]){
                visited[mr][mc] = true;
                sum +=dfs(mr,mc);
            }

        }

        return sum;
    }


}
