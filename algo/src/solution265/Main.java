package solution265;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 1406 에디터
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        char str[] = br.readLine().toCharArray();

        int n = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();


        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < str.length ; i++){
            left.push(str[i]);
        }

        for(int i = 0; i < n; i++){
            char order[] = br.readLine().toCharArray();

            if(order[0] =='L'){
                if(!left.isEmpty()){

                    right.add(left.pop());

                }
            }else if (order[0] =='D'){
                if(!right.isEmpty()){
                    left.push(right.pop());
                }

            }else if ( order[0] =='B'){
                if(!left.isEmpty()){
                    left.pop();
                }
            }else{
                char word = order[2];
                left.push(word);
            }

        }

        while(!left.isEmpty()){
            right.push(left.pop());
        }
        while(!right.isEmpty()){

            sb.append(right.pop());
        }




        System.out.println(sb.toString());




    }
}
