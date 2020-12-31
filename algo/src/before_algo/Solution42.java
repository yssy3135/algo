package before_algo;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution42 {
	static String sign[];
	static long max;
	static long min;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int arr[] = {0,1,2,3,4,5,6,7,8,9};
		boolean visited[] = new boolean[10];
		int[] output = new int[10];
		
		max = 0;
		min = Long.valueOf("9999999999");
		
		int num = sc.nextInt();
		sign = new String[num];
		for(int i = 0; i < num;i++) {
			sign[i] = sc.next();
		}
		
		//������ ������ �ε�ȣ + 1 ���� ���;� �Ѵ�.
		
		combi(arr,visited,output,0,sign.length+1,10);
		
		String a = Long.toString(max);
		String b = Long.toString(min);
		
		System.out.println(a.length() < sign.length+1 ? "0"+a : a);
		System.out.println(b.length() < sign.length+1 ? "0"+b : b );
		
	}
	
	public static void combi(int arr[],boolean visited[],int output[],int depth,int r,int n) {
		if(depth == r) {
			if(!getnumber(output,sign,r).isEmpty()) {
				
				long num = Long.valueOf(getnumber(output,sign,r));
				max = Math.max(max, num);
				min = Math.min(min, num);
			}
			
			
			
			return ;
		}
		
		for(int i = 0; i < n ; i++) {
			if(!visited[i]) {	
				visited[i] = true;
				output[depth] = arr[i];
				combi(arr,visited,output,depth+1,r,n);
				visited[i] = false;
			}
			
		}
		
	}
	
	public static String getnumber(int output[],String[] sign,int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0 ; i < n ; i++) {
//			System.out.print(output[i]);
			list.add(output[i]);
		}
//		System.out.println();
		for(int i = 0 ; i < sign.length;i++) {
			if(sign[i].equals(">")) {
				if(list.get(i)<list.get(i+1)) {
					return "";
				}
			}else if(sign[i].equals("<")) {
				if(list.get(i)>list.get(i+1)) {
					return "";
				}
			}
		}
		
		StringBuilder sb= new StringBuilder();

		for(int i : list) {
			sb.append(Integer.toString(i));
		}
		
		
		
		return sb.toString();
	}
	
	
	
}
