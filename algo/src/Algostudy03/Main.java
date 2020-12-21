package Algostudy03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	
	
	static boolean visited[][];
	static boolean alpha[];
	static int a[];
	static int b[];
	static String map[][];
	static int ans;
	static ArrayList<String> check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		visited = new boolean[r][c];
		alpha = new boolean[26];
		
		

		a = new int[] {1,-1,0,0};
		b = new int[] {0,0,-1,1};
		ans = 0;
		map = new String[r][c];
		for(int i = 0 ; i < r ; i++) {
			map[i]= sc.next().split("");	
		}
		
		alpha[Character.codePointAt(map[0][0],0)-65] = true;
		dfs(0,0,r,c,1);
		
		System.out.println(ans);
	}
	
	
	public static void dfs(int x, int y,int r,int c,int cnt) {
		visited[x][y] = true;
		ans = Math.max(ans, cnt);
		
		for(int i = 0 ; i < 4 ; i++) {
			int mx = x + a[i];
			int my = y + b[i];
			if(mx >=0 && my >=0 && mx <r && my < c) {
				int ctoi = Character.codePointAt(map[mx][my],0)-65;
				boolean dif = alpha[ctoi];
				if(!visited[mx][my] && !dif) {
					alpha[ctoi] = true;
					dfs(mx,my,r,c,cnt+1);
					alpha[ctoi] = false;
					visited[mx][my] = false;
				}
			}
		}

	}

	
	
}
