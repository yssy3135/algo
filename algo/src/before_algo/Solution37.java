package before_algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution37 {
	
	static int a[] = {-2,-2,+2,+2,-1,+1,-1,+1 };
	static int b[] = {-1,+1,-1,+1,-2,-2,+2,+2};
	static int pan[][];
	static int target[];
	static int ans = 0;
	static boolean visited[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int num = sc.nextInt();
		
		for(int i = 0; i < num ; i++) {
			int I = sc.nextInt();
			 pan = new int[I][I];
			 visited = new boolean[I][I];
			int now[] = new int[2];
			target = new int[2];
			
			for(int j = 0  ; j < 2 ; j++) {
				now[j] = sc.nextInt();
			}
			for(int j = 0  ; j < 2 ; j++) {
				target[j] = sc.nextInt();
			}
			bfs(now[0],now[1],I);
			
//			for(int j = 0 ; j < I ;j++) {
//				for(int k = 0 ; k < I ; k++) {
//					System.out.print(pan[j][k]);
//				}
//				System.out.println();
//			}
			
			if(now[0]== target[0] && now[0]== target[0]) {
				System.out.println(0);
			}else {
				
				System.out.println(pan[target[0]][target[1]]);
			}
			

			
		}
		
		
		
		
	}
	
	public static void bfs(int i , int j ,int size) {
		Queue<int[]> que = new LinkedList<int[]>();
	
		que.add(new int[] {i,j});
		
		while(!que.isEmpty()) {
	
			int now[] =  que.poll();
			
			for(int k = 0 ; k < 8; k++) {
				int wayi = now[0]+a[k];
				int wayj = now[1]+b[k];
				
				if(wayi >= 0 && wayj >= 0 && wayi <size && wayj <size ) {
					if(!visited[wayi][wayj] ) {
						visited[wayi][wayj] = true;
						que.add(new int[] {wayi,wayj});
						pan[wayi][wayj] = pan[now[0]][now[1]] +1;
					}
				}
				
				
				
			}
			
			
			
		}
		
		
		
	}
	
	
}
