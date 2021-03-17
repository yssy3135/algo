package solution166;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String list[][] = new String[n][m];
		for(int i = 0 ; i < n ;i++) {
			list[i] = br.readLine().split("");
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < m; i++) {
			TreeMap<String, Integer> map = new TreeMap<String, Integer>();
			for(int j = 0; j < n; j++) {
				if(map.containsKey(list[j][i])) {
					map.put(list[j][i],map.get(list[j][i])+1);
				}else {
					map.put(list[j][i], 1);
				}
			}
			ArrayList<Entry<String,  Integer>> col = new ArrayList<Entry<String,Integer>>(map.entrySet());
			col.sort(new Comparator<Entry<String, Integer>>() {

				@Override
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					// TODO Auto-generated method stub
					if(o2.getValue()==o1.getValue()) {
						return o1.getKey().charAt(0)-o2.getKey().charAt(0);
					}
					
					
					return o2.getValue()-o1.getValue();
				}
			});
			sb.append(col.get(0).getKey());
		}
		
		String ans = sb.toString();
		int sum = 0;
		for(int i = 0 ; i < m;i++) {
			char word = ans.charAt(i);
			for(int j = 0 ; j < n ;j++) {
				if(list[j][i].charAt(0) != word) {
					sum +=1;
				}
			}
		}
		System.out.println(ans);
		System.out.println(sum);
		
		
		
	}
}
