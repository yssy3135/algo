package before_algo;

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
 * before ��� ���� �� �����迭�� ���� �������ִ� �����̴�.
 * 
 * before������ ���� �迭�� ���� ������ �ξ��ٰ� �� �迭�� ���� ����̸� ���ϰ� �����̸�
 * 
 * �� �迭�� ���� �պ��� �۾����⶧���� dp �� 0���� ����Ͽ� ������ ���� dp�� ���Ӱ� �����Ѵ�.
 * 
 * ū���� max ������ �����ѵ� ���Ѵ�.
 */