package algo;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution30 {
	
	static ArrayList<Integer>[] list;
	static int visited[]; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1 번째 줄 정점의 개수와 간선의 개수 
		
		//각 정점에는 1부터 번호가 붙어있고 
		// 2번째 줄부터 간선에 대한 정보 각 줄에 인접한 두정점의 번호가 빈칸을 사이에두고 주어진다.
		
		// 인접한 그룹이 모두 나와 다른 그룹이여야 한다.
		
		int times = sc.nextInt();
		int group = 0;
		String ans ="YES";
		
		for(int i = 0 ; i< times ; i++) {
			int numpoint = sc.nextInt();
			int numline = sc.nextInt();
			visited = new int[numpoint+1];
			list = new ArrayList[numpoint+1];
			
			for(int k = 1 ; k <= numpoint;k++) {
				list[k] = new ArrayList<Integer>();
			}
			

			for(int j = 1 ; j <= numline; j++) {		//간선의 개수만큼 연결
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				list[a].add(b);
				list[b].add(a);
			}
			
			
			for(int j = 1 ; j <= numpoint; j++) {
				if(visited[j] == 0) { // 방문하지 않음
					
					if(!bfs(j, 1)) {
						ans = "NO";
						break;
					}else {
						ans = "YES";
					}
						
				}

			}
			System.out.println(ans);
			
			
		}

	}
	
	public static boolean bfs(int b,int color) {
		
		visited[b] = color;
		
		for(int i : list[b]) {
			if(visited[i] == color) {
				return false;
			}
			
			if(visited[i] == 0) { //방문하지 않았다.
				if(!bfs(i,-color)) return false ;
			}
			
		}
		
		
		
		return true;
		
		
	}
	
	
	
}
