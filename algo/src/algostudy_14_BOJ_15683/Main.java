package algostudy_14_BOJ_15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import com.sun.org.apache.bcel.internal.generic.CPInstruction;

public class Main {
	
	
	public static class CCTV {
		int x;
		int y;
		int type;
		
		public CCTV(int y, int x, int type) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
	
	static int map[][];
	static ArrayList<CCTV> list;
	static int N;
	static int M;
	static int rot_size[] = {4,2,4,4,1};
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[] = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		ans = 100;
		map = new int[N][M];
		
		list = new ArrayList<CCTV>();
		for(int i = 0 ; i < N ;i++) {
			input = br.readLine().split(" ");
			for(int j = 0 ; j < input.length; j++) {
				int num = Integer.parseInt(input[j]);
				if(num != 0 && num != 6) {
					list.add(new CCTV(i, j, num));
				}
				map[i][j] =	num;
			}
			
		}
		
		dfs(0);
		
	
		System.out.println(ans);
		
	
		


	}
	
	public static void mapcopy(int arr[][],int copy[][]){
		for(int i = 0 ; i < arr.length;i++) {
			for(int j = 0 ; j < arr[i].length; j++) {
				arr[i][j] = copy[i][j];
			}
		}
	}
	
	
	public static void dfs(int idx) {
		
		if(idx == list.size()) { // 다 돌았다..
			int cnt = 0;
			for(int i = 0 ; i < N;i++) {
				for(int j = 0 ; j <M; j++) {
					if(map[i][j] == 0) {
						cnt++;
					}
				}
			}
			
			if(ans > cnt) {
				ans = cnt;
			}
			return;
		}
		

		
		int backup[][] = new int[N][M];
		int type = list.get(idx).type-1;
		CCTV cctv = list.get(idx);
		for(int i = 0 ; i < rot_size[type]; i++) {
			mapcopy(backup, map);
			if(type == 0) { //
				update(i,cctv);
			}else if (type == 1) {
				update(i,cctv);
				update(i+2,cctv);
			}else if (type == 2) {
				update(i,cctv);
				update(i+1,cctv);
			}else if (type == 3) {
				update(i,cctv);
				update(i+1,cctv);
				update(i+2,cctv);
			}else if (type == 4) {
				update(i,cctv);
				update(i+1,cctv);
				update(i+2,cctv);
				update(i+3,cctv);
			}
			
			dfs(idx+1);
			mapcopy(map, backup);
			//원상복구
		}
		
		
	}
	
	public static void update(int dir,CCTV cctv) {		
		dir = dir %4;
		// 동서남북
		if(dir == 0) { 
			for(int x = cctv.x; x < M; x++) {
				if(map[cctv.y][x] == 6) {
					break;
				}else {
					map[cctv.y][x] = 9;
				}
			}
		}else if (dir == 1) {
			for(int y = cctv.y; y >= 0; y--) {
				if(map[y][cctv.x] == 6) {
					break;
				}else {
					map[y][cctv.x] = 9;
				}
			}
		}else if (dir == 2) {
			for(int x = cctv.x; x >= 0; x--) { // 북
				if(map[cctv.y][x] == 6) {
					break;
				}else {
					map[cctv.y][x] = 9;
				}
			}
			
			
		}else if (dir == 3) {
			for(int y = cctv.y; y < N; y++) { // 남
				if(map[y][cctv.x] == 6) {
					break;
				}else {
					map[y][cctv.x] = 9;
				}
			}
			
		}
	}
	
	

	
}
