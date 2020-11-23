package RESolution59;

public class Solution {
	public static void main(String[] args) {
		solution(5000);
		
	}
	
	
	
	public static void solution(int n ) {
		int cnt = 0 ;
		
		while(n >0) {
			if(n%2 == 0) {
				n = n/2;
			}else {
				n = n-1;
				cnt++;
			}
			
		}
		
		System.out.println(cnt);
		
	}
}
