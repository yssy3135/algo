package Solution70;

public class Solution {
	public static void main(String[] args) {
		
		
		solution(16,16,2,2);
		
	
		
	}
	
    public static String solution(int n, int t, int m, int p) {
    	String answer = "";
    	String num = "0";
    	int numlist = 0 ;
    	while(num.length() < t*m) {
    		String trans = "";
    		int cntnum = numlist++;
    	
    		
    		while(cntnum != 0 ) {
    			if(cntnum%n >= 10) {
    				trans = String.valueOf((char)(cntnum%n+55)) +trans;
    			}else {
    				trans = String.valueOf(cntnum%n)+ trans;
    			}
    			cntnum = cntnum/n;
    		}
    		
    		num  += trans;
    		System.out.println(num + "cnt"+trans);
    		
    	}
    	
    	
    	
    	for(int i = 0 ; i < t ; i++) {
    		answer +=String.valueOf(num.charAt(m*i+p-1)); 
    	}
    	
    	System.out.println(answer);
    	
		return answer;
       
    }
    

	
	
	
}
