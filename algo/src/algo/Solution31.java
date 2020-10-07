package algo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Solution31 {
	
	
	static boolean visited [][];
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int ans = 0;
		int num = sc.nextInt();


		  int arr[][] = new int[num+2][num+2]; 
		  visited = new boolean[num+2][num+2];
		  
		  for(int i = 1 ; i < num+1;i++) { 
			  
			  String tmp[] = sc.next().split("");
			  
			  for(int j = 0 ; j <tmp.length; j++) {
				  arr[i][j+1] = Integer.parseInt(tmp[j]);
			  	} 
			  }
		  
		  
		
		  	for(int i = 1 ; i < num+1;i++) { 
			  for(int j = 1 ; j <num+1; j++) {
				 if(arr[i][j] ==1 && !visited[i][j]) {
					 
					 ans = bfs(arr,i,j,1);
					 list.add(ans);
					 ans = 0;
				 }else {
					 continue;
				 }
				  
			  	} 
			  }
		
		
		  	System.out.println(list.size());
		  	
		  	list.sort(null);
		  	Iterator<Integer> iter = list.iterator();
		  	while(iter.hasNext()) {
		  		System.out.println(iter.next());
		  	}
		
		
		
	}
	
	
	
	public static int bfs(int arr[][],int i , int j,int cnt) {
	
		visited[i][j] = true;
		//상하좌우에 1을 모두 방문했을때 개수 리턴

		if(arr[i+1][j] == 1 && !visited[i+1][j]) { //하
			 cnt++;
			 cnt = bfs(arr,i+1,j,cnt);	
		}
		if(arr[i-1][j] == 1 && !visited[i-1][j]) { //상
			
			cnt++;
			cnt = bfs(arr,i-1,j,cnt);
		}
		if(arr[i][j-1] == 1 && !visited[i][j-1]) { //좌
			cnt++;
			 cnt =bfs(arr,i,j-1,cnt);
		}
		if(arr[i][j+1] == 1 && !visited[i][j+1]) { //우
			cnt++;
			 cnt = bfs(arr,i,j+1,cnt);
		}
		
		
		
		return cnt;
	}
	
	

}
