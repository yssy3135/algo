package Solution78;

import java.util.Scanner;

public class review78 {
	
	public static class Dice {
		int south,north,east,west,top,bottom;
		
		public Dice() {
			this.south = 0;
			this.north = 0;
			this.west = 0;
			this.east = 0;
			this.top = 0;
			this.bottom = 0;
		}
		
		public void up() {
			int tmp = top;
			top = south;
			south = bottom;
			bottom = north;
			north = tmp;
		}
		
		public void down() {
			int tmp = top;
			top = north;
			north = bottom;
			bottom = south;
			south = tmp;
		}
		
		public void right() {
			int tmp = top;
			top = west;
			west = bottom;
			bottom = east;
			east = tmp;
		}
		
		public void left() {
			int tmp = top;
			top = east;
			east = bottom;
			bottom = west;
			west = tmp;
		}
		
		public void printtop() {
			System.out.println(top);
		}
		
		
		
	}
	
	static int move[];
	static int movex[];
	static int movey[];
	static int N;
	static int M;
	static int arr[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		movex = new int[]{0,0,-1,1};
		movey = new int[]{1,-1,0,0};
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		int x= sc.nextInt();
		int y = sc.nextInt();
		
		int order = sc.nextInt();
		
		 arr = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		move = new int[order];
		for(int i = 0 ; i < order; i++) {
			move[i] = sc.nextInt()-1;
		}
		play(x,y);
		
	}
	
	
	public static void play(int x , int y) {
		Dice dice = new Dice();
		int mx = x;
		int my = y;
		for(int i = 0 ; i  < move.length; i++) {
			mx = mx+movex[move[i]];
			my = my+movey[move[i]];
			
			if(mx>=0&&my>=0&& mx <N&&my <M ) {
				
				if(move[i] == 0) {
					dice.right();
					dice.printtop();
					if(arr[mx][my] == 0) {
						arr[mx][my] = dice.bottom;
					}else {
						dice.bottom = arr[mx][my];
						arr[mx][my] = 0;
					}
				}else if (move[i] == 1) {
					dice.left();
					dice.printtop();
					if(arr[mx][my] == 0) {
						arr[mx][my] = dice.bottom;
					}else {
						dice.bottom = arr[mx][my];
						arr[mx][my] = 0;
					}
				}else if (move[i] == 2) {
					dice.up();
					dice.printtop();
					if(arr[mx][my] == 0) {
						arr[mx][my] = dice.bottom;
					}else {
						dice.bottom = arr[mx][my];
						arr[mx][my] = 0;
					}
				}else if (move[i] == 3) {
					dice.down();
					dice.printtop();
					if(arr[mx][my] == 0) {
						arr[mx][my] = dice.bottom;
					}else {
						dice.bottom = arr[mx][my];
						arr[mx][my] = 0;
					}
				}
			
			}else {
				mx = mx-movex[move[i]];
				my = my-movey[move[i]];
			}
		}
		
		
	}
	
}
