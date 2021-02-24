package solution119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int g = Integer.parseInt(br.readLine());

		// 현재 몸무게의 제곱에서  기억하고 있던 몸무게의 제곱을 뺸것.
		// 현재 몸무게가 기억하고 있던 몸무게보다 무조건 크니까 end
		int weight = 0;
		int start= 1 ;
		int end = 1;
		int cnt = 0;
		
		while(start <= end && end <50001 ) {
		
			weight = (int) (Math.pow(end, 2) - Math.pow(start, 2));
			
			if(weight == g) {
				System.out.println(end);
				cnt++;
				end++;
			}else if(weight > g) {
				start++;
			}else  {
				end++;
			}
			
		}
		if(cnt == 0) System.out.println(-1);

		
	}
}
