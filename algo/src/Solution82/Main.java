package Solution82;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int n = sc.nextInt();
		
		
		int pd[][] = new int[n][2];
		for(int i = 0 ; i < n ; i++) {
			pd[i][0] = sc.nextInt();
			pd[i][1] = sc.nextInt();
		}
		
		Arrays.sort(pd,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				int result = o2[1]-o1[1] == 0 ? o2[0]>o1[0]?1:-1 : o1[1]-o2[1];
				return result ;
			}
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i = 0 ; i< n ; i++) {
			int d = pd[i][1];
			
			pq.add(pd[i][0]);
			while(d < pq.size()) {
				pq.remove();
			}
			
			
		}
		int ans = 0;
		while(!pq.isEmpty()) {
			ans+=pq.poll();
		}
	
		System.out.println(ans);
		
		
	}
}
