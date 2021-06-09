package solution288;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 1976 여행가자(유니온 파인드)
public class Main {
    static int num[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        num = new int[n+1];
        for(int i = 1 ; i <=n ;i++){
            num[i] = i;
        }

        for(int i = 1 ; i <= n ; i++){
            String tmp[] = br.readLine().split(" ");
            for(int j = 1 ; j  <= n;j++){
                int num = Integer.parseInt(tmp[j-1]);
                if(num == 1){
                    if(!isUnion(i,j)){
                        union(i,j);
                    }

                }
            }
        }

        String plan[] = br.readLine().split(" ");
        int planToint[] = new int[plan.length];
        for(int i = 0 ; i < plan.length;i++){
            planToint[i] = Integer.parseInt(plan[i]);
        }
        String ans = "YES";
        Loop:
        for(int i = 0 ; i < planToint.length-1;i++){
            for(int j = i+1; j < planToint.length;j++){
                if(!isUnion(planToint[i],planToint[j])){
                    ans = "NO";
                    break Loop;
                }
            }
        }
        System.out.println(ans);


    }

    public static int find(int x){
        if( num[x] == x) return x;

        return num[x] = find(num[x]);
    }



    public static void union(int a,int b){
        a = find(a);
        b = find(b);

        if(a < b){
            num[b] = a;
        }else{
            num[a] = b;
        }

    }

    public static boolean isUnion(int a,int b){
        a= find(a);
        b = find(b);

        if(a == b){
            return true;
        }else{
            return false;
        }

    }


}
