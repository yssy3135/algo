package algo;

public class Solution17 {
    public int removeElement(int[] nums, int val) {
    	
    	
    	int j= 0 ;
    	
    	for(int i = 0 ; i < nums.length;i++) {
    		if(nums[i] != val ) {
    			nums[j] = nums[i];
    			j++;
    		}
    	}
    	
                
        
        return j;
    }
}




/*
 * val과 같은수는 제거하고 아닌수들만 같은 배열해 할당한다 배열을 반복하면서 val과 다르면 다른수들을 추가하는 index j를 새롭게
 * 선언해 추가하고 j 까지의 수들이 새롭개 할당한 수 이므로 j를 리턴해준다
 */