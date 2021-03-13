package solution155;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n[] = br.readLine().split("");
		int num[] = new int[10];

		int cnt = 0;
		
		for(int i = 0 ; i< n.length;i++) {
			int now = Integer.parseInt(n[i]);
			num[now]++;
		}
		
		int max = 0;
		for(int i = 0 ; i < num.length;i++) {
			if(i !=9 && i !=6 ) {
				max = Math.max(num[i], max);
			}
		}
	
		max = Math.max(max , (num[6]+num[9]+1)/2);
		
		System.out.println(max);
		
		
		
	}
}
