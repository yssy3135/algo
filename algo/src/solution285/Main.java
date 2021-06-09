package solution285;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// 백준 11403 경로찾기(플로이드와샬) 문제이해
public class Main {
    static int map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];



        for(int i = 0 ; i < n;i++){
            String tmp[] = br.readLine().split(" ");
            for(int j = 0 ; j < n;j++){
                map[i][j]= Integer.parseInt(tmp[j]);
            }
        }


        for(int k = 0 ; k < n;k++){
            for(int i = 0 ; i < n;i++){
                for(int j  = 0 ; j < n ;j++){
                    if(map[i][k]  ==1 && map[k][j] == 1){
                        map[i][j] = 1;
                    }
                }
            }
        }

        for(int a[] : map){
            for(int b: a){
                System.out.print(b+" ");
            }
            System.out.println();
        }



    }
}
