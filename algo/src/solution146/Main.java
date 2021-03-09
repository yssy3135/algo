package solution146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
	static class Node{
		int a;
		int b;
		int dis;
		
		public Node(int a, int b, int dis) {
			super();
			this.a = a;
			this.b = b;
			this.dis = dis;
		}

	}
	

	static int num[];

	static Node info[];
	static int factory[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
	
		
		num = new int[n+1];
	
		for(int i = 1 ; i<=n;i++) {
			num[i] = i;
		}
		
		info = new Node[m];
	
		
		String tmp[] = br.readLine().split(" ");
		for(int i = 0 ; i < k ;i++) {
			num[Integer.parseInt(tmp[i])] = -1;
		}
		
		
		for(int i = 0 ; i < m ;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			info[i] = new Node(a, b, dis);
		}
		
		Arrays.sort(info,new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(o1.dis>o2.dis) {
					return 1;
				}else if(o2.dis>o1.dis) {
					return -1;
				}else {
					return 1;
				}
			}
		});
		
		int sum = 0;
		int cnt = 0;
		for(int i = 0 ; i < info.length;i++) {
			Node way = info[i];
			
			if(!find(way.a, way.b)) {

				union(way.a,way.b);
				sum += way.dis;
				
				
				if(connect()) {
					break;
				}

			}
			
		}
		
		

		System.out.println(sum);

		
	}
	
	
	public static boolean connect() {
		
		for(int i = 0 ; i < num.length;i++) {
			if(num[i] != -1) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public static int getParent(int x) {
		
		if(num[x] == -1) {
			return -1;
		}
		
		if(num[x] == x) {
			return x;
		}
		
		return  getParent(num[x]);
	}
	
	
	public static void union(int a,int b) {
		a = getParent(a);
		b = getParent(b);
		
		
		if(a != b) {
			if( a == -1) {
				num[b] = a;
			}else if (b == -1) {
				num[a] = b;
			}else {
				if(num[a] <num[b]) {
					num[b] = a;
				}else {
					
					num[a] = b;
				}
				
			}
			
			
		}

		
	}
	
	
	
	public static boolean find(int a,int b) {
		a = getParent(a);
		b = getParent(b);
		

			
		if(a == b) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	
}
