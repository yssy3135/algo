package solution243;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {


    }

    static class Card{
        int r;
        int c;
        int cnt;

        public Card(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }


    static int map[][];


    static int a[] = {0,0,1,-1};
    static int b[] = {1,-1,0,0};

    public int solution(int[][] board, int r, int c) {
        map = board;

        return permunitate(new Card(r,c,0));
    }

    public int permunitate(Card card){
        int ret = Integer.MAX_VALUE;

        //1번부터 6번까지의 카드
        for(int i = 1; i <=6;i++){
            //i가 카드의 번호 카드를 찾는다.
            ArrayList<Card> cardList = new ArrayList<>();
            for(int j = 0; j < 4;j++){
                for(int k = 0 ; k < 4;k++){
                    if(map[j][k] == i){
                        cardList.add(new Card(j,k,0));
                    }
                }
            }

            if(cardList.isEmpty()) continue;

            int a = bfs(card,cardList.get(0))+ bfs(cardList.get(0), cardList.get(1))+2;
            int b = bfs(card,cardList.get(1))+ bfs(cardList.get(1),cardList.get(0))+2;

            //카드를 뒤집었으니 지운다.
            for(int j = 0 ; j < 2;j++){
                map[cardList.get(j).r][cardList.get(j).c] = 0;
            }
            ret = Math.min(ret,a+permunitate(cardList.get(1)));
            ret = Math.min(ret,b+permunitate(cardList.get(0)));

            //카드를 지운것을 복구.
            for(int j = 0 ; j < 2;j++){
                map[cardList.get(j).r][cardList.get(j).c] = i;
            }

        }

        if(ret == Integer.MAX_VALUE) return 0;

        return ret;
    }

    public static int bfs(Card cur,Card next){
        boolean visited[][] = new boolean[4][4];

        Queue<Card> que = new LinkedList<>();
        que.add(cur);

        while(!que.isEmpty()){
            Card card = que.poll();

            if(card.r == next.r && card.c == next.c){
                return card.cnt;
            }

            for(int i = 0 ; i < 4;i++){
                int mr = card.r+a[i];
                int mc = card.c+b[i];

                if(mr < 0 || mc <0 || mr >3 || mc >3)continue;

                if(!visited[mr][mc]){
                    visited[mr][mc] = true;
                    que.add(new Card(mr,mc,card.cnt+1));
                }

                //컨트롤 키를 누르는 경우 2번까지 더 이동할 수 있다.
                for(int j = 0 ; j < 2; j++){
                    //이동하는것이 그림카드라면 이동할 수 없다.
                    if(map[mr][mc] != 0) break;
                    if(mr +a[i] <0 || mc + b[i] < 0 || mr+a[i] >3 || mc+b[i] >3)break;

                    // 이동할 수 있는경우 진행방향으로 한칸더
                    mr +=a[i];
                    mc +=b[i];
                }

                if(!visited[mr][mc]){
                    visited[mr][mc] = true;
                    que.add(new Card(mr,mc,card.cnt+1));
                }



            }


        }

        return Integer.MAX_VALUE;
    }




}
