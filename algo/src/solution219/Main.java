package solution219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int a;
		int usado;
		
		public Node(int a, int usado) {
			super();
			this.a = a;
			this.usado = usado;
		}

	}
	
	
	static ArrayList<Node> list[];
	static boolean visited[];

	static int cnt= 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
//		USADO가 K 이상인 모든 동영상이 추천되도록 할 것이다
		
		
//		 동영상 pi와 qi가 USADO ri로 서로 연결되어 있음을 뜻한다.
		list = new ArrayList[n+1];
		visited	= new boolean[n+1];
	
		
		for(int i = 1; i <=n ;i++) {
			list[i] = new ArrayList();
		}
		
		for(int i = 0 ;i  < n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int usado = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, usado));
			list[b].add(new Node(a, usado));
			
		}
		
		
		for(int i = 0 ; i < q ;i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			visited	= new boolean[n+1];
			visited[num] = true;
			cnt = 0;
			bfs(num,k);
			System.out.println(cnt);
		}
		
	}
	
	public static void bfs(int start,int k) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(start);
		
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			
			for(int i = 0 ; i < list[cur].size();i++) {
				int con = list[cur].get(i).a;
				
				
				if(list[cur].get(i).usado >=k && !visited[con]) {
					visited[con] = true;
					cnt++;
					que.add(con);					
				}
				
			}
				
			
		}
		
	}
	
	
	
	
	
}
