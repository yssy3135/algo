package solution120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	
	
	static int v;
	static int dis[];
	static boolean visited[];
	static int arr[][];
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
		arr = new int[v+1][v+1];
		dis = new int[v+1];
		visited = new boolean[v+1];
		
		
		for(int i = 1 ; i <= v ; i++) {
			Arrays.fill(arr[i], 1000);
		}
		
		
		for(int i = 0 ; i < e; i++) {
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[a][b] = w;
//			arr[b][a] = w;

		}
		
		dijkstra(k);
		for(int i = 1 ; i <=v ; i++) {
			if( i == k ) {
				System.out.println(0);
			}else {
			System.out.println(dis[i] == 1000 ? "INF" : dis[i]);
				
			}
			
			
		}
		
		

	}
	
	
	
	public static int getmin() {
		int min = 1000;
		int idx = 1;
		for(int i = 1 ; i <= v; i++) {
			if(dis[i] < min && !visited[i]) {
				min = dis[i];
				idx = i;
			}
		}
		
		return idx;
		
	}
	
	
	
	public static void dijkstra(int start) {
		
		for(int i = 1 ; i <= v ;i ++) {
			dis[i] = arr[start][i];
		}
		visited[start] = true;
		
		for(int i = 1 ; i <= v-2 ;i++) {
			int cur = getmin();
			visited[cur] = true;
			for(int j = 1 ; j <= v ; j++) {
				if(!visited[j])	{
					if(dis[j] > arr[cur][j]+dis[cur]) {
						dis[j] = arr[cur][j]+dis[cur];
					}
					
				}
			}
			
			
		}
		
	}
}
