package solution298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//백준 1654 랜선자르기(이분탐색)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int num[] = new int[k];

        for(int i = 0 ; i < k; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);

        long left = 1;
        long right = num[k-1];
        long max = 0;

        while(left <= right){
            //랜선길이 mid
            long mid = (left+right)/2;

            long cntSum = 0;
            for(int i = 0 ; i < k;i++){
                cntSum += num[i]/mid;
            }


            if(cntSum >= n){
                //자른게 n개 인데 최대치를 뽑아야한다.
                max = mid;
                left = mid+1;

            }else{
                right = mid-1;

            }


        }
            System.out.println(max);


    }



}
