package Solution68;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		solution("KAKAO");
		
	}
	
    public static int[] solution(String msg) {
        int[] answer = {};
        
        Map<Integer, String> map = new HashMap<Integer, String>();
        
        
        for(int i = 1 ; i < 27;i++) {
        	char a = (char) (64+i);
        	map.put(i, Character.toString(a));
        }
        String word[] = msg.split("");
        dic(map,word);
        
        
        return answer;
    }
    
    public static void dic(Map<Integer, String> map ,String word[]) {
    	
    	int cnt = 26;
    	boolean flag = false;
    	ArrayList<String> list = new ArrayList<String>();
    	StringBuilder sb = new StringBuilder();
    	//등록 여부
    	for(int i = 0 ; i < word.length;i++) {
    		String w = word[i];
    		
    		
    		while(map.containsValue(w)) {
    			i++;
    			
    			if( i == word.length) {
    				flag = true;
    				break;
    			}
    			
    			w+=word[i];
    		}
    		
    		if(flag) {
    			list.add(w);
    			break;
    		}
    		
    		System.out.println();
    		cnt++;
    		map.put(cnt, w);
    		System.out.println(w);
    		
    	
    	}
    	
    	
    	
    	
    };
    

    
    
    
}
