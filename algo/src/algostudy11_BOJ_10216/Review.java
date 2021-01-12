package algostudy11_BOJ_10216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Review {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		
		
		for(int i = 0 ; i < n ; i++) {
			
			int t = Integer.parseInt(br.readLine());
			
			int node[] = new int[t+1];			
			int map[][]= new int[t][3];
			for(int z = 0 ; z<t ; z++	) {
				node[z] =z;
				StringTokenizer st = new StringTokenizer(br.readLine());
				map[z][0] = Integer.parseInt(st.nextToken());
				map[z][1] = Integer.parseInt(st.nextToken());
				map[z][2] = Integer.parseInt(st.nextToken());
				
			}
				int ans = t;
				
				for(int j = 0 ; j < t ; j++) {
					for(int k = j+1; k < t; k++) {
						if(Math.sqrt( Math.pow(map[k][0]-map[j][0],2)+Math.pow(map[k][1]-map[j][1],2) ) <= map[j][2]+map[k][2]) {
							if(getParent(node,j) != getParent(node,k)) {
								union(node,j,k);

								ans--;
							}
							
						}
						
					}
				}
				System.out.println(ans);
		}
		
		
		
		
	}
	
	public static int getParent(int node[],int num) {
		if(node[num]==num) {
			return num;
		}else {
			return getParent(node,node[num]);
		}
	}
	
	public static void union(int node[],int a,int b) {
		a = getParent(node,a);
		b = getParent(node,b);
		
		
		if(a<b) {
			node[b] =a;
		}else {
			node[a] =b;
		}
		
		
		
	}
	
	
}
