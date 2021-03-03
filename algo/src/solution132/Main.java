package solution132;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import jdk.nashorn.internal.runtime.FindProperty;

public class Main {
	static class node{
		int a;
		int b;
		int distance;
		public node(int a, int b, int distance) {
			super();
			this.a = a;
			this.b = b;
			this.distance = distance;
		}
		
		
	}
	
	static node[] info;
	static int num[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		info = new node[e];
		num = new int[v+1];
		for(int i = 0 ; i < e ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			info[i] = new node(a, b, c);
		}
		
		// 간선의 비용으로 오름차순 정렬
		Arrays.sort(info,new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				// TODO Auto-generated method stub
				return o1.distance-o2.distance;
			}
		});
		
		// 각 정점이 포함된 그래프가 어디인지 저장
		for(int i = 1 ; i <= v; i++) {
			num[i] = i;
		}
		
		int sum = 0;
		
		for(int i = 0 ; i < info.length;i++) {
			
			// 동일한 부모를 가르키지 않는 경우 즉 사이클이 발생하지 않은 경우에만 
			if(!find(info[i].a, info[i].b)) {
				sum += info[i].distance;
				union(info[i].a, info[i].b);
			}
			
		}
		
		System.out.println(sum);
	}
	
	static int getParent(int x) {
		if(num[x] == x) return x;
		
		return num[x] = getParent(num[x]);
		
	}
	
	static void union(int a,int b) {
		a = getParent(a);
		b = getParent(b);
		
		if(a<b) {
			num[b] =a;
		}else {
			num[a] =b;
		}
		
	}
	
	static boolean find(int a,int b) {
		a = getParent(a);
		b = getParent(b);
		if( a == b) { 
			return true;
		}else {
			return false;
		}
		
		
	}
	
	
	
}
