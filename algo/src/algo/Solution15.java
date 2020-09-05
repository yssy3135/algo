package algo;

public class Solution15 {
    public int maxSubArray(int[] nums) {
    	
    	
    	int before ;
    	before = nums[0];
    	
    	int max = nums[0];
    	
    	for(int i = 1; i < nums.length;i++) {
    		before =  before + nums[i] > 0 ? nums[i] : 0;
    		Math.max(max, before);	
    	}
    	
    	
    	return max;
    	
    	
    }
}]
		
		
		
/*
 * before 라는 수는 전 하위배열의 합을 저장해주는 변수이다.
 * 
 * before변수에 하위 배열의 합을 저장해 두었다가 전 배열의 합이 양수이면 더하고 음수이면
 * 
 * 전 배열의 값의 합보다 작아지기때문에 dp 를 0으로 계산하여 현재의 수를 dp에 새롭게 저장한다.
 * 
 * 큰값을 max 변수에 저장한뒤 비교한다.
 */