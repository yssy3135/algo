package before_algo;



import java.util.HashMap;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;


public class Solution35 {
	
	static int arr[][] ;
	static int a[] = {-1,1,0,0};
	static int b[] = {0,0,-1,1};
	static boolean visited[][];
	static int ans;
	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		 M = sc.nextInt();
		 N = sc.nextInt();
		
		 arr = new int[N][M];
		 visited = new boolean[N][M];
		
			for(int i = 0 ; i< N ;i++) {
				for(int j = 0 ; j <M ; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
		 
	
		
		bfs();

		

		
		loop:
		for(int i = 0 ; i < N;i++) {
			for(int j = 0 ;j <M ;j++) {
				ans = Math.max(ans, arr[i][j]);
				if(arr[i][j] == 0) {
				
					ans = -1;
					break loop;
				}
			}
		}
		

		System.out.println(ans == -1 ? -1 : ans-1);
		
	} //main end
	
	public static void bfs () {
		Queue<int[]> que = new LinkedList<int[]>();
		
		for(int i = 0 ; i< N ;i++) {
			for(int j = 0 ; j <M ; j++) {
				if(arr[i][j] ==1) { //1 �� �ִ� ��ġ�� ���� 
					que.add(new int[] {i , j});
				}
				
			}
		}
		

		while(!que.isEmpty()) {
			int now[] = que.poll();

			
			for(int k = 0 ; k <4;k++) {
			
				int wayi = now[0]+a[k];
				int wayj = now[1]+b[k];
				
				
				if(wayi >= 0 && wayj >= 0 && wayi < N && wayj<M ) {
					if(arr[wayi][wayj] ==0 && !visited[wayi][wayj]) {
						visited[wayi][wayj] = true;
						arr[wayi][wayj] = arr[now[0]][now[1]]+1;
						que.offer(new int[] {wayi,wayj});
						
					}
				}
			}
			
			
	
		}
		
		
		
		
	}
	
}
