package solution259;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 10775 공항(Union-Find)
public class Main {

    static int num[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        num = new int[g+1];

        for(int i = 1 ; i <=g ; i++){
            num[i]= i;
        }

        // g번 비행기는 g번 이하 게이트에만 도킹이 가능함.
        // 이 때, g번 비행기를 g번 게이트에 도킹하는 것이 최선임.
        // 만약, g번 비행기를 g번게이트에 도킹할 수 없다면,
        // g-1번 게이트에 차선책으로 도킹시킴.
        // 이 때, 차선책이 0번을 가리키고 있으면 도킹이 불가능한 상태임.
        // 차선책을 찾는 과정에서 유니온 파인드를 사용함.
        int ans = 0;
        for(int i = 0 ;i < p;i++){
            int pNum = Integer.parseInt(br.readLine());

            int space = getParent(pNum);
            if(space == 0){
                break;
            }
            ans++;
            union(space,space-1);
        }

        System.out.println(ans);

    }

    public static int getParent(int x){
        if(num[x] == x) return x;

        return num[x]=getParent(num[x]);
    }

    public static void union(int a,int b){
        a = getParent(a);
        b = getParent(b);

        if( a !=b ){
            num[a] = b;
        }
    }


}
