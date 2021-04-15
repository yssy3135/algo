package solution207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
		
	
	public static void main(String[] args) {
		
		int edges[][] = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};

		findTheCity(4,edges,4);
	}
	
        static int arr[][];
	    static int INF  = 1000000000;
	    public static  int findTheCity(int n, int[][] edges, int distanceThreshold) {
	    	arr = new int[n][n];
	    	
	    	for(int i = 0 ; i< n ;i++) {
	    		for(int j = 0 ; j < n;j++) {
                    if(i == j ){
                        arr[i][j] = 0 ;
                    }else{
                        arr[i][j] = INF;
                    }
	    			
	    		}
	    	}
	    	
	    	
	    	for(int i = 0 ; i < edges.length;i++) {
	    		int a  = edges[i][0];
	    		int b  = edges[i][1];
	    		int c = edges[i][2];
	    		
	    		arr[a][b] =	 Math.min(arr[a][b],c);
	    		arr[b][a] =	 Math.min(arr[b][a],c);
	    		
	    	}
	    	floyd(n);
	    	
	    	for(int a[] : arr) {
	    		System.out.println(Arrays.toString(a));
	    	}
	    	
	    	
	    	int min = Integer.MAX_VALUE;
	    	int idx = 0;
	    	for(int i = 0 ; i< n ;i++) {
	    		int cnt = 0 ;
	    		for(int j = 0 ; j < n;j++) {
	    			if( i== j )continue;
                    if(arr[i][j] <= distanceThreshold ) { 
                    	cnt++;
                    	
                    }
	    			
	    		}
	    		System.out.println(cnt);
	    		if( min >= cnt) {
	    			
	    			idx  = i ;
	    			min = cnt;
	    		}
	    		
	    	}
	    	
	    	System.out.println(idx);
			return min;
	        
	    }
        
    public static void floyd(int n) {
		for(int i = 0 ; i < n ;i++) {
			for(int j = 0 ; j < n; j++) {
				for(int k =0 ; k < n ;k++) {
					if(arr[j][i] == INF || arr[i][k] == INF) {
						continue;
					}
					arr[j][k] = Math.min(arr[j][k],  arr[j][i] + arr[i][k]);
					
				}
			}
		}
	}
}
	

	

	
	

