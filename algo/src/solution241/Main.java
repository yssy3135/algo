package solution241;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());


        for(int i = 0 ; i < n;i++){
            String input = br.readLine();
            char method[] = input.toCharArray();

            if(method.length%2 ==0 ){
                System.out.println("NO");
            }else if (check(method,0,method.length-1)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }


        }


    }

    public static boolean check(char method[],int start,int end){


        if(start >= end)return true;
        int l = start;
        int r = end;
        while (l < r) {
            if(method[l] == method[r]) return false;

            l++;
            r--;
        }


        return check(method,start,r-1);

    }

}
