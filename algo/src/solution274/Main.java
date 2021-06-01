package solution274;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//백준 11054 가장긴 바이토닉 수열(dp,LIS,LDS)
public class Main {
    static int idp[];
    static int ddp[];

    static int arr[];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());


        arr= new int[n];
        idp= new int[n];
        ddp = new int[n];
        for(int i = 0 ; i < n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS();
        LDS();

        int max =0;
        for(int i = 0 ; i < n;i++){
            max = Math.max(idp[i] + ddp[i],max);
        }

        System.out.println(max-1);


    }


    public static void LIS(){

        for(int i = 0 ; i < n ;i++){
            idp[i] = 1;

            for(int j = 0 ; j <i ; j++){

                if(arr[j] < arr[i] && idp[i] < idp[j] +1){
                        idp[i] = idp[j]+1;
                }


            }

        }


    }


    public static void LDS(){

        for(int i = n-1 ; i >=0  ;i--){
            ddp[i] = 1;

            for(int j = n-1 ; j >=i ; j--){

                if(arr[j] < arr[i] && ddp[i] < ddp[j] +1){
                    ddp[i] = ddp[j]+1;
                }


            }

        }


    }


}
