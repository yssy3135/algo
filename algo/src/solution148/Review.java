package solution148;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Review {
    static int arr[];
    static boolean visited[];
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        permu(0,n,new int[n]);

        System.out.println(ans);

    }

    public static void permu(int index,int n,int output[]){

        if(index == n){

            int sum = 0;
            for(int i = 0 ;i < n-1;i++){
                sum += Math.abs(output[i]-output[i+1]);
            }
            ans = Math.max(ans,sum);

            return ;
        }

        for(int i = 0 ; i < n;i++){
            if(!visited[i]){
                visited[i] = true;
                output[index] = arr[i];
                permu(index+1,n,output);
                visited[i]=false;


            }
        }

    }



}
