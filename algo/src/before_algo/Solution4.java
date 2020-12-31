package before_algo;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution4 {
	
	
	
	static int count;
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		if(n>20) {
			
			BigInteger two = new BigInteger("2");
			BigInteger ans = two.pow(n).subtract(BigInteger.ONE);
			System.out.println(ans);
			
		}else {
			BigInteger two = new BigInteger("2");
			BigInteger ans = two.pow(n).subtract(BigInteger.ONE);
			System.out.println(ans);
			hanoi("1","2","3",n);
			
		}
		
		
		
		
		
	}
	
	
	
	

	
	static void hanoi (String first,String mid,String last, int n) {
		
		
		
		if(n == 1 ) {
			count++;
			// 첫번째 거를 마지막으로
			System.out.println(first+" "+last);
			
		}else {
			hanoi(first,last,mid,n-1);
			// 마지막거를 중간으로
			System.out.println(first+" "+last);
			count++;
			
			hanoi(mid,first,last,n-1);
		}
		
		
		
		
		
		
	}
	

	
	
	
}
