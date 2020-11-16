package Solution64;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) {
		String a[] = {"Jeju", "Pangyo", "NewYork", "newyork"};
		
		solution(0,a);
	}
	
	
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Queue<String> que = new LinkedList<String>();
        
        
        for(String city : cities) {
        	city = city.toLowerCase();
        	if(cacheSize == 0 ) {
        		answer +=5;
        		continue;
        	}
        	
        	if(que.size()< cacheSize) {
        		
        		if(que.contains(city)) {
        			que.remove(city);
        			que.add(city);
        			answer++;
        		}else {
        			que.offer(city);
        			answer+=5;
        		}
        	}else if(que.contains(city)) {
        			que.remove(city);
        			que.offer(city);
        			answer++;
        	}else {
        		que.poll();
        		que.offer(city);
        		answer +=5;
        	}
        	
        	
        }
        System.out.println(answer);
        
        return answer;
    }
	
	
	
}
