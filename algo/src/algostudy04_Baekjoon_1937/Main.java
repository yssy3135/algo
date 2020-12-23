package algostudy04_Baekjoon_1937;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int map[][];
	static int dp[][];
	static int a[] = {1,-1,0,0};
	static int b[] = {0,0,1,-1};
	static boolean visited[][];
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		map = new int[n][n];
		dp = new int[n][n];
		visited = new boolean[n][n];
		ans = 0;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0; j < n ; j++) {
				map[i][j] =sc.nextInt();
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0; j < n ; j++) {
				dfs(n,i,j,map[i][j],1,i,j);
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println(ans);
		
		
		
	}
	public static void dfs(int n,int x, int y,int before,int cnt,int startx,int starty ) {
		
		boolean flag = false;
		for(int i = 0 ; i < 4 ; i++) {
			int mx = x+a[i];
			int my = y+b[i];
			if(mx >= 0 && my >= 0 && mx <n && my <n) {
				if(map[mx][my] > before) {
					if(dp[mx][my] != 0) { // 이미 재귀를 돌았다
						dp[x][y] = Math.max(cnt+dp[mx][my],dp[x][y]); 
						ans = Math.max(ans, dp[x][y]);
					}else {// 재귀를 돌아야함
						int nextcnt = cnt+1;
						flag = true;
						dfs(n,mx,my,map[mx][my],nextcnt,startx,starty);
					}
					
				}
				
			}
			
			
		}
		
		if(!flag) {
			dp[startx][starty] = Math.max(dp[startx][starty], cnt);
		}
		
		
		
	}
	
	
}
