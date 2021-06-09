package solution287;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 1717 집합의 표현(Union-Find)
public class Main {
    static int num[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        num = new int[n+1];
        for(int i = 1 ; i <= n;i++){
            num[i] = i;
        }


        for(int i = 0 ; i < m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if( a == 0){
                union(b,c);
            }else{
                if(isUnion(b,c)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }


        }

    }

    public static int find(int x){
        if (num[x] == x) return x;

        return  num[x] = find(num[x]);
    }

    public static void union(int a,int b){
        a = find(a);
        b = find(b);

        if( a < b){
            num[b] = a;
        }else{
            num[a] = b;
        }


    }

    public static boolean isUnion(int a,int b){
        a = find(a);
        b = find(b);

        if( a== b){
            return true;
        }else{
            return false;
        }
    }



}
