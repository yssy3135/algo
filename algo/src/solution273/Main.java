package solution273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 9007 카누선수(이분탐색)
public class Main {
    static int group[][];
    static int sumGroup[][];
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        for(int tc = 0 ; tc< t; tc++){

            StringTokenizer st= new StringTokenizer(br.readLine());

            //보트의 특정값
            k = Integer.parseInt(st.nextToken());
            //각 반의 학생수
            int n = Integer.parseInt(st.nextToken());

            group = new int[4][n];
            sumGroup = new int[2][n*n];


            for(int i = 0 ; i < 4; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < n ;j++){
                    group[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int idx = 0;
            for(int i = 0 ; i < n; i++){
                for(int j = 0 ; j < n ;j++){
                    sumGroup[0][idx] = group[0][i] + group[1][j];
                    sumGroup[1][idx] = group[2][i] + group[3][j];
                    idx++;
                }
            }
            Arrays.sort(sumGroup[0]);
            Arrays.sort(sumGroup[1]);

            bs(n);


        }

    }

    public static void bs(int n){

        int min = Integer.MAX_VALUE;
        int ans = 0;
        boolean flag = false;

        for(int i = 0 ; i < n*n;i++) {
            int first = 0;
            int last = (n * n) - 1;
            int mid = 0;
            int target = k - sumGroup[0][i];

            while (first <= last) {
                mid = (first + last) / 2;

                if(min == Math.abs(target - sumGroup[1][mid]) && ans > sumGroup[0][i] + sumGroup[1][mid] ){
                    ans = sumGroup[0][i] + sumGroup[1][mid];
                }

                else if (min > Math.abs(target - sumGroup[1][mid])){
                    min = Math.abs(target - sumGroup[1][mid]);
                    ans = sumGroup[0][i] + sumGroup[1][mid];
                }



                if (target == sumGroup[1][mid]) {
                    System.out.println(k);
                    flag = true;
                    break;

                } else if (sumGroup[1][mid] < target) {
                    first = mid + 1;
                } else {
                    last = mid - 1;
                }


            }

            if(flag) break;

        }

        if(!flag) {
            System.out.println(ans);
        }

    }


}
