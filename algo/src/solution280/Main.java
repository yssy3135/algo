package solution280;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



//백준 14391 종이조각 (백트래킹,완탐) 비트마스킹으로 풀어보기
public class Main {
    static int map[][];
    static boolean visited[][];
    static int n;
    static int m;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            String tmp[] = br.readLine().split("");
            for(int j = 0 ; j < m;j++){
                map[i][j] = Integer.parseInt(tmp[j]);

            }
        }

        //왼쪽에서 오른쪽
        //위쪽에서 아래래

        recursive(0,0);

        System.out.println(max);
    }


    public static void  recursive(int r,int c){

        if(r == n ){


            max = Math.max(sum(),max);

            return;
        }


        if(c >= m){

            recursive(r+1,0);
            return;
        }

        //세로자르기
        visited[r][c] = true;
        recursive(r,c+1);

        //가로자르기
        visited[r][c] = false;
        recursive(r,c+1);



    }

    public static int sum(){

        int sum = 0;
        for(int i = 0 ; i < n ;i++){
            StringBuilder sb = new StringBuilder();
            int combo = -1;
            int rowSum = 0;
            for(int j = 0 ; j < m;j++){
                if(!visited[i][j]){
                    sb.append(map[i][j]);
                    combo++;
                }else{
                    if(sb.length() >0){
                        rowSum += Integer.parseInt(sb.toString());
                        combo = -1;
                        sb.setLength(0);

                    }
                }
            }

            if(sb.length() >0){
                rowSum += Integer.parseInt(sb.toString());
            }

            sum +=rowSum;
        }

        for(int i = 0 ; i < m ;i++){
            StringBuilder sb = new StringBuilder();
            int combo = -1;
            int colSum = 0;
            for(int j = 0 ; j < n;j++){
                if(visited[j][i]){
                    sb.append(map[j][i]);
                    combo++;
                }else{
                    if(sb.length() >0){
                        colSum += Integer.parseInt(sb.toString());
                        combo = -1;
                        sb.setLength(0);

                    }
                }
            }

            if(sb.length() >0){
                colSum += Integer.parseInt(sb.toString());
            }
            sum +=colSum;

        }

        return sum;


    }


}
