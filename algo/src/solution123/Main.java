package solution123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class node{
		int r;
		int c;
		int flag;
		int cnt;
		
		public node(int r, int c, int flag,int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.flag = flag;
			this.cnt = cnt;
		}
		
	}
	
	
	static int arr[][];
	static int n;
	static int m;
	static int a[] = {1,-1,0,0};
	static int b[] = {0,0,1,-1};
	static int visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr= new int[n][m];
		visited = new int[n][m];
		for(int i = 0 ; i < n; i++) {
			String tmp[] = br.readLine().split("");
			for(int j = 0 ; j < m ;j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs();
		
		
	}
	
	public static void bfs() {
		Queue<node> que = new LinkedList<node>();
		que.add(new node(0, 0, 0, 1));
		visited[0][0] = 0;
		
		while(!que.isEmpty()) {
			node now = que.poll();
			if(now.r == n-1 && now.c == m-1) {
				System.out.println(now.cnt);
				return;
			}
			
			
			for(int i = 0 ;i < 4 ; i++) {
				int mr = now.r+a[i];
				int mc = now.c+b[i];
				
				if(mr >= 0 && mc >= 0 && mr <n && mc <m) {
					
					if(visited[mr][mc] > now.flag) {
						if(arr[mr][mc] == 0 ) {
							que.add(new node(mr, mc, now.flag, now.cnt+1));
							visited[mr][mc] = now.flag;
						}else {
							if(now.flag == 0) {
								que.add(new node(mr, mc, now.flag+1, now.cnt+1));
								visited[mr][mc] = now.flag+1;
							}
						}
					}
					
					
				}
				
			}
			
			
		}
		
		System.out.println(-1);
		
	}
	
	
	
}

