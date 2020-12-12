package Solution78;


import java.util.Scanner;

public class Main {
	static class Dice {
		int south,north,west,east,top,bottom;
		
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
	
	
	static int arr[][];	
	static int movex[];
	static int movey[];
	static int N;
	static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N][M];
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		movex = new int[]{0,0,-1,1};
		movey = new int[]{1,-1,0,0};
		
		//지도 표시
		int order = sc.nextInt();
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				arr[i][j] =	sc.nextInt();
			}
		}
		//이동 명령
		int move[] = new int[order];
		for(int i = 0 ; i< order ; i++) {
			move[i] = sc.nextInt()-1;	
		}
		
		play(move, x, y);
		// 주사위 초기 위치는 윗면이 1 동쪽을 바라보는 방향이 3
	

	}
	
	public static void play(int move[],int x,int y) {
		Dice dice = new Dice();
		int mx = x;
		int my = y;
	
		for(int i = 0 ;i <move.length; i++) {
			mx = mx + movex[move[i]];
			my = my + movey[move[i]];
			

			if(mx >=0 && my >=0 && mx < N && my < M ) {
				
				if(move[i] == 0) { // 동
					dice.left();
				}else if(move[i] == 1) { //서	
					dice.right();
				}else if(move[i] == 2) { //북
					dice.up();
				}else if(move[i] == 3) { //남
					dice.down();
				}
				
				if(arr[mx][my] == 0) {
					arr[mx][my] = dice.bottom;
				}else {
					dice.bottom= arr[mx][my] ;
					arr[mx][my] = 0;
				}
				
				dice.printtop();
			}else {
				mx = mx - movex[move[i]];
				my = my - movey[move[i]];
			}
			
			
			
		}
		
	}
	

	

	
	
}
