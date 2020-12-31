package Solution85;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public static void main(String[] args) {
		int b[][] = {{0, 1, 1}, {3, 1, 1}, {0, 2, 2}, {0, 3, 2}, {0, 4, 100}};
		solution(b.length,b);
		
	}
	
	
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        //크루스칼 알고리즘
        
        
        //거리에 드는 비용이 적은 순으로 정렬
        Arrays.sort(costs,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2]-o2[2];
			}
		});
        
        int node[] = new int[n];
        //순환 노드 확인 노드의 개수는 n-1개 이어야 한다.
        for(int i = 0 ; i< n; i++ ) {
        	node[i] = i;
        }
        
        int cnt = 0;
        for(int i = 0 ; i < costs.length;i++) {
        	
        	if(!find(node,costs[i][0],costs[i][1])) {
        		cnt +=costs[i][2];
        		union(node, costs[i][0], costs[i][1]);
        	}
        	
        }
        
        System.out.println(cnt);
       
        return cnt;
    }
        
    
    // 부모가 같은지 확인
    public static boolean find(int node[],int a,int b) {
    	a = getParent(node, a);
    	b = getParent(node, b);
    	
    	if(a == b ) return true;
    	else return false ;
    	
    }
    
    // 부모 가져오기
    public static int getParent(int node[],int x) {
    	if(node[x] == x) return x;
    	return node[x] = getParent(node, node[x]);
    	
    }
    
    //병합
    public static void union(int node[],int a, int b) {
    	a = getParent(node, a);
    	b = getParent(node, b);
    	
    	if(a < b ) node[b] = a;
    	else node[a] = b;
    }
    
    
    
    
}