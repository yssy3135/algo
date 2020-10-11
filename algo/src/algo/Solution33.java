package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution33 {
	
	static int a[] = {-1,1,0,0};
	static int b[] = {0,0,-1,1};
	static int ans = 0 ;
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String read[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(read[0]);
		int M = Integer.parseInt(read[1]);
		
		int arr[][] = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		
		for(int i = 0 ; i < N ; i++) {
			String str[] = br.readLine().split("");
			for(int j = 0 ;j < M ; j ++) {
				arr[i][j] =	Integer.parseInt(str[j]);
			}
		}
		
		bfs(arr,0,0);
		
		System.out.println(arr[N-1][M-1]);
		
		
		
	}
	
	public static void bfs(int[][] arr,int i ,int j) {
		Queue<int[]> que	= new LinkedList<int[]>();
		que.offer(new int[] {i,j});
		
		
		while(!que.isEmpty()) {
			int now[] = que.poll();
			visited[i][j] = true;
			
			for(int k = 0 ; k < 4 ; k++) {
				int wayi = now[0]+a[k];
				int wayj = now[1]+b[k];
				if(wayi >=0 && wayj >= 0 && arr[wayi][wayj] == 1 && !visited[wayi][wayj]) {
					que.offer(new int[] {wayi,wayj});
					visited[wayi][wayj] = true;
					
					arr[wayi][wayj] = arr[now[0]][now[1]]+1;
					
				}
				
			}
			
			
		}
		
		
		
	}
	
	
}
