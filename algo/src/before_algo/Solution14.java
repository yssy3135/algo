package before_algo;

public class Solution14 {
	
    public String longestCommonPrefix(String[] strs) {
    	
    	int min = 100;
    	int sword = 0;
    	for(int i = 0 ; i< strs.length;i++) {
    		
    		if(min > strs[i].length()) {
    			min = strs[i].length();
    			sword = i;
    		}
    		
    		
    	}
    	String word = strs[sword];
    	
    	String prefix = ""; 
    	String ans = "";
    	
    	
    	loop:
    	for(int i = 1 ; i <= strs[sword].length();i++) {
    		prefix = word.substring(0, i);
    		
    		
    		for(int j = 0 ; j < strs.length;j++) {
    			if(!strs[j].equals(prefix)) {
    				break loop;
    			}
    			
    		}
    		System.out.println(ans);
    		ans = prefix;
    		
    		
    	}
    	
    	
    	
    	
    	return ans;
    }

}

//**************************************************************
//���� ���� Ǯ��
//public String longestCommonPrefix(String[] strs) {
//    if (strs.length == 0) return "";
//    String prefix = strs[0];
//    for (int i = 1; i < strs.length; i++)
//        while (strs[i].indexOf(prefix) != 0) {
//            prefix = prefix.substring(0, prefix.length() - 1);
//            if (prefix.isEmpty()) return "";
//        }        
//    return prefix;
//}

