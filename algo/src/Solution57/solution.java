package Solution57;

public class solution {
	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4};
		solution(arr);
	}
	
	
	static boolean visited[];
	static int answer;
    public static int solution(int[] nums) {
        answer = 0;

        visited = new boolean[nums.length];
        
        for(int i = 0 ; i < nums.length;i++) {
        	for(int j = i+1 ; j < nums.length; j++) {
        		for(int k = j+1 ; k < nums.length; k++) {
        			int num = nums[i]+nums[j]+nums[k];
        				if(sosu(num)) {
        					answer ++;
        				}
        			
        		}
        	}
        }
        
        
        return answer;
    }
    
    
//    public static void combi(int arr[] ,int start,int n, int r) {
//    	if( r== 0 ) {
//    		int num = 0;
//    		int cnt = 0 ;
//    		for(int i = 0 ; i < n ; i++) {
//    			if(visited[i]) {
//    				System.out.print(arr[i] + " ");
//    				num += arr[i];
//    			}
//    		}
//    		System.out.println();
//    		// 소수 판별
//    		if(sosu(num)) {
//    			answer++;
//    		}
//    	}
//    	
//    	for(int i = start ; i < n ; i ++) {
//    		visited[i] = true;
//    		combi(arr,i+1,n,r-1);
//    		visited[i] = false;
//    	}
//    	
//    	
//    }
    
    
    public static boolean sosu(int num) {
    	
    	int sqrt = (int) Math.sqrt(num);
    	
    	for(int i = 2 ; i <= sqrt; i++) {
    		if(num%i == 0) {
    			return false;
    		}
    	}
    	
    	
    	
    	
    	
		return true;
    	
    }
    
    
}
