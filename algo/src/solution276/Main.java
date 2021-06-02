package solution276;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//백준 1477 휴게소 새우기 (파라매트릭서치,이분탐색)
public class Main {

    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        arr = new int[n+2];

        st = new StringTokenizer(br.readLine());
        arr[0] = 0;
        arr[n+1] = l;
        for(int i = 1 ; i <= n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        bs(n,m,l);

    }


    public static void bs(int n,int m,int l){

        int left = 0;
        int right = l;

        while( left <=right){
            int mid = (left+right)/2;
            int cnt = 0;

            for(int i = 1 ; i <= n ;i++){
                //두 휴게소 사이 거리
                cnt += (arr[i] - arr[i-1] -1)/mid;

            }

            if(cnt >m){
                //추가하는 개수보다 더 많이 들어갈 수 있다.
                //범위를 넓혀야한다.
                left = mid+1;
            }else{
                right = mid-1;
            }


        }

        System.out.println(left);


    }


}
