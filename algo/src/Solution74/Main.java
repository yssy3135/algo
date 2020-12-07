package Solution74;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i = 0 ;i  < num; i++) {
			int size = sc.nextInt();
			int target = sc.nextInt();
			Queue<Integer> que = new LinkedList<Integer>();
			
			for(int j = 0 ; j < size; j++) {
				que.add(sc.nextInt());
			}
			
			
			turn(size,target,que);
		}
		
		
	}
	
	
	public static void turn(int size,int target,Queue<Integer> que) {
		int cnt = 0;
		int max = 0;
		int index = 0;
		
		while(true) {
			
			Iterator<Integer> iter = que.iterator();
			while(iter.hasNext()) {
				max = Math.max(max, iter.next());
			}
		
			if(que.peek() == max) {
				que.poll();
				cnt++;
				max = 0;
				if(target == 0) {
					System.out.println(cnt);
					return ; 
				}
				target--;
			}else {
				if(target == 0) {
					target = que.size()-1;
				}else {
					target--;
				}
				int tmp = que.poll();
				que.add(tmp);
				
			}
			
		}
		
		

	}
	
}
