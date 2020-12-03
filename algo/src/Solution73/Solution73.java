package Solution73;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution73 {
	public static void main(String[] args) {
		
		String a[][] = {{"ICN", "A"},{"ICN","A"}, {"A","D"}, {"D","B"},{"B","A"}};
		
		
		solution(a);
	}
	
	
	
	
	static boolean visited[];
	static ArrayList<String> ans;
	static ArrayList<String> anss;
	static int duplicate;
    public static String[] solution(String[][] tickets) {
        String[] answer = {};


        visited = new boolean[tickets.length];
        ans = new ArrayList<String>();
        anss = new ArrayList<String>();
        ArrayList<String> contain = new ArrayList<String>();
        HashMap<String, String> map = new HashMap<String, String>();
        
  
        

        for(int i =0  ; i < tickets.length;i++) {

        	if(tickets[i][0].equals("ICN")) {

        
        		visited[i] = true;
        		ans.add(tickets[i][0]);
        		ans.add(tickets[i][1]);
        		dfs(tickets,i,0,tickets[i][1],1);
        		
        		
        		ans.clear();
        		Arrays.fill(visited, false);
        	}
        }
        
        anss.sort(null);
        String way = anss.get(0);
        way = way.substring(1, way.length()-1);
        way = way.replaceAll(" ", "");
        System.out.println(way);
        answer = way.split(",");
        
        
        return answer;
    }
    
    public static void dfs(String[][] tickets,int k ,int j ,String next,int cnt) {
    	System.out.println(cnt);

    	if(cnt == tickets.length-1) {
    		System.out.println(ans);
    		anss.add(ans.toString());
    		return ;
    	}
    	System.out.println(next);
    	boolean flag = false;
    	for(int i = 0; i < tickets.length;i++) {
    			if( tickets[i][0].equals(next) && !visited[i]) {
    				visited[i] = true;
    				flag = true;
    				ans.add(tickets[i][1]);
    				dfs(tickets,i,1,tickets[i][1],cnt+1);
    			}
    		
    	}
    	
    	if(!flag) {
    		visited[k] = false;
    		ans.remove(ans.size()-1);
    	}
    	
    	
    }
    
    
    
    
}
