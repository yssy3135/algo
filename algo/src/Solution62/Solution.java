package Solution62;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
	
	public static void main(String[] args) {
		String a = "handshake";
		String b = "shake hands";
		System.out.println(a.substring(0, a.length()));


//		printf(%d\r\n, solution(ABDDD, DDEFGHH));
//		printf(%d\r\n, solution(AACCC, A A A A A C C C C));
//		printf(%d\r\n, solution(AA_bb_aa_AA, BBB));
//		printf(%d\r\n, solution(CCDEFGHH, ABCCC));
//		printf(%d\r\n, solution(FRANCE, french));
//		printf(%d\r\n, solution(handshake, shake hands));
//		printf(%d\r\n, solution(aa1+aa2, AAAA12));
//		printf(%d\r\n, solution(E=M*C^2, e=m*c^2));
//
//		Result =================================
//		7281
//		0
//		13107
//		6553
//		16384
//		65536
//		43690
//		65536
		
		System.out.println(solution(a,b));
		
	}
	
    public static int solution(String str1, String str2) {
        int answer = 0;

		
        ArrayList<String> list = div(str1);
        ArrayList<String> list2 = div(str2);
        ArrayList<String> hap = new ArrayList<String>();
        ArrayList<String> gyo = new ArrayList<String>();
        
        
        hap.addAll(list);
        hap.addAll(list2);
        
        
        if(list.size() == 0 && list2.size() ==0){
        	return 65536;
        }
 
        
        
       
        if(list.size()<list2.size()) {
        	int size = list2.size();
        	for(int i = 0 ; i < list.size(); i++) {
        		if(list2.contains(list.get(i))) {
        			
        			if(gyo.size()<size) {
        				gyo.add(list.get(i));
        			}
        			hap.remove(list.get(i));
        			list2.remove(list2.indexOf(list.get(i)));
        		}
        	}

        }else {
        	int size = list.size();
        	for(int i = 0 ; i < list2.size(); i++) {
        		if(list.contains(list2.get(i))){
        			if(gyo.size()<size) {
        				gyo.add(list2.get(i));
        			}
        			hap.remove(list2.get(i));
        			list.remove(list.indexOf(list2.get(i)));
        		}
        	}
        }
        
        if(gyo.size() == 0) {
        	return 0;
        }


        System.out.println(gyo.size());
        System.out.println(hap.size());
        System.out.println(gyo.toString());
        System.out.println(hap.toString());
        
        double f = ((double)gyo.size()/(double)hap.size())*(double)65536;
        System.out.println((int)f); // 합집합
        
        
        
        
        return (int)f;
    }
    
    public static ArrayList<String> div(String str) {
    	ArrayList<String> list = new ArrayList<String>();
    	for(int i = 0 ; i < str.length(); i ++) {
//    		System.out.println(str.substring(i, i+2 > str.length() ? i :i+2));
    		
    		String match = "[^\uAC00-\uD7A3xfea-zA-Z\\s]";
    		String tmp = str.substring(i, i+2 > str.length() ? i :i+2);
    		
    		tmp = tmp.replaceAll(match,"").trim();
    	
    		System.out.println(tmp);
    		if(tmp.length()>1 ) {
    			list.add(tmp.toUpperCase());
    		}
    		
    		
    	}
    	list.sort(null);
    	System.out.println(list.toString());
    	
    	return list;
    }
	
	
}
