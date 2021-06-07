package solution278;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//백준 2169 로봇 조종하기(dp) 복습해보기
public class Main {

    static int map[][];
    static long dp[][][];
    static int a[] = {0,-1,0};
    static int b[] = {1,0,-1};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        map = new int[n][m];
        dp = new long[n][m][3];


        for(int i = 0 ; i < n ;i++){
            st=  new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < m ;j++){
                for(int k = 0 ; k < 3 ; k++){
                    dp[i][j][k] = -10000002;
                }
            }
        }


        dp[0][0][0] = map[0][0];
        dp[0][0][1] = map[0][0];
        dp[0][0][2] = map[0][0];


        long max = -10000002;
        for(int i = 0 ; i < 3 ; i++){
            max = Math.max(recursive(n-1,m-1,i),max);
        }

        System.out.println(max);

    }


    public static long recursive(int r,int c,int k){

        if(dp[r][c][k] != -10000002) return dp[r][c][k];


        // 0 부터 오른쪽 위 왼쪽

        int mr = r + a[k];
        int mc = c + b[k];

        if(mr >= n || mc >= m || mr <0 || mc <0) {

            return -10000002;
        }else{

            if(k == 0){
                //오른쪽에서 왔으면 위쪽 왼쪽에서 온거랑 비교
                dp[r][c][k] = Math.max(recursive(mr,mc,1),recursive(mr,mc,0)) + map[r][c];
            }else if ( k == 1){
                dp[r][c][k] = Math.max(recursive(mr,mc,0), Math.max(recursive(mr,mc,2),recursive(mr,mc,1))) + map[r][c];
            }else{
                dp[r][c][k] = Math.max(recursive(mr,mc,2),recursive(mr,mc,1)) + map[r][c];
            }
            return dp[r][c][k];

        }





    }




}
