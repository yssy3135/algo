package algostydy06_Baekjoon_16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
	
	static int map[][];
	static boolean visited[][];
	static int a[] = {-1,0,1,0};
	static int b[] = {0,-1,0,1};
	static int n;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		int shark[] = new int[2];
		
		for(int i = 0 ; i < n ; i++) {
			String tmp[] =  br.readLine().trim().split(" ");
			for(int j = 0 ; j < tmp.length ; j++) {
				int num = Integer.parseInt(tmp[j]);
				map[i][j] = num;
				
				//아기 상어의 초기 위치 저장
				if(num == 9) {
					shark[0] = i;
					shark[1] = j;
				}
			}
		}
		
		
		ans = 0;
		bfs(shark[0],shark[1]);
		
		while(true){
			
			//1 더이상 먹을 수 있는 물고기가 공간에 없다면 
			
			
			
			
		}
		
		

		
	}
	
	public static void bfs(int x,int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		
		que.add(new int[] {x,y,2,0,0});
		ArrayList<int[]> list = new ArrayList<int[]>();
		while(!que.isEmpty()) {
			int	shark[] = que.poll();
			int size = shark[2]; //상어 크기
			int eat = shark[3]; //먹은 물고기 수
			int move = shark[4];
			
			for(int i = 0 ; i< 4 ; i++) {
				int mx = shark[0]+a[i]; 
				int my = shark[1]+b[i];
				boolean flag = false;
				if(mx>=0 && my>=0 && mx <n && my<n) {
					if( (map[mx][my] == 0 || map[mx][my] == size) ) { //빈공간이거나 크기가 같으면 이동
						
				
						que.add(new int[] {mx,my,size,eat,move+1});
						
					}else if(map[mx][my] < size  ) { //빈공간이 아니고 물고기 사이즈가 내 사이즈보다 작으면

						flag = true;
						
						
					}else if(map[mx][my] > size && map[mx][my] !=9) { // 물고기 사이즈가 내 사이즈보다 크면
						
					}
				}
				System.out.println("==============================");
				for(int z = 0 ; z < n ;z++) {
					System.out.println(Arrays.toString(map[z]));
				}
			}

		}
		
	}
	
	

	
	
}
