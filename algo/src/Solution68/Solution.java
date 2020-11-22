package Solution68;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Solution {
	public static void main(String[] args) {
		solution("KAKAO");
		
	}
	
    public static int[] solution(String msg) {
        int[] answer = {};
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        
        for(int i = 1 ; i < 27;i++) {
        	char a = (char) (64+i);
        	map.put(Character.toString(a), i);
        }
        String word[] = msg.split("");
        answer = dic(map,word);
        
        
        return answer;
    }
    
    public static int[] dic(Map<String, Integer> map ,String word[]) {
    	
    	int cnt = 26;
    	boolean flag = false;
    	ArrayList<Integer> list = new ArrayList<Integer>();
   
    	//등록 여부
    	for(int i = 0 ; i < word.length;i++) {
    		String w = word[i];
    		
    		
    		System.out.println(w);
    		while(map.containsKey(w)) {
    			i++;
    			
    			if( i == word.length) {
    				flag = true;
    				break;
    			}
    			
    			w+=word[i];
    		}
    		
    		if(flag) {
    			list.add(map.get(w));
    			break;
    		}
    		
    		list.add(map.get(w.substring(0, w.length()-1)));
    		map.put(w, ++cnt);
    		
    		i--;
    	}
    	
    	
    	System.out.println(list.toString());
    	
    	
    	Integer arr[] = list.toArray(new Integer[0]);
    	int ar[] = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
    	
		return ar;
    	
    };
    

    
    
    
}
