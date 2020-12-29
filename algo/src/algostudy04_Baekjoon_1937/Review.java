package algostudy04_Baekjoon_1937;

import java.util.Scanner;

public class Review {
	static int map[][];
	static int dp[][];
	static int a[] = {1,-1,0,0};
	static int b[] = {0,0,1,-1};
	static int n;
	static boolean visited[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int[n][n];
		dp = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ;j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int ans = 0 ;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ;j++) {
				if(dp[i][j] == 0) {
					ans =  Math.max(ans, dfs(i,j));
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
	
	public static int dfs(int x, int y) {
		
		if(dp[x][y] != 0 ) {
			return dp[x][y];
		}
	
		dp[x][y] = 1;
		for(int i = 0 ; i < 4 ; i++) {
			int mx = x+ a[i];
			int my = y+ b[i];
			
			if(mx >=0 && my >= 0 && mx <n && my <n) {
				if(map[x][y] < map[mx][my]) {
					
					dp[x][y] = Math.max(dp[x][y],dfs(mx,my)+1 );
					
				}
				
			}
			
			
		}
		
	

		return dp[x][y];
	}
	
}
