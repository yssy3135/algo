package Test2;

public class Solution3 {
	public static void main(String[] args) {
		System.out.println(solution("abcdcba"));
	}

	
	 private static int palindrome(String str, int max) {
	        int length = str.length();
	        int mid = length/2;

	        for (int i = 0; i < mid; i++) {
	            String f = str.substring(i,mid);
	            String b = (length % 2 == 0) ? str.substring(mid,length-i) : str.substring(mid+1,length-i);
	            StringBuilder sb_back = new StringBuilder(b);


	            if( sb_back.reverse().toString().equals(f) ) {
	                max = Math.max(max,length-(2*i));
	            }
	        }

	        return max;
	   }
	
	
    public static int solution(String s) {
        int length = s.length();

        if (length == 0) {
        	return 0;
        }
        if (length == 1) {
        	return 1;
        }

        int l = 1; 
        int r = 1;
        for (int i = length; i >= 0; i--) {
            l = palindrome(s.substring(0,i),l);
            r = palindrome(s.substring(i,length),r);
        }

        return Math.max(l, r);
    }
}
