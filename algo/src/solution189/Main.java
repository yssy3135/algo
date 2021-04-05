package solution189;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static class Node{
		int a;
		int b;
		int cost;
		
		public Node(int a,int b, int cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		
	}
	
	static ArrayList<Node> list;
	static long[] upper;
	static int n;
	static int m;
	static int e;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		list = new ArrayList<Node>();
			
		Node[] node = new Node[m];
		
		for(int i = 0 ; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			node[i] = new Node(a, b, cost);
		
		
		}


		
		upper = new long[n];
		
		String[] max = br.readLine().split(" ");
		
		for(int i = 0 ; i < m ;i++) {
			int min = Integer.parseInt(max[node[i].b])-node[i].cost;
			
			list.add(i, new Node(node[i].a, node[i].b, min));
		}
		
		
		if(bellmanford(s,max)) {
			
			
			System.out.println(upper[e]);
				
			
			
		}

	
		
	}
	
	
    // 최단 거리를 찾아 upper에 저장 후 true 리턴
    // 하지만, 음수 싸이클이 존재하면 false 리턴
	public static boolean bellmanford(int start,String max[]) {
		Arrays.fill(upper, Long.MIN_VALUE);
		upper[start] = Integer.parseInt(max[start]);
		//upper[i] : 정점 i까지의 최단 거리의 상한
		
		
		//n번 검사, n-1번동안 최단거리 생성후 n번째에서 음수 싸이클 검사
		for(int i = 0 ; i < n-1 ;i++) {

			for(int j = 0; j <m ;j++) {
				int a = list.get(j).a;
				int b = list.get(j).b;
				int cost = list.get(j).cost;
			
				
				if(upper[a] != Long.MIN_VALUE && upper[a]+cost > upper[b]) {
					upper[b] = upper[a]+cost;
				}
				
				
			}
			
		}
		
		ArrayList<Integer> cycle = new ArrayList<Integer>();
		// N 번째에서도 갱신이 되면 사이클 발생
		
		for(int j = 0; j <m ;j++) {
			int a = list.get(j).a;
			int b = list.get(j).b;
			int cost = list.get(j).cost;

			if(upper[a] != Long.MIN_VALUE && upper[a]+cost > upper[b]) {
				// 사이클이 생기는데 도착지점에 도착할 수 있으면 Gee
				cycle.add(b);
				
			}
			
			
		}
			
		
		
		if(upper[e] == Long.MIN_VALUE) {
			System.out.println("gg");
			return false;
		}
		
		
		//사이클이 있을때
		if(cycle.size() != 0 ) {
			
			bfs(cycle);
			return false;
			
		}else {
			return true;
		}
		
	
		
	}
	
	
	public static void bfs(ArrayList<Integer> cycle ) {
		boolean visited[] = new boolean[n];
		
		for(int i = 0 ;i < cycle.size();i++) {
			int s = cycle.get(i);
			
			if(!visited[s]) {
				Queue<Integer> que = new LinkedList<Integer>();
				visited[s] = true;
				que.add(s);
				
				
				while(!que.isEmpty()) {
					int con = que.poll();
					
					for(int j = 0 ; j < list.size(); j++) {
						if(con == list.get(j).a&& !visited[list.get(j).b]) {
							visited[list.get(j).b] = true;
							que.add(list.get(j).b);
						}
						
					}
					
				}
				
				
				
			}
			
			
		}
		
		if(visited[e]) {
			System.out.println("Gee");
			
		}else {
			System.out.println(upper[e]);
			
		}
		
	
	}
	
	
	
	
}
