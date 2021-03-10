package solution148;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int arr[];
	static boolean visited[];
	static int result[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		result = new int[n];
		visited = new boolean[n];
		
		String tmp[] = br.readLine().split(" ");
		for(int i = 0 ; i < n ;i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
		
		backtracking(n,0);
		System.out.println(max);
	}
	
	static int max = 0;
	public static void backtracking(int n,int dept) {
		if(dept == n) {
			int sum = 0;
			for(int i = 0 ; i < n-1 ;i++) {
				
				sum +=Math.abs(result[i]-result[i+1]);
			}
			max = Math.max(sum, max);
			return;
			
		}
		
		for(int i = 0 ; i < n ;i ++) {
			if(!visited[i]) {
				visited[i] = true;
				result[dept] = arr[i];
				backtracking(n, dept+1);
				visited[i] = false;
			}
		}
		
		
		
	}
	
	
}
