package solution299;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//백준 2110 공유기설치(이분탐색,파라메트릭서치) 복습해보기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int num[] = new int[n];
//        문제에서 요구하는것은 간격이다.


        for(int i = 0 ; i < n;i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);
        int left = 1;
        int right = num[n-1]-1;
        int max = 0;
        while (left<= right){
            int mid = (left + right)/2;
            //mid의 간격만큼 공유기를 설치한다.
            //처음에는 맨 왼쪽에 설치
            int install  = 1;
            int pre = num[0];

            for(int i = 0 ; i < n;i++){
                if(num[i]-pre >=mid){
                    pre = num[i];
                    install++;
                }
            }

            if (install >= c) {
                max = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        System.out.println(max);


    }
}
