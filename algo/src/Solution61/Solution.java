package Solution61;

public class Solution {
	public static void main(String[] args) {
		
		solution(8,4,7);
	}
	
    public static int solution(int n, int a, int b)
    {
        int answer = 0;
        
       
        	while(a !=b) {
        		a = Math.round((float)a/2);
        		b = Math.round((float)b/2);
        		answer ++;
        	}
        
        
        
        System.out.println(answer);

        return answer;
    }
	
}
