package Solution84;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int map[][];

	static int a[] = {0,0,1,-1};
	static int b[] = {1,-1,0,0};
	static int n;
	static int m;
	static int gocnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n =sc.nextInt();
		m = sc.nextInt();
		gocnt = 0;
		map = new int[n][m];

		
		for(int i = 0 ; i < n ;i++) {
			for(int j = 0;j < m ;j++ ) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int start[] = new int[3];
		for(int i = 0 ; i < 3; i++) {
			start[i] = sc.nextInt()-1;
		}
		int end[] = new int[3];
		for(int i = 0 ; i < 3; i++) {
			end[i] = sc.nextInt()-1;
		}
		map[start[0]][start[1]] = 0;
		bfs(start,end);
		
		for(int i = 0 ; i < n ;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println(map[end[0]][end[1]]);
		
	}
	
	public static void bfs(int start[],int end[]) {
		Queue<int[]> que = new LinkedList<int[]>();
		
		que.add(start);
	
		while(!que.isEmpty()) {
			int now[] = que.poll();
			int dir = now[2];
			for(int i = 0 ; i < 4 ;i++) {
				
				int plus = 0;
				if(dir == i) {
					
				}else if(dir + i == 1 || dir + i ==5 ) {
					plus = 2;
				
				}else {
					plus = 1;
				}
				
				for(int j = 1;  j <= 3 ; j++) {
					int mx = now[0] + a[i]*j;
					int my = now[1] + b[i]*j;
					if(mx >= 0 && my >= 0 && mx< n && my <m) {
						if(map[mx][my] == 0 ) {
							map[mx][my] = map[now[0]][now[1]]+1+plus;
							que.add(new int[] {mx,my,i});
						}
					}else {
						break;
					}
				
				}
				

			}
			
			
		}
		
		
		
	}
	

	
}
