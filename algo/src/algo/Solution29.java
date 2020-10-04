package algo;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution29 {
	static ArrayList<Integer>[] list;
	static boolean visited[];
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int line = sc.nextInt();
		int ans = 0;
		visited = new boolean[num+1];
		list = new ArrayList[num+1];
		
		
		for(int i = 1 ; i <= num ; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		
		for(int i = 0 ; i < line ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list[a].add(b); //두 간선을 이어주는 작업
			list[b].add(a);
			
		}
		
		//dfs를 돌면서 방문했던 곳이 있으면 true로 변경 
		
		
		for(int i = 1 ; i <= num ; i++) {
			if(!visited[i]) {
				dfs(i);
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
	public static void dfs(int d) {
		if(visited[d]) {
			return;
		}
		
		visited[d] = true; // true가 아니면 true로 변경해준뒤
		
		for(int i : list[d]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
		
		
		
		
	}
	
	
	
	
	
}
