package solution94;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static class Item{
		int weight;
		int value;
		
		public Item(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Item item[] = new Item[n];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			item[i] = new Item(w, v);
		}
		
		combi(4,0,new int[5],1);
		
		
	}
	public static void combi(int n,int cnt,int arr[],int start) {
		if (cnt == n) {
			System.out.println(Arrays.toString(arr));
		}
		
		for(int i = 0 ;i <=4 ; i++) {
			arr[i] = i;
			combi(n,cnt+1,arr,i+1);
			
		}
		
		
	}
	
	
	
}
