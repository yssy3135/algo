package solution221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char map[][];
	static int cnt;
	static int a[] = {1,-1,0,0};
	static int b[] = {0,0,1,-1};
	static boolean visited[][];
	static ArrayList<int[]> firemap;
	static boolean flag ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < t ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			visited = new boolean[h][w];
			firemap = new ArrayList<int[]>();
			cnt= 0;
			flag = false;
			int sr = 0;
			int sc = 0;
			
			for(int j = 0 ; j < h ;j++) {
				char tmp[] = br.readLine().toCharArray();
				for(int k = 0 ; k < w ; k++) {
					map[j][k] = tmp[k];
					if(tmp[k]=='@') {
						sr = j;
						sc = k;
					}else if (tmp[k]=='*') {
						firemap.add(new int[] {j,k});
					}
				}
			}
			
			bfs(sr, sc, w, h);
			
			if(flag) {
				System.out.println(cnt);
			}else {
				System.out.println("IMPOSSIBLE");
			}
			
			
			
		}
		
		
		
	}
	
	public static void bfs(int r,int c,int w,int h) {
		Queue<int[]> que = new LinkedList<int[]>();
		
		que.add(new int[] {r,c,0});
		visited[r][c] = true;
		while(!que.isEmpty()) {
			int cur[] = que.poll();

				if(cnt == cur[2]) {
					fire(cur[0], cur[1], w, h);
					cnt++;
				}
			
				
				for(int i = 0 ; i < 4 ;i++) {
					int mr = cur[0] + a[i];
					int mc = cur[1] + b[i];
					
					if(mr <h && mc < w && mr >=0 && mc >=0) {
						if(map[mr][mc] =='.') {
							if(!visited[mr][mc]) {
								visited[mr][mc] = true;
								map[mr][mc] = '@';
								que.add(new int[] {mr,mc,cur[2]+1});
								
							}
						}
						
					}else {
						flag = true;
						cnt = cur[2]+1;
						return;
					}
					
				}
		}
		
		
	}
	
	public static void fire(int r,int c,int w,int h) {
		
		
		ArrayList<int[]> newfire = new ArrayList<int[]>();
		
		for(int i = 0 ; i < firemap.size() ;i++) {
			int fire[] = firemap.get(i);
			
			for(int j = 0 ;j  < 4;j++) {
				int mr = fire[0] +a[j];
				int mc = fire[1] +b[j];

				if(mr <h && mc < w && mr >=0 && mc >=0) {
					if(map[mr][mc]!='#'&& map[mr][mc] != '*') {
						
						map[mr][mc] = '*';
						newfire.add(new int[] {mr,mc});
					}
				}
				
				
			}
		}
		firemap = newfire;
	
		
		
	}
	
	
	
}


