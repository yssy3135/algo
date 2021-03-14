package solution156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		long avg = 0;
		
		
		
		
		for(int i = 0 ; i < n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			avg = avg+arr[i];
			map.put(arr[i], map.containsKey(arr[i])?map.get(arr[i])+1 :1  );
		}
		ArrayList<Entry<Integer, Integer> > list = new ArrayList<Entry<Integer,Integer> >(map.entrySet()); 
		
		
		Collections.sort(list,new Comparator<Entry<Integer, Integer> >() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		int min = Integer.MAX_VALUE;
		min = list.get(0).getValue();
		ArrayList<Integer> minvalue = new ArrayList<Integer>();
		
		for(Entry<Integer, Integer> m : map.entrySet()) {
			if(m.getValue() == min) {
				minvalue.add(m.getKey());
			}
		}
	
		int num = 0 ;
		minvalue.sort(null);
		if(minvalue.size() >1) {
			num = minvalue.get(1);
		}else {
			num = minvalue.get(0);
		}
		
		
		avg = Math.round(avg/n);
		Arrays.parallelSort(arr);
		
		System.out.println((int)avg);
		System.out.println(arr[n/2]);
		System.out.println(num);
		System.out.println(arr[n-1]-arr[0]);
		
		
		
	}
}
