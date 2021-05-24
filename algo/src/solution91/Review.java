package solution91;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 9663 N-Queen
public class Review {

    static int map[];
    static boolean visited[];
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n];

        for(int i = 0 ; i < n;i++){
            // 배열 안에 들어같 값이 row 값
            map = new int[n];

            map[0] = i;
            recursive(1,n);

        }
        System.out.println(ans);

    }


    public static void recursive(int col,int n){
        if(col == n){
            ans++;
            return ;
        }

        for(int i = 0 ; i < n; i++){
            map[col] = i;
            if(chk(col)){
                recursive(col+1,n);
            }
        }

    }

    public static boolean chk(int col){

        for(int i = 0 ; i < col;i++){
            if(map[i] == map[col]) return false;

            if(Math.abs(map[col] - map[i]) == Math.abs(col-i) ) {

                return false;
            }


        }


        return true;
    }






}
