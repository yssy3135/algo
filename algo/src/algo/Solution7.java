package algo;

class Solution7 {
    public int solution(int n, int[][] computers) {
    	int answer = 0;
        
    	
    	boolean[] visited = new boolean[computers.length];
    	
    	for(int i = 0 ; i < computers.length;i++) {
    		visited[i] = false;
    	}
    	
    	for(int i = 0  ; i < computers.length; i ++) {
    		if(visited[i] == false) {
    			
    			answer++;
    			dfs(i,visited,computers);
    		}
    		
    	}
        return answer;
    }
    

    static void dfs(int n, boolean[] visited,int[][] computers){
    	visited[n] = true;
    	for(int i = 0 ; i < computers.length;i++) {
    		if(visited[i]==false && computers[n][i] ==1) {
    			dfs(i,visited,computers);
    		}
    	}
    	
    }
    
  
    
    
}
