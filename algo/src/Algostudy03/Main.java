package Algostudy03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	
	
//	static boolean visited[][];
	static int a[];
	static int b[];
	static String map[][];
	static int ans;
	static ArrayList<String> check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		boolean visited[][] = new boolean[r][c];

		ArrayList<String> check = new ArrayList<String>();
		a = new int[] {1,-1,0,0};
		b = new int[] {0,0,-1,1};
		ans = 0;
		map = new String[r][c];
		check = new ArrayList<String>();
		for(int i = 0 ; i < r ; i++) {
			map[i]= sc.next().split("");	
		}
		
		check.add(map[0][0]);
		dfs(0,0,r,c,1,check,visited);
		
		System.out.println(ans);
	}
	
	
	public static void dfs(int x, int y,int r,int c,int cnt,ArrayList<String> check,boolean visited[][]) {
		
		
		visited[x][y] = true;
		ans = Math.max(ans, cnt);
		
		for(int i = 0 ; i < 4 ; i++) {
			int mx = x + a[i];
			int my = y + b[i];
			if(mx >=0 && my >=0 && mx <r && my < c) {
				boolean dif = check.contains(map[mx][my]);
				printmap(visited);
				if(!visited[mx][my] && !dif) {
					check.add(map[mx][my]);
					dfs(mx,my,r,c,cnt+1,check,visited);
					check.remove(map[mx][my]);
					visited[mx][my] = false;
				}
			}
		}

	}
	public static void printmap(boolean m[][]) {
		
		for(int i = 0 ; i < m.length;i++) {
			for(int j = 0 ; j < m[i].length;j++) {
				System.out.print(m[i][j]+ " ");
			}
			System.out.println("");

		}
		System.out.println("=====================");
		
	}
	
	
}
