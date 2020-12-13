package Soltuion79;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	
	static int rx;
	static int ry;
	static int bx;
	static int by;
	static int holex;
	static int holey;
	static int n;
	static int m;
	static String map[][];
	static int cnt;
	static int movex[] = {0,-1,0,1};
	static int movey[] = {-1,0,1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new String[n][m];
		
		for(int i = 0 ; i < n ; i++) {
				map	[i] = sc.next().split("");
		}
		
		for(int i = 0 ; i < n ;i++) {
			for(int j = 0 ; j < m ; j++) {
				if(map[i][j].equals("R")) {
					rx = i;
					ry = j; 
				}else if(map[i][j].equals("B")) {
					bx = i;
					by = j;
				}else if(map[i][j].equals("0")){
					holex = i;
					holey = j;
				}
			}
		} // for end
		
		bfs();

	}
	
	public static void bfs() {
		Queue<int[]>que = new LinkedList<int[]>();
		que.add(new int[] {rx,ry});
		
		while(!que.isEmpty()) {
			int now[] = que.poll();
			
			
			for(int i = 0 ; i <4 ; i++) {

				int mx = now[0]+movex[i];
				int my = now[1]+movey[i];
				System.out.println(rx+ " "+ ry);
				if(map[mx][my].equals(".") && i == 0) {
					left();
					que.add(new int[] {rx,ry});
				}else if(map[mx][my].equals(".") && i == 2){
					right();
					que.add(new int[] {rx,ry});
				}else if(map[mx][my].equals(".") && i == 1){
					up();
					que.add(new int[] {rx,ry});
				}else if(map[mx][my].equals(".") && i == 3){
					down();
					que.add(new int[] {rx,ry});
				}
				
			}
			return;
		}
	}
	
	
	
	public static void left() {
		while(true) {
			if(ry > 0 && !map[rx][ry-1].equals("#") && !map[rx][ry-1].equals("B")) {
				ry --;
			}else {
				break;
			}
			
			if(map[rx][ry].equals("O")) {
				System.out.println("r들어감");
			}
		}
		while(true) {
			if(by > 0 && !map[bx][by-1].equals("#")&& !map[rx][ry-1].equals("R")) {
				by --;
			}else {
				break;
			}
			if(map[bx][by].equals("O")) {
				System.out.println("b들어감");
			}
		}
		cnt++;
	}
	public static void right() {
		while(true) {
			
			if(ry < m-1 && !map[rx][ry+1].equals("#")&& !map[rx][ry+1].equals("B")) {
				ry ++;
			}else {
				break;
			}
			if(map[rx][ry].equals("O")) {
				System.out.println("r들어감");
			}
			
		}
		while(true) {
			if(by > m-1 && !map[bx][by+1].equals("#")&& !map[bx][by+1].equals("R")) {
				by ++;
			}else {
				break;
			}
			
			if(map[bx][by].equals("O")) {
				System.out.println("b들어감");
			}
			
		}
		cnt++;
	}
	public static void up() {
		while(true) {
			if(rx > 0 && !map[rx-1][ry].equals("#")&& !map[rx-1][ry].equals("B")) {
				rx --;
			}else {
				break;
			}
			if(map[rx][ry].equals("O")) {
				System.out.println("r들어감");
			}
			
		}
		while(true) {
			if(bx > 0 && !map[bx-1][by].equals("#") && !map[bx-1][by].equals("R")) {
				bx--;
			}else {
				break;
			}
			if(map[bx][by].equals("O")) {
				System.out.println("b들어감");
			}
		}
		cnt++;
	}
	public static void down() {
		while(true) {
			if(rx < n-1 && !map[rx+1][ry].equals("#")) {
				rx ++;
			}else {
				break;
			}
			
			if(map[rx][ry].equals("O")) {
				System.out.println("r들어감");
			}
			
		}
		while(true) {
			if(bx > n-1 && !map[bx+1][by].equals("#")) {
				bx ++;
			}else {
				break;
			}
			if(map[bx][by].equals("O")) {
				System.out.println("b들어감");
			}
		}
		cnt++;
	}
	
}
