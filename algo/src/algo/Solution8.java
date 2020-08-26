package algo;

import java.util.Arrays;



public class Solution8 {
	public static void main(String[] args) {
//		무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
	
		int people[] = {70,50,80,50};
		int limit = 100;
		
		System.out.println(solution(people,limit));
		
	}
	
    static public int solution(int[] people, int limit) {
    	int answer =0;
    	
    	Arrays.sort(people);
    	
    	int index = people.length-1;
    	
    	// 최대값과 최소값이 함께 보트를 타야 가장적게 보트를 탈수있다.
    	for(int i = 0 ;i <= index ; i++) {
    		
    		
    		// 최소값과 최대값이 limit을 넘으면 어느사람과도 못탐 결국 혼자 
    		while(i <index && people[index] + people[i] >limit) {
    				index--;
    				answer++;
    			
    		}
    		
    		//while문을 빠져나왔을때는 i와 index가 같거나   index && people[index] + people[i] <=limit 만족
    		
    		if( people[index] + people[i] <=limit) {  // 일치하면 index증가
    			
    			index--;
    			
    		}
    		answer++;
    	
    		
    	}

		return answer;
    
    }
	
	
	
	
}
