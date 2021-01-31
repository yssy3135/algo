package solution96;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main {
	
	
	
	
	public static void main(String[] args) throws  IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			int num = Integer.parseInt(br.readLine());

			boolean flag = false;
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
			for(int j = 0 ; j < num; j++) {
				String tmp[] = br.readLine().split(" ");
				if(flag) continue;
			
				if(tmp[0].equals("I")) {
					if(map.containsKey(Integer.parseInt(tmp[1]))) {
						
						map.put(Integer.parseInt(tmp[1]), map.get(Integer.parseInt(tmp[1])+1));
					}else {
						map.put(Integer.parseInt(tmp[1]),1);
					}
					
				}else {
					
					if(map.isEmpty()) continue;
					
					if(Integer.parseInt(tmp[1]) == -1) {
						int min = map.firstKey();
						if(map.get(min) ==  1) {
							map.remove(min);
						}else {
							map.put(min, map.get(min)-1);
						}
						
						
					}else if(Integer.parseInt(tmp[1]) == 1) {
						int max = map.lastKey();
						if(map.get(max) ==  1) {
							map.remove(max);
						}else {
							map.put(max, map.get(max)-1);
						}
					}
				}
				
				
			}
			if(map.isEmpty()) {
				System.out.println("EMPTY");
			}else {
				System.out.println(map.lastKey()+" "+map.firstKey());
			}
		
		}

		
	}
	
	
	
}
