package algostudy10_BOJ_15809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Review {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int country[][] = new int[n+1][2];
		for(int i = 1 ; i <= n ;i++) {
			country[i][0] = i;
			country[i][1] = Integer.parseInt(br.readLine());
		}
		
		// 1이면 동맹 2이면 전쟁
		for(int i = 0 ; i < m ; i++) {
			String order[] = br.readLine().split(" ");
			
			int option = Integer.parseInt(order[0]);
			int a = Integer.parseInt(order[1]);
			int b = Integer.parseInt(order[2]);
			
			if(option == 1) {
				union(country, a, b);
			}else {
				war(country, a, b);
			}
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 1 ; i < country.length;i++) {
			if(country[getParent(country, i)][0] == i                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    ) {
				set.add(i);
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int num:set) {
			list.add(country[num][1]);
		}
		
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}
		});
		
		System.out.println(list.size());
		
		
		for(int num : list) {
			System.out.print(num+" ");
		}

	}
	
	public static int getParent(int country[][],int a) {
		if(country[a][0] == a) {
			return a;
		}else {
			return getParent(country,country[a][0]);
		}
	}
	
	public static void union(int country[][],int a,int b) {
		a = getParent(country, a);
		b = getParent(country, b);
		
		
		if(a<b) {
			country[b][0] = a;
			country[a][1] +=country[b][1];
			country[b][1] = country[a][1];
			
		}else {
			country[a][0] = b;
			country[b][1] +=country[a][1];
			country[a][1] = country[b][1];
		
		}

	}
	public static void war(int country[][],int a,int b) {
		a = getParent(country, a);
		b = getParent(country, b);
		
		if(a !=b) {
			
			if(country[a][1] <country[b][1]) {
				country[a][0] =b;
				country[b][1] -= country[a][1];
			}else if(country[a][1] >country[b][1]){
				country[b][0] = a;
				country[a][1] -= country[b][1];
			}else {
				country[a][0] =0;
				country[b][0] =0;
			}
		}
	}
	
	
}
