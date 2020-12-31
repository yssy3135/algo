package before_algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution34 {
	
	static boolean visited[];
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		 N = sc.nextInt();
		int M = sc.nextInt();
		int start = sc.nextInt();
		
		int arr[][] = new int [N+1][M+1];
		visited = new boolean[N+1];
		
		for(int i = 0 ; i < M ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a][b] = 1;
			arr[b][a] = 1;
			
		}
		
		for(int i = 1 ; i<= N ;i++) {
			if(!visited[i]) {
				dfs(arr,start);
			}
			
		}
		
		
		
		
	}
	
	
	public static void dfs(int arr[][],int start) {
		visited[start] = true;
		System.out.println (start);
		
		for(int i = 1 ; i<=N;i++) {
			if(!visited[i] && arr[start][i] == 1) {
				dfs(arr,i);
			}
		}

	}
	
	
	public static void dfs(int start,int arr[][]) {
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.offer(start);
		
		visited[start] = true;
		
		while(!que.isEmpty()) {
			int tmp = que.poll();
			
			for(int i = 1 ; i <=N;i++) {
				if(!visited[i] && arr[tmp][i] == 1) {
					visited[i]= true;
					que.offer(i);
				}
				
			}
			
			
		}
		
		
		
	}
	
	
	
	
}
