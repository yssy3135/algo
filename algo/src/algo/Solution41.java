package algo;

import java.util.Scanner;

public class Solution41 {
	
		static int arr[];
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int num = sc.nextInt();
			
			
			for(int i = 0 ; i < num ;i++) {
				System.out.println(sum(sc.nextInt()));
			}

		}
		
		
		public static int sum(int n) {
			if(n ==1)return 1;
			if(n ==2)return 2;
			if(n ==3)return 4;

			return sum(n-1)+sum(n-2)+sum(n-3);
		}
		
		
	}
	
	



