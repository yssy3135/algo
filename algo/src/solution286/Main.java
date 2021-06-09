package solution286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 11404 플로이드( 플로이드 와샬)
public class Main {

    static int map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        for(int i =0 ; i < map.length;i++){
            Arrays.fill(map[i],10000001);
        }
        for(int i = 0 ; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[a][b] = Math.min(map[a][b],cost);

        }


        for(int  k= 1 ; k <= n ;k++){
            for(int i = 1 ; i <= n;i++){
                for(int j = 1 ; j <= n ;j++){
                    if(k == i || i == j || j == k) continue;
                    map[i][j] = Math.min(map[i][j],map[i][k] + map[k][j]);

                }
            }
        }

        for(int i = 1 ; i <= n;i++){
            for(int j  = 1; j <= n ; j++){
                if(i == j || map[i][j] == 10000001){
                    System.out.print(0+" ");
                }else{
                    System.out.print(map[i][j]+" ");
                }

            }
            System.out.println();
        }

    }
}
