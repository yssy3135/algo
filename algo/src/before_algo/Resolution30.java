package before_algo;

import java.util.ArrayList;
import java.util.Scanner;

public class Resolution30 {
	
	static ArrayList<Integer> list[];
	static int visited[];
	
	
	// �̺� �׷����̸� �ڽŰ� ������ ������ ��� ���� �ٸ� ���̾���Ѵ�.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		String ans = "";
		
		for(int i=0;i<tc;i++) {
			
			int  V = sc.nextInt();
			int  E = sc.nextInt();
			visited = new int[V+1];
			list = new ArrayList[V+1];
			
			for(int k = 1 ; k <= V; k++) {
				list[k] = new ArrayList<Integer>();
			}
			
			for(int j = 1 ; j <= E ; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				list[a].add(b);
				list[b].add(a);
			}// for end
			
			for(int p =1 ; p <=V; p++) {
				if(visited[p] == 0) {     //0 �̸� �湮���� �ʾҴ�.
					if(!bfs(p,1)) {
						ans = "NO";
						break;
					}else {
						ans = "YES";
					}
				}
				
				
			}// for end
			System.out.println(ans);
		
		}// for end
	

	}// main end
	
	public static boolean bfs(int b,int now) {
		visited[b] = now;
		
		for(int i : list[b]) {
			if(now == visited[i]) {
				return false;
			}
			
			if(0 == visited[i]) {
				
				if(!bfs(i,-now))return false;
			}
			
			
		}
		
		
		
		
		return true;
	}
	
	
}
