package solution106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		
		String number[] = br.readLine().split("");
		
		Stack<Integer> stk = new Stack<Integer>();
		
		
		StringBuilder sb = new StringBuilder();
		
		int cnt = 0;
		for(int i = 0 ; i < n; i++) {
			
			int num = Integer.parseInt(number[i]);
			
			while(cnt < k && !stk.isEmpty()&& stk.peek() < num) {
				stk.pop();
				cnt++;
			}
			
			stk.add(num);
			
		}
		
		
		for(int i = 0 ; i< stk.size();i++) {
			sb.append(stk.get(i));
		}
		
		System.out.println(sb.toString());

	}
}
