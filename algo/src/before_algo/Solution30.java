package before_algo;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution30 {
	
	static ArrayList<Integer>[] list;
	static int visited[]; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1 ��° �� ������ ������ ������ ���� 
		
		//�� �������� 1���� ��ȣ�� �پ��ְ� 
		// 2��° �ٺ��� ������ ���� ���� �� �ٿ� ������ �������� ��ȣ�� ��ĭ�� ���̿��ΰ� �־�����.
		
		// ������ �׷��� ��� ���� �ٸ� �׷��̿��� �Ѵ�.
		
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
			

			for(int j = 1 ; j <= numline; j++) {		//������ ������ŭ ����
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				list[a].add(b);
				list[b].add(a);
			}
			
			
			for(int j = 1 ; j <= numpoint; j++) {
				if(visited[j] == 0) { // �湮���� ����
					
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
			
			if(visited[i] == 0) { //�湮���� �ʾҴ�.
				if(!bfs(i,-color)) return false ;
			}
			
		}
		
		
		
		return true;
		
		
	}
	
	
	
}
