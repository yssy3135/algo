package before_algo;

import java.util.Scanner;

public class reSolution40 {
	static int score[][];
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		int arr[]= new int[N];
		ans = 100;
		score = new int [N][N];
		boolean visited[] = new boolean[N];
		
		for(int i = 0 ;i < N ; i++) {
			arr[i]= i+1;
		}
		
		
		for(int i = 0 ;i < N; i++) {
			for(int j = 0 ; j < N ;j++) {
				score[i][j] = sc.nextInt();
			}
		}
		
		combi(arr,visited,0,N/2,N);
		
		System.out.println(ans);
	}
	
	public static void combi(int arr[],boolean visited[],int start,int r,int n) {
		if(r == 0 ) {
			ans = Math.min(ans, getmin(arr,visited,n));
		}
		
		
		for(int i = start ; i < n ; i++) {
			visited[i] = true;
			combi(arr,visited,i+1,r-1,n);
			visited[i] = false;
		}
		
	}
	
	public static int getmin(int arr[],boolean visited[],int n) {
		
		int start = 0;
		int link = 0;
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(visited[i] && visited[j]) {
					start += score[i][j];
				}else if (!visited[i] && !visited[j]) {
					link += score[i][j];
				}
			}
			
		}
		
		return Math.abs(start - link);
		
	}
	
	
}
