package solution290;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//백준 2805 나무 자르기 (이분탐색) 다시 풀어보기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long num[] = new long[(int) n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        long left = 0 ;
        long right = num[(int) (n-1)];

        long ans = 0;
        while(left <= right){
            long mid = (left+right)/2;

            long sum = 0;
            // 나무를 mid 로 잘라본다
            for(int i = 0 ; i < n;i++){
                if(num[i] > mid){
                    sum += num[i]-mid;
                }
            }

            if(sum >= m){
                ans = mid;
                left = mid+1;

            }else{
                right = mid-1;
            }



        }
        System.out.println(ans);





    }
}
