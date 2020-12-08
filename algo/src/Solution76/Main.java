package Solution76;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int arr[][];
	static int n;
	static int m;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr= new int[n][m];

		ans = 0;
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int way = sc.nextInt();
		
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < m ; j++) {
				arr[i][j] =	 sc.nextInt();
			}
		}
		clean(r,c,way);
//		System.out.println("===================================");
//		for(int i = 0 ; i < n; i++) {
//			for(int j = 0 ; j < m ; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		System.out.println(ans);
		
		
	}
	
	public static void clean(int i ,int j,int way) {
		arr[i][j] = 3;
//		System.out.println("===================================");
//		for(int k = 0 ; k < n; k++) {
//			for(int z = 0 ; z < m ; z++) {
//				System.out.print(arr[k][z]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("방향"+way+"i"+i+"j"+j);
		search(i,j,way);
		ans++;

		
	}
	public static void search(int i,int j,int way) {
		
		if(j <0 || j >=m-1 || i<0 || i >=n-1) return;
		
		if(j-1 >-1 && way == 0) {
			if(arr[i][j-1] == 0 && way == 0) { //탐색시 가능한 구역이있다.
				way = 3;
				j--;
				clean(i,j,way);
			}else if(arr[i][j-1] != 0 ){ // 아니다 탐색이 안된다.
				if(arr[i][j-1] != 0 && arr[i+1][j] != 0 && arr[i][j+1] != 0 && arr[i-1][j] != 0) {
					back(i,j,way);
					return;
				}else {
					way= 3;
					search(i,j,way);
				}
			}
		}else if(i+1<n && way == 3) {
			if(arr[i+1][j] == 0  && way == 3){
				way = 2;
				i++;
				clean(i,j,way);
			}else if (arr[i+1][j] != 0) {
				if(arr[i][j-1] != 0 && arr[i+1][j] != 0 && arr[i][j+1] != 0 && arr[i-1][j] != 0) {
					back(i,j,way);
					return;
				}else {
					way= 2;
					search(i,j,way);
					
				}
				
			}
		}else if(j+1<n  && way == 2) {
			if(arr[i][j+1] == 0  && way == 2) {
				way = 1;
				j++;
				clean(i,j,way);
			}else if (arr[i][j+1] != 0) {
				if(arr[i][j-1] != 0 && arr[i+1][j] != 0 && arr[i][j+1] != 0 && arr[i-1][j] != 0) {
					back(i,j,way);
					return;
				}else {
					way= 1;
					search(i,j,way);
					
				}
			}
		}else if(i-1>-1  && way == 1) {
			if(arr[i-1][j] == 0  && way == 1) {
				way= 0;
				i--;
				clean(i,j,way);
			}else if(arr[i-1][j] != 0){
				if(arr[i][j-1] != 0 && arr[i+1][j] != 0 && arr[i][j+1] != 0 && arr[i-1][j] != 0) {
					back(i,j,way);
					return;
				}else {
					way= 0;
					search(i,j,way);
				}
				
				
			}
		}
		
	}
	
	public static void back(int i,int j,int way) {

		if(way == 0 && n > i+1 ) {
			if(arr[i+1][j]!=1 ) {
				search(i+1,j,way);
			}

		}else if (way == 1 && j-1 > -1) {
			if(arr[i][j-1] !=1) {
				
				search(i,j-1,way);
			}

		}else if (way == 2 &&  i-1>-1 ) {
			if(arr[i-1][j] != 1) {
				search(i-1,j,way);
			}

		}else if (way == 3 && m > j+1) {
			if(arr[i][j+1] !=1) {
				
				search(i,j+1,way);
			}
	
		}

		
	}
	
	

	
}
