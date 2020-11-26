package algo;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution36 {
	
	static int[][] arr;
	static ArrayList<Integer> list[];
	static boolean[] visited;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		ans = 0;
		visited = new boolean[N];
		list = new ArrayList[N];
		
		for(int i = 0 ; i < N ;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		
		for(int i = 0 ; i < M ;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list[a].add(b);
			list[b].add(a);
		}
		

		for(int i = 0 ; i < N ;i++) {
			if(ans == 0 ) {
				
				dfs(i,1);
			}
		}
		
		System.out.println(ans);
		
		
		
	} // main end
	
	public static void dfs(int i,int depth) {
		if(depth == 5) {
			ans = 1;
			return;
		}
		
		
		visited[i] = true;
		for(int j : list[i]) {
			if(!visited[j] ) {
				dfs(j,depth+1);
			}
			
		}
		visited[i] = false;
		
		
		
	}
	
	
	
}
