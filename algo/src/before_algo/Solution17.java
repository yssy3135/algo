package before_algo;

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
 * val�� �������� �����ϰ� �ƴѼ��鸸 ���� �迭�� �Ҵ��Ѵ� �迭�� �ݺ��ϸ鼭 val�� �ٸ��� �ٸ������� �߰��ϴ� index j�� ���Ӱ�
 * ������ �߰��ϰ� j ������ ������ ���Ӱ� �Ҵ��� �� �̹Ƿ� j�� �������ش�
 */