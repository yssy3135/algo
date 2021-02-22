package solution117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	
	static int before[] = new int[100001];
	static int time[] = new int[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br= new  BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		
		bfs(n,k);
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(k);
		int idx = k;
		
		while(idx!= n) {
			stack.push(before[idx]);
			idx = before[idx];
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		
	}
	
	
	public static void bfs(int n, int k) {
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.add(n);
		time[n] = 1;
		while(!que.isEmpty()) {
			int now = que.poll();
			
			if(now == k) {
				System.out.println(time[now] -1 );
				return;
				
			}
			
			for(int i = 0 ; i < 3; i++) {
				int next;
				if( i == 0 ) {
					next = now+1;
				}else if (i == 1) {
					next = now - 1;
				}else {
					next = now *2;
				}
				
			
			
				if (next < 0 || next > 100000) continue;
				
				
				if(time[next] == 0) {
					que.add(next);
					time[next] = time[now]+1;
					before[next] = now;
					
				}
				
			}
			
		}
	
			
		
		
	}
	
}
