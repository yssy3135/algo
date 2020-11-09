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
        
        combi(nums,0,nums.length,3);
        
        return answer;
    }
    
    
    public static void combi(int arr[] ,int start,int n, int r) {
    	if( r== 0 ) {
    		int num = 0;
    		int cnt = 0 ;
    		for(int i = 0 ; i < n ; i++) {
    			if(visited[i]) {
    				System.out.print(arr[i] + " ");
    				num += arr[i];
    			}
    		}
    		System.out.println();
    		// 소수 판별
    		if(sosu(num)) {
    			answer++;
    		}
    	}
    	
    	for(int i = start ; i < n ; i ++) {
    		visited[i] = true;
    		combi(arr,i+1,n,r-1);
    		visited[i] = false;
    	}
    	
    	
    }
    
    
    public static boolean sosu(int num) {
    	
    	int sqrt = (int) Math.sqrt(num);
    	
    	for(int i = 4 ; i <= sqrt; i++) {
    		if(num%i == 0) {
    			return false;
    		}
    	}
    	
    	
    	
    	
    	
		return true;
    	
    }
    
    
}
