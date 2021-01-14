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
		
		public CCTV(int x, int y, int type) {
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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[] = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		map = new int[N][M];
		
		list = new ArrayList<CCTV>();
		for(int i = 0 ; i < N ;i++) {
			input = br.readLine().split(" ");
			for(int j = 0 ; j < input.length; j++) {
				int num = Integer.parseInt(input[j]);
				if(num != 0) {
					list.add(new CCTV(i, j, num));
				}
				map[i][j] =	num;
			}
			
		}
		// 타입의 역순으로 정렬을 한뒤 cctv의 감시범위가 가장 큰방향으로 감시 
		
		list.sort(new Comparator<CCTV>() {
			@Override
			public int compare(CCTV o1, CCTV o2) {
				// TODO Auto-generated method stub
				return o1.type - o2.type;
			}
		});
		
		
		for(int i = 0 ; i < list.size(); i++) {
			
			
//			for(int q =0  ;q < map.length;q++) {
//				System.out.println(Arrays.toString(map[q]));
//			}
//			
			
			
			int copymap[][] = mapcopy();
			CCTV cctv = list.get(i);
			// 복사를 했어

			
			
			if(cctv.type == 5) {
				south(cctv, map);
				left(cctv, map);
				right(cctv, map);
				north(cctv, map);
			}else if(cctv.type == 4) {
				//감시구역의 최대값과 어느 방향인지 알아야함
				int s = south(cctv, copymap);
				int l = left(cctv, copymap);
				int r = right(cctv, copymap);
				int n = north(cctv, copymap);
				
				int arr[] = {r+l+s,r+l+n,s+n+r,s+n+l};
				int max = 0;
				int idx = -1;
				for(int j = 0 ; j < arr.length; j++) {
					if(max < arr[j]) {
						max = arr[j];
						idx = j;
					}
				}
				
				if(idx == 0) {//r,l,s
					right(cctv, map);
					left(cctv, map);
					south(cctv, map);
				}else if(idx ==1) {//r,l,n
					right(cctv, map);
					left(cctv, map);
					north(cctv, map);
				}else if(idx ==2) {//s,n,r;
					south(cctv, map);
					north(cctv, map);
					right(cctv, map);
					
				}else if(idx == 3) {
					south(cctv, map);
					north(cctv, map);
					left(cctv, map);
				}
			}else if(cctv.type == 3) {
				//감시구역의 최대값과 어느 방향인지 알아야함
				int s = south(cctv, copymap);
				int l = left(cctv, copymap);
				int r = right(cctv, copymap);
				int n = north(cctv, copymap);
				
				int arr[] = {n+r,l+n,l+s,s+r};
				int max = 0;
				int idx = -1;
				for(int j = 0 ; j < arr.length; j++) {
					if(max < arr[j]) {
						max = arr[j];
						idx = j;
					}
				}
				
				if(idx == 0) {//n+r
					north(cctv, map);
					right(cctv, map);
				}else if(idx ==1) {//l+n
					left(cctv, map);
					north(cctv, map);
				}else if(idx ==2) {//l+s
					left(cctv, map);
					south(cctv, map);
				}else if(idx ==3) {//s+r
					south(cctv, map);
					right(cctv, map);
				}
				
				
				
			}else if(cctv.type == 2) {
				//감시구역의 최대값과 어느 방향인지 알아야함
				int s = south(cctv, copymap);
				int l = left(cctv, copymap);
				int r = right(cctv, copymap);
				int n = north(cctv, copymap);
				
				int arr[] = {r+l,s+n};
				int max = 0;
				int idx = -1;
				for(int j = 0 ; j < arr.length; j++) {
					if(max < arr[j]) {
						max = arr[j];
						idx = j;
					}
				}

				if(idx == 0) {//r+l
					right(cctv, map);
					left(cctv, map);
				}else if(idx ==1) {//n+s
					north(cctv, map);
					south(cctv, map);
				}
				
				
				
				
			}else if(cctv.type == 1) {
				//감시구역의 최대값과 어느 방향인지 알아야함
				int s = south(cctv, copymap);
				int l = left(cctv, copymap);
				int r = right(cctv, copymap);
				int n = north(cctv, copymap);
				
				int arr[] = {r,l,s,n};
				int max = 0;
				int idx = -1;

				for(int j = 0 ; j < arr.length; j++) {
					if(max < arr[j]) {
						max = arr[j];
						idx = j;
					}
				}

				if(idx == 0) {//r
					right(cctv, map);
				}else if(idx ==1) {//l
					left(cctv, map);
				}else if(idx ==2) {//s
					south(cctv, map);
				}else if(idx ==3) {//n
					north(cctv, map);
				}
				
				
			}
			
			
			
			
		}// for end
		
		
		for(int i =0  ;i < map.length;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		int cnt = 0;
	
		for(int i = 0 ;i  < map.length; i++) {
			for(int j = 0 ; j < map[i].length; j++) {
				if(map[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		
		
		System.out.println(cnt);

	}
	
	public static int[][] mapcopy(){
		int copy[][] = new int[N][M];
		for(int i = 0 ; i < map.length;i++) {
			for(int j = 0 ; j < map[i].length; j++) {
				copy[i][j] = map[i][j];
			}
		}
		
		return copy;
		
	}
	
	
	public static int left(CCTV cctv,int copymap[][]) {
		
		int x = cctv.x;
		int y = cctv.y;
		
		int cnt = 0;
		while(true) {
			y -= 1;
			if(y>=0 ) {
				if(copymap[x][y] == 9 ||copymap[x][y] == 1||copymap[x][y] == 2||copymap[x][y] == 3||copymap[x][y] == 4||copymap[x][y] == 5) {
					continue;
				}else if(copymap[x][y] == 0  ) {
					copymap[x][y] = 9;
					cnt++;	
				}else {
					return cnt;
				}
			}else {
				return cnt;
			}
		}

	}
	
	public static int right(CCTV cctv,int copymap[][]) {
		int x = cctv.x;
		int y = cctv.y;
		
		int cnt = 0;
		while(true) {
			y += 1;
			if(y <M ) {
				if(copymap[x][y] == 9 ||copymap[x][y] == 1||copymap[x][y] == 2||copymap[x][y] == 3||copymap[x][y] == 4||copymap[x][y] == 5) {
					continue;
				}else if(copymap[x][y] == 0 ) {
					
					copymap[x][y] = 9;
					cnt++;	
				}else {
					return cnt;
				}
			}else {
				return cnt;
			}
		}
	}
	public static int south(CCTV cctv,int copymap[][]) {
		
		int x = cctv.x;
		int y = cctv.y;
		
		int cnt = 0;
		while(true) {
			x += 1;
		
			if(x <N ) {
				if(copymap[x][y] == 9 ||copymap[x][y] == 1||copymap[x][y] == 2||copymap[x][y] == 3||copymap[x][y] == 4||copymap[x][y] == 5) {
					continue;
				}else if(copymap[x][y] == 0  ) {
					copymap[x][y] = 9;
					cnt++;	
				}else {
					return cnt;
				}
			}else {
				return cnt;
			}
		}
	}
	public static int north(CCTV cctv,int copymap[][]) {
		int x = cctv.x;
		int y = cctv.y;

		int cnt = 0;
		while(true) {
			x -= 1;
			if(x >=0 ) {
				if(copymap[x][y] == 9 ||copymap[x][y] == 1||copymap[x][y] == 2||copymap[x][y] == 3||copymap[x][y] == 4||copymap[x][y] == 5) {
					continue;
				}else if(copymap[x][y] == 0 ) {
					copymap[x][y] = 9;
					cnt++;	
				}else {
					return cnt;
				}	
			}else {
				return cnt;
			}
		}
	}
	
	
}
