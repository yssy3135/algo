package before_algo;

import java.util.Scanner;

public class Solution40 {
	
	static boolean visited[];
	static int ans;
	static int stat[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ans = 100;
		int N = sc.nextInt();
		
		stat = new int[N][N];
		visited = new boolean[N];
		int person[] = new int[N];
		
		
		
		for(int i = 0 ; i < N ; i++) {
			person[i]= i+1;
			for(int j = 0 ; j< N ;j ++) {
				stat[i][j] = sc.nextInt();
			}
		}
		
		combi(person,0,person.length,N/2);
		
		System.out.println(ans);

	}
	
	public static void combi(int arr[],int start,int n , int r) {
		if(r == 0) {				//true  ����  false ����
			ans = Math.min(ans, getmin(arr,visited));
			return;
		}
		
		for(int i = start ; i < n ; i ++) {
	
				visited[i] = true;
				combi(arr,i+1,n,r-1);
				visited[i] = false;
				
		}
		
		
	}
	
	public static int getmin(int[] arr,boolean visited[]) {
		
		int teamtrue = 0;
		int teamfalse = 0;

		System.out.println();
		
		for(int i = 0 ;i < arr.length;i++) {
			for(int j = 0 ; j< arr.length; j++) {
				if(visited[i] && visited[j]) {
					teamtrue += stat[i][j]; 
				}else if (!visited[i] && !visited[j]){
					teamfalse += stat[i][j];
				}
				
				
			}
			
		}
		
		
			return Math.abs(teamtrue-teamfalse);
		
	}
	
	
	
	
	
	
}
