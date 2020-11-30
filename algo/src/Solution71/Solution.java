package Solution71;

import java.util.ArrayList;

import java.util.Collections;

import java.util.HashMap;
import java.util.HashSet;

import java.util.Map;

import java.util.TreeMap;


public class Solution {
	public static void main(String[] args) {
		String genres[]= {"classic","pop","classic","classic","pop"};
		int plays[] = {500,600,800,800,2500};
		
		solution(genres,plays);
		
	}
	
	
    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new TreeMap<String, Integer>( );
        Map<Integer, Integer> index = new HashMap<Integer, Integer>( );
        Map<Integer, String> rev = new HashMap<Integer, String>( );
        Map<Integer, String> remap = new HashMap<Integer, String>( );
        HashSet<String> set = new HashSet<String>();

        
        for(int i=0;i<genres.length;i++) {
        	if(map.get(genres[i]) == null) {
        		map.put(genres[i], plays[i]);
        	}else {
        		int play = map.get(genres[i]);
        		map.put(genres[i], play+plays[i]);
        	}
        	index.put(plays[i], i);
        	set.add(genres[i]);
        	rev.put(plays[i],genres[i]);
        }

        ArrayList<Integer> sortgenre = new ArrayList<Integer>();
        for(String genre : set) {
        	sortgenre.add(map.get(genre));
        	remap.put(map.get(genre), genre);
                }
        // 어떤장르가 가장큰지 정렬
        sortgenre.sort(Collections.reverseOrder());
        ArrayList<Integer> sortplays = new ArrayList<Integer>();
        
        for(int i = 0 ;i < plays.length;i++) {
        	sortplays.add(plays[i]);
        }
        sortplays.sort(Collections.reverseOrder());
       
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0 ; i < sortgenre.size(); i++) {
        	System.out.println("장르숫자"+sortgenre.get(i));
        	String name = remap.get(sortgenre.get(i));
        	System.out.println("이름"+name);
        	int cnt = 0;
        	for(int j = 0 ; j < sortplays.size(); j++) {
        		System.out.println("정렬"+sortplays.get(j));
        		System.out.println("비교"+rev.get(sortplays.get(j)));
        		if(rev.get(sortplays.get(j)).equals(name)) {
        			if(cnt >1) break;
        			
        			for(int k = 0 ; k < plays.length; k++) {
        				if(plays[k] == sortplays.get(j) && name.equals(genres[k]) ) {
        					ans.add(k);
        					System.out.println("추가"+k);
        					cnt++;
        				}
        			}
        			if(cnt == 2 && ans.get(ans.size()-1) == ans.get(ans.size()-2)) {
        				System.out.println("같다");
        				if(ans.get(ans.size()-2)>= ans.get(ans.size()-1)) {
        					continue;
        				}else {
        					int big = ans.get(ans.size()-2);
        					int small = ans.get(ans.size()-1);
        					
        					ans.remove(ans.size()-1);
        					ans.remove(ans.size()-1);
        					ans.add(small);
        					ans.add(big);
        				}
        				
        				
        			}
        			
        		
        		}
        	}
        }
        

        System.out.println(map.toString());
        System.out.println(rev.toString());
        System.out.println(sortgenre);
        System.out.println(ans);

        ans.toArray();
        int answer[] = new int[ans.size()];
        for(int i = 0 ; i < ans.size();i++) {
        	answer[i]=ans.get(i);
        }
        
        return answer;
    }
    


}
