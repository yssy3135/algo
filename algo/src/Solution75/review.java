package Solution75;

import java.util.Arrays;
import java.util.Scanner;

public class review {
	
	
	static int arr[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		arr = new int [4][8];
		for(int i = 0 ; i < 4 ; i++) {
			String s = sc.next();
			for(int j = 0 ; j <s.length();j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		int rotatenum = sc.nextInt();
		
		int rotate[][] =new int[rotatenum][2];
		for(int i = 0 ; i < rotatenum; i++) {
			rotate[i][0] =	sc.nextInt();
			rotate[i][1] = sc.nextInt();
			
			start(rotate[i][0]-1,rotate[i][1]);
		}
		
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            if(i == 0) {
            	ans += arr[i][0] == 1 ? 1 :0;
            }else if(i ==1) {
            	ans += arr[i][0] == 1 ? 2 :0;
            }else if(i ==2) {
            	ans += arr[i][0] == 1 ? 4 :0;
            }else if(i ==3) {
            	ans += arr[i][0] == 1 ? 8 :0;
            }
            
        }
        
        System.out.println(Arrays.deepToString(arr));
		System.out.println(ans);
		
		
	}
	
	
	public static void start(int i, int way) {
		left(i-1,-way);
		right(i+1,-way);
		round(i,way);
	}
	
	public static void round(int i, int way) {
		
		if(way == 1) {
			int tmp = arr[i][7];
			
			for(int j = 7 ; j > 0; j--) {
				arr[i][j] =	arr[i][j-1];
			}
			arr[i][0] = tmp;
			
		}else if(way == -1) {
			int tmp = arr[i][0];
			for(int j = 0; j < 7; j++) {
				arr[i][j] = arr[i][j+1];
			}
			arr[i][7] = tmp;
		}
		
		
	}
	
	public static void left(int i, int way) {
		if(i <0) return ;
		
		if(arr[i][2] != arr[i+1][6]) {
			left(i-1,-way);
			round(i,way);
		}
			
	}
	public static void right(int i,int way) {
		if(i > 3) return;
		
		if(arr[i][6] != arr[i-1][2]) {
			right(i+1,-way);
			round(i,way);
		}
	}
	
}
