package before_algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution38 {
	
	
	static boolean visited[][];
	static int a[] = {1,-1,0,0,};
	static int b[] = {0,0,1,-1,};
	static int starti;
	static int startj;
	static int N;
	static int M;
	static boolean ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		 N  = sc.nextInt() ;
		 M = sc.nextInt();
		
		String pan[][] = new String[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0 ; i < N ; i++) {
				pan[i] = sc.next().split("");
		}
		
		
		
		loop:
		for(int i = 0 ; i < N ;i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j]) {
					
					starti = i;
					startj = j;

					dfs(i,j,pan,1);
					
					for(boolean a[] : visited) {
						Arrays.fill(a, false);
					}
					
				}
			}
		}
		
		System.out.printf(ans?"Yes":"NO");

		
	}
	
	
	public static void dfs(int i,int j,String pan[][],int depth) {
		
		visited[i][j] = true;
		String word = pan[i][j];

		for(int k = 0 ; k < 4 ;k++) {
			int wayi = i+a[k];
			int wayj = j+b[k];
			
			
			if(wayi >=0 && wayj >=0 && wayi <N && wayj <M) {
				if(pan[wayi][wayj].equals(word)&& !visited[wayi][wayj]) {
					
					dfs(wayi,wayj,pan,depth+1);
				}else if(pan[wayi][wayj].equals(word) && wayi == starti && wayj == startj && depth >=4) {
				
					ans = true;
					return ;
				}
			}
			
		}
		
		
		
		
	}
}
