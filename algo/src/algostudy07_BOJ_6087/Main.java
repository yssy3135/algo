package algostudy07_BOJ_6087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static String map[][];
	static int c[][];
	static int a[] = {1,-1,0,0};
	static int b[] = {0,0,-1,1};
	static boolean visited[][][];
	static int w;
	static int h;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp[] = br.readLine().split(" ");
		
		w = Integer.parseInt(tmp[0]);
		h = Integer.parseInt(tmp[1]);
		
		map = new String[h][w];
		visited = new boolean[h][w][4];
		c = new int[2][2];
		
		
		int cnt = 0;
		for(int i = 0 ; i < h ; i++) {
			map[i] = br.readLine().split("");
			for(int j = 0 ; j < w ; j++) {
				if(map[i][j].equals("C")) {
					c[cnt][0] = i;
					c[cnt][1] = j;
					cnt++;
				}
			}
			
		}
		// 방향을 꺾을 때 마다 거울이 추가되어야한다.
		
		
		
		
	}
	
	
	public static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		
		// 좌표,개수,진행방향 -> 처음에는 4방향모두-1;
		que.add(new int[] {x,y,0,-1});
		
		while(!que.isEmpty()) {
			int laser[] = que.poll();
			x = laser[0];
			y = laser[1];
			int cnt = laser[2];
			int way = laser[3];
			
			if(x == c[1][0] && y == c[1][1]) {
				System.out.println(cnt);
				return ;
			}
			
			
			for(int i = 0 ; i < 4 ; i++) {
				int mx = x+a[i];
				int my = y+b[i];
				
				
				if(mx >= 0 && my >= 0 && mx <h && my < w) {
					if(!visited[mx][my][way] && map[mx][my].equals(".")) {
						if(way != i) {
							que.add(new int[] {mx,my,cnt+1,i});
						}

					}
					
				}
				
				
				
			}
			
		
			
			
		}
		
		
		
		
	}
	
	
	
	
}
