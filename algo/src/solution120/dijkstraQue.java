package solution120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class dijkstraQue {
	static int v;
	static int dis[];
	static boolean visited[];
	static ArrayList<node> arr[];
	
	
	static class node implements Comparable<node>{
		int num;
		int plus;
		
		
		public node(int num, int plus) {
			super();
			this.num = num;
			this.plus = plus;
		}


		@Override
		public int compareTo(node o) {
			// TODO Auto-generated method stub
			return plus-o.plus;
		}


	
		
		
		
	}
	
	
	
	static PriorityQueue<int[][]> que = new PriorityQueue<int[][]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 정점의 개수
		v = Integer.parseInt(st.nextToken()); 
		// 간선의 개수
		int e = Integer.parseInt(st.nextToken());
		
		// 시작 정점의 번호
		int k = Integer.parseInt(br.readLine());
		
		// 2차원 배열 
		arr = new ArrayList[v+1];
		dis = new int[v+1];
		visited = new boolean[v+1];
		
		
		for(int i = 0 ; i < arr.length;i++) {
			arr[i] = new ArrayList<node>();
		}
		
		
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		for(int i = 0 ; i < e; i++) {
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			arr[a].add(new node(b, w));
		}
		
		dijkstra(k);
		for(int i = 1 ; i <= v ; i++) {
			if( i == k ) {
				System.out.println(0);
			}else {
				System.out.println(dis[i] == Integer.MAX_VALUE ? "INF" : dis[i]);
			}
		}
		
		
		
		
	}
	
	public static void dijkstra(int start) {
		dis[start] = 0;
		PriorityQueue<node> pq = new PriorityQueue<node>();
		
		pq.add(new node(start, 0) );
		
		while(!pq.isEmpty()) {
			int cur = pq.peek().num;
			int distance = pq.peek().plus;
			pq.poll();
			
			//최단 거리가 아닌경우 스킵
			if(dis[cur] < distance)continue;
			
			for(int i = 0 ; i < arr[cur].size();i++) {
				
				//선택된 노드의 인접노드
				int next = arr[cur].get(i).num;
				// 선택된 노드를 인접 노드로 거쳐서 가는 비용
				int nextDistance = distance + arr[cur].get(i).plus;
				
				if(nextDistance < dis[next]) {
					dis[next] = nextDistance;
					pq.add(new node(next, nextDistance));
				}
				
				
			}
			
			
		}
		
		
		
	}
	
}
