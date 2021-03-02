package solution129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.swing.text.html.StyleSheet.ListPainter;

public class Main {
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
	static ArrayList<node> list[];
	static int distance[];
	static int first[];
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		distance = new int[n+1];
		
		for(int i = 1 ; i <= n ;i ++) {
			list[i] = new ArrayList<node>();
		}
		for(int i = 0 ; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new node(b, c));
			list[b].add(new node(a, c));
		}
		
		for(int i = 1 ; i <= n ; i++) {
			dijkstra(i);
			
			
		}
		
		
		
		
	}
	
	public static void dijkstra(int start) {
		Arrays.fill(distance, Integer.MAX_VALUE);
		first = new int[n+1];
		
		PriorityQueue<node> pq = new PriorityQueue<node>();
		pq.add(new node(start, 0));
		distance[start] = 0;
		first[start]=start;
		
		while(!pq.isEmpty()) {
			int cur = pq.peek().num;
			int plus = pq.peek().plus;
			pq.poll();
			if(distance[cur] < plus)continue;
			
			
			for(int i = 0 ; i < list[cur].size() ;i++) {
				int next = list[cur].get(i).num;
				int nextplus = plus + list[cur].get(i).plus;
				
				if(nextplus < distance[next]) {
					distance[next] = nextplus;
					first[next] = cur;
				
					
					pq.add(new node(next, nextplus));
					
				}

			}

			
		}
	
		for(int i = 1 ; i <=n; i++) {
			if(i == start) {
				System.out.print("- ");
				continue;
			}

			int before = i;
			while(first[before] != start) {
				
					before = first[before];

			}
			
			System.out.print(before+" ");
			
			
		}
		
		
		System.out.println();
		
	}
	
	
	
}
