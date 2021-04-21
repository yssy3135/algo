package solution212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static class Enemy{
		int r;
		int c;
		int idx;
		
		public Enemy(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Enemy(int r, int c, int idx) {
			super();
			this.r = r;
			this.c = c;
			this.idx = idx;
		}
		
		
	}
	
	
	static int map[][];
	static ArrayList<Enemy> enemy;
	static ArrayList<Enemy> list;
//	static ArrayList<int[]> archer;
	static boolean visited[];
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		//궁수의 공격 거리 
		int d = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n];
		enemy = new ArrayList<Enemy>();
		
		
		for(int i = 0 ; i < n ;i++) {
			String tmp[] = br.readLine().split(" ");
			for(int j = 0 ;j < m;j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
				if(map[i][j] == 1) {
					enemy.add(new Enemy(i, j));
				}
			}
		}
		
		combi(n,3,0,d,m);
		System.out.println(max);
		
		
	}
	
	
	public static void bfs(int d,int n,int archer[],int clone[][],int m) {
		
		int cnt = 0;
		while(list.size() != 0) {
		
			ArrayList<Enemy> attack = new ArrayList<Enemy>();
			
			for(int i = 0 ; i < 3 ;i++) {
				//궁수마다 공격할 수 있는 적을 찾아야한다.
				
				ArrayList<Enemy> in = new ArrayList<Enemy>();
				int dis[] = new int[list.size()];
				
				int mindis = Integer.MAX_VALUE;
				
				//거리 
				for(int j = 0 ; j < list.size();j++) {
					dis[j] = dis(n,archer[i],list.get(j).r, list.get(j).c);
				
					mindis = Math.min(dis[j], mindis);
				}
				
				
				for(int j = 0 ; j < dis.length;j++) {
					if( mindis == dis[j] && dis[j] <=d  ) {
						in.add(new Enemy(list.get(j).r, list.get(j).c, j));
					}
				}
				
				
				//공격할수 있는 범위에 적이 없다.

				//있으면 제일 왼쪽거를 찾아야한다.
				
				if(in.isEmpty())continue;
				
				in.sort(new Comparator<Enemy>() {

					@Override
					public int compare(Enemy o1, Enemy o2) {
						// TODO Auto-generated method stub
						return Integer.compare(o1.c, o2.c);
					}
				});
				
	
				attack.add(in.get(0));

			}
			
	
			
			// 적을 지운다.
			for(int i = 0 ;i < attack.size();i++) {
				for(int j = 0 ;j < list.size();j++) {
					if(attack.get(i).c == list.get(j).c && attack.get(i).r == list.get(j).r) {
						list.remove(j);
						cnt++;
						break;
					}
				}
			}
			
			int size = list.size();
			//한칸씩 민다.
		
			for(int i = size-1 ; i>= 0;i--) {
				if(list.get(i).r+1 < n) {
					list.add(new Enemy(list.get(i).r+1, list.get(i).c));
					
				}
				list.remove(i);
				
			}
			
			
			
		}// while end
		max = Math.max(max, cnt);
		
	}
	
	public static void combi(int n ,int r,int start,int d,int m) {
		if(r == 0) {
			int cnt = 0;
			int tmp[] = new int[3];
			for(int i = 0 ;i < m;i++) {
				if(visited[i]) {
					tmp[cnt] = i;
					cnt++;
				}
			}


			list = new ArrayList<Enemy>(enemy);
			bfs(d, n, tmp, map.clone(),m);
			
			return;
		}
		
		for(int i = start ;i < m ;i++) {
			if(!visited[i]) {
				visited[i] = true;
				combi(n,r-1,i+1,d,m);
				visited[i] = false;
			}
		}
		
		
	}
	
	public static int dis(int x1,int y1,int x2,int y2) {
		
		return Math.abs(x1-x2) + Math.abs(y1-y2);
		
	}
	
	
	
}