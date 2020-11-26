package nhntest;

import java.util.ArrayList;
import java.util.Scanner;

public class solution {
	
	static boolean visited[][];
	static int a[] = {1 ,-1, 0,0};
	static int b[] = {0,0,-1,1};
	static int ans;
	static int cnt;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int num = sc.nextInt();
		
		
		int arr[][] = new int[num][num];
		visited = new boolean[num][num];
		cnt = 1;
		
		sb = new StringBuilder();
		
		for(int i = 0 ; i < num ; i++) {
			for(int j = 0 ;  j < num; j ++) {
				arr[i][j] = sc.nextInt();
				
			}
		}
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0 ; i < num ; i++) {
			for(int j = 0 ;  j < num; j ++) {
				if(arr[i][j] == 1 && !visited[i][j]) {
					dfs(arr,i,j);
				
					list.add(cnt);
					ans++;
				}
				cnt = 1;
				
			}
		}
		
		System.out.println(ans);
		list.sort(null);
		for(int i : list) {
			System.out.print(i +" ");
		}
	}
	
	
	public static void dfs(int arr[][],int i,int j) {
		
		visited[i][j] = true;

		for(int k = 0 ; k < 4 ; k++) {
			int nexti = i+a[k];
			int nextj = j+b[k];
			if(nexti >= 0  && nextj >= 0 && nexti <= arr.length-1  && nextj <= arr.length-1 && !visited[nexti][nextj] && arr[nexti][nextj] ==1) {
				dfs(arr,nexti,nextj);
				cnt ++;
			}
			
			
		}
	
		
		
	}
	

}
