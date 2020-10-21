package Solution44;

import java.util.Scanner;

public class Main {
	
	
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int arr[];
		
		while(true) {
			int times = sc.nextInt();
			if(times == 0 )break;
			
			arr = new int[times];
			visited = new boolean[times];
			for(int i = 0 ; i < times; i++) {
				arr[i] = sc.nextInt();
			}
			combi(arr,visited,0,6,arr.length);
			System.out.println();
		}

	}
	
	
	
	public static void combi(int arr[],boolean visited[],int start,int r, int n) {
		if(r==0) {
			for(int i = 0 ; i < n ;i++) {
				if(visited[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
		}
		
		for(int i =start; i < n; i++) {
			visited[i] = true;
			combi(arr,visited,i+1,r-1,n);
			visited[i] = false;
		}
		
		
	}
	
	
	
	
}
