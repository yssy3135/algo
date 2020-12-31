package before_algo;

import java.util.Arrays;



public class Solution8 {
	public static void main(String[] args) {
//		���ε��� ���� ������� ����Ʈ�� �̿��Ͽ� �����Ϸ��� �մϴ�. ����Ʈ�� �۾Ƽ� �� ���� �ִ� 2�� �ۿ� Ż �� ����, ���� ���ѵ� �ֽ��ϴ�.
	
		int people[] = {70,50,80,50};
		int limit = 100;
		
		System.out.println(solution(people,limit));
		
	}
	
    static public int solution(int[] people, int limit) {
    	int answer =0;
    	
    	Arrays.sort(people);
    	
    	int index = people.length-1;
    	
    	// �ִ밪�� �ּҰ��� �Բ� ��Ʈ�� Ÿ�� �������� ��Ʈ�� Ż���ִ�.
    	for(int i = 0 ;i <= index ; i++) {
    		
    		
    		// �ּҰ��� �ִ밪�� limit�� ������ ���������� ��Ž �ᱹ ȥ�� 
    		while(i <index && people[index] + people[i] >limit) {
    				index--;
    				answer++;
    			
    		}
    		
    		//while���� �������������� i�� index�� ���ų�   index && people[index] + people[i] <=limit ����
    		
    		if( people[index] + people[i] <=limit) {  // ��ġ�ϸ� index����
    			
    			index--;
    			
    		}
    		answer++;
    	
    		
    	}

		return answer;
    
    }
	
	
	
	
}
