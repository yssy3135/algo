package solution100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Review {
	
	
	static long tree[];
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		tree = new long[n];
		cnt = 0;
		
		String tmp[] = br.readLine().split(" ");
		long arr[] = new long[n];
		for(int i = 0 ; i < tmp.length; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
		mergeSort(arr, 0, n-1);
		
	
		System.out.println(cnt);
	}
	
	public static void mergeSort(long[] arr,int m,int n) {
		
		// 이외의 경우는 1개인 경우
		if(m < n) {
			//왼쪽 오른쪽 나누고 merge
			int mid = (m+n)/2;
			mergeSort(arr,m,mid);
			mergeSort(arr,mid+1,n);
			merge(arr, m, mid, n);
		}
		
		
		
	}
	
	
	
	public static void merge(long arr[],int m,int mid,int n) {
		int i = m;
		int j = mid+1;
		int k = m;
		
		
		while(i <=mid && j <=n) {
			
			if(arr[i] < arr[j]) {
				tree[k] = arr[i];
				i++;
			}else {
				tree[k] = arr[j];
				j++;
				// (mid+1-i) 를 더하는 이유는 왼쪽 배열에 남아있는 숫자만큼 계속 swap이 발생하기 때문이다.
				cnt += (mid+1-i);
			}
			
			k++;
		}
		
		if(i > mid) {
			for(int t = j ; t <= n ; t++) {
				tree[k] = arr[t];
				k++;
			}
		}else {
			for(int t = i ; t <= mid ; t++) {
				tree[k] = arr[t];
				k++;
			}
		}
		
		for(int t = m; t <= n ; t++) {
			arr[t] = tree[t];
		}
		
		
		
		
	}
	
	
	
	
	
	
	
}
