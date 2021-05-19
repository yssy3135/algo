package solution247;

import jdk.nashorn.internal.ir.Flags;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int ans = solve(br.readLine());

        if(flag){
            System.out.println(0);
        }else{

            System.out.println(ans);
        }


    }

    public static int solve(String input){

        if(flag) return 0;

        String str[] = input.split("");
        int cal = 0;

        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < str.length;i++){
            sb.append(str[i]);
            if(str[i].equals("(") || str[i].equals("[")){
                stack.add(str[i]);

            }else if(str[i].equals(")") || str[i].equals("]")){

                if(stack.isEmpty()) {

                    flag = true;
                    return 0;
                }

                if(stack.peek().equals("(") && str[i].equals(")")){
                    stack.pop();

                }else if(stack.peek().equals("[") && str[i].equals("]")){
                    stack.pop();
                }
            }

            if(stack.isEmpty()){
                //한개의 괄호 생성

                String outter = sb.toString().substring(1,sb.toString().length()-1);

                if(str[i].equals(")")){
                    if(outter.isEmpty()) {
                       cal +=2;
                    }else{
                        cal += solve(outter) *2;
                    }

                }else{
                    if(outter.isEmpty()) {
                        cal +=3;
                    }else{
                        cal += solve(outter) *3;
                    }
                }
                sb.setLength(0);
            }



        }


        if(!stack.isEmpty()){
            flag = true;
            return 0;
        }

        return cal;
    }


}
