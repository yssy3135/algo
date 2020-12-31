package before_algo;

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
			
			list[a].add(b); //�� ������ �̾��ִ� �۾�
			list[b].add(a);
			
		}
		
		//dfs�� ���鼭 �湮�ߴ� ���� ������ true�� ���� 
		
		
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
		
		visited[d] = true; // true�� �ƴϸ� true�� �������ص�
		
		for(int i : list[d]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
		
		
		
		
	}
	
	
	
	
	
}
