package solution94;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//백준 12865 평범한 배낭(dp)
public class Review {

    static class Item{
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }


    static Item item[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        item = new Item[n];
        int dp[] = new int[k+1];

        for(int i = 0 ; i < n ;i++){
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            item[i] = new Item(w,v);


        }


        for(int i = 0 ; i < n ;i++){

            for(int j = k ; j-item[i].weight >=0; j--){
                dp[j] = Math.max(dp[j],dp[j-item[i].weight]+item[i].value);
            }

        }

        System.out.println(dp[k]);


    }
}
