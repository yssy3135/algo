package Solution75;

import java.util.Scanner;

public class Main {
	
	public static int wheel[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		wheel = new int[4][8];
		
		for(int i = 0 ;i  < wheel.length;i++) {
			String s = sc.next();
			for(int j = 0 ; j < s.length(); j++) {
				wheel[i][j] = s.charAt(j) - '0';
			}
		}
	
		int times = sc.nextInt();
		
		int spin[][] = new int[times][2];
		for(int i = 0 ; i < times; i++) {
			spin[i][0] = sc.nextInt()-1;  //회전 바퀴번호
			spin[i][1] = sc.nextInt();  //회전 방향
			
			start(spin[i][0],spin[i][1]);
			
		}
		
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            if(i == 0) {
            	ans += wheel[i][0] == 1 ? 1 :0;
            }else if(i ==1) {
            	ans += wheel[i][0] == 1 ? 2 :0;
            }else if(i ==2) {
            	ans += wheel[i][0] == 1 ? 4 :0;
            }else if(i ==3) {
            	ans += wheel[i][0] == 1 ? 8 :0;
            }
            
        }
        
		System.out.println(ans);
		
	}
	public static void start(int index,int way) {
		left(index-1,-way);
		right(index+1,-way);
		rotate(index,way);
	}
	public static void left(int index,int way) {
		if(index<0) return;
		
		if(wheel[index][2] != wheel[index+1][6]) {
			left(index-1 ,-way);
			rotate(index,way);
		}
		
	}
	public static void right(int index,int way) {
		if(index>3) return;
		
		if(wheel[index][6] != wheel[index-1][2]) {
			right(index+1 ,-way);
			rotate(index,way);
		}
		
	}
	
	public static void rotate(int idx,int way) {
		
		// 시계방향
		if(way == 1) { 
			int tmp = wheel[idx][7];
			
			for(int i = 7 ; i > 0  ; i--) {
				wheel[idx][i] = wheel[idx][i-1];
			}
			wheel[idx][0] =	 tmp;
			
		// 반시계 방향
		}else if( way == -1) {
			int tmp = wheel[idx][0];
			for(int i = 0 ; i < 7;i++) {
				wheel[idx][i] = wheel[idx][i+1];
			}
			wheel[idx][7] = tmp;
			
		}
		
	}
	

	
}



//N극이 0 S극은 1 12시방향부터 5줄에 회전횟수
