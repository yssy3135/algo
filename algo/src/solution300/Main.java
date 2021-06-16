package solution300;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//백준 1756 피자굽기 (구현,이분탐색)
public class Main {
    static long num[];
    static long pizza[];
    static int n;
    static int d;
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());


        String tmp[] = br.readLine().split(" ");
        num = new long[d];
        for(int i = 0 ; i < d; i++){
            num[i] = Long.parseLong(tmp[i]);
            if(i > 0 && num[i] > num[i-1]){
                num[i] = num[i-1];
            }
        }



        tmp = br.readLine().split(" ");
        pizza = new long[n];
        int pre = d;
        int ans = 0;
        for(int i = 0 ; i < n ;i++){
            pizza[i] = Long.parseLong(tmp[i]);

            pre = binary(pizza[i],pre);
            ans = pre;
            if(pre == -1){
                break;
            }
        }

        System.out.println(ans+1);



    }


    public static int binary(long target,int pre){

        int left = 0;
        int right = pre;
        while(left <= right){
           int mid = (left+right)/2;


           if(target <= num[mid]){
               left = mid+1;
           }else{

               right = mid-1;
           }

        }




        return right;
    }

}
