package before_algo;

class Solution2 {
    public int solution(int n) {
        int answer = 0;
        
        
        for(int i = 1 ; i <= n;i++) {
        	
        	for(int j = i+1; j <= n; j++) {
        		int sum = i;
        		
        		if(sum == n) {
        			answer++;
        		}else if (sum > n) {
        			break;
        		}else {
        			if(sum < n) {
        				sum = sum+j;
        			}
        		}
        		
        		
        		
        	}//for end
        	
        }// for end
        
        
        return answer;
    }
}