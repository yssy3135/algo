package algostudy09_BOJ_17352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Review {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		
		int bridge[] = new int[n+1];
		for(int i = 1;  i <=n ; i++) {
			bridge[i] = i;
		}
		
		for(int i = 0 ; i < n-2 ; i++) {
			String tmp[] = br.readLine().split(" ");
			//주어진 다리들을 연결
			union(bridge,Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]));
		}

		//set에 넣어서 중복 제거
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 1 ; i <=n ; i++) {
			set.add(getParent(bridge, bridge[i]));
		}
		
		for(int num :set) {
			System.out.print(num+" ");
		}
		
	}
	
	public static int getParent(int bridge[],int a) {
		if(a == bridge[a]) {
			return a;
		}else {
			return getParent(bridge,bridge[a]);
		}
	}
	
	public static void union(int bridge[],int a,int b) {
		a = getParent(bridge,a);
		b = getParent(bridge,b);
		
		if(a<b) {
			bridge[b] = a;
		}else {
			bridge[a] = b;
		}
		
	}
	
	
}
