package solution231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //펠린드론 뒤집어 읽어도 같은 문자열
        //수미상관 앞쪽 절발이 뒤쪽 절반과 같은 문자열 (n이 홀수면 가운데 빼고 같아야한다. 짝수만 2/n 반이 같고 붙이면)

        //수미상관이면서 펠린드롬인 문자열

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n/2;i++){
            sb.append('a');
        }

        if(n%2 == 1){
            sb.append('b');
        }
        for(int i = 0 ; i < n/2;i++){
            sb.append('a');
        }

        System.out.println(sb.toString());
    }
}
