package NHN;

import java.util.HashMap;
import java.util.Map;

public class solution {
	public static void main(String[] args) {
		
	}
	
	  static char name[] ;
	  static char seat[] ;

	  private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
		    // TODO: �̰��� �ڵ带 �ۼ��ϼ���. �߰��� �ʿ��� �Լ��� ���������� �����ؼ� ����ϼŵ� �˴ϴ�.
		  	
		  
		 name = new char[numOfAllPlayers];
		 seat = new char[numOfAllPlayers-1];
		 
		 HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		 
		
		 
		 
		 char sul = name[0];
		 
		  for(int i = 0 ; i< numOfAllPlayers; i++) {
			  name[i] = (char) (i+65);
			  if( i != 0 ) {
				  seat[i-1] = name[i];
				  System.out.println(seat[i]);
			  }
			  map.put(name[i], 0);
		  }
		  map.put('A', 1);
		  
		  // ���� Ƚ��
		  int move = 0;
		  
		  for(int i = 0 ; i < numOfGames; i++) {
			  // �ݽð� ó��
			  move = move+numOfMovesPerGame[i];
			  while(move + numOfMovesPerGame[i]< 0 || move + numOfMovesPerGame[i] > seat.length-1) {
				  
				  if(move < 0) {
					  move = seat.length-numOfMovesPerGame[i];
				  }else if(move  > seat.length-1) {
					  move = move-(seat.length);
				  }
				  
			  }
			  
			  
			  System.out.println("move" + move);
			  boolean flag = false;
			  for(int j = 0 ; j < namesOfQuickPlayers.length; j++) {
				  
				  
				  if(seat[move] == namesOfQuickPlayers[j]) {
					  flag = true;
					  continue;
					  
				  }
				  
			  }
			  
			  if(!flag) {
				  char tmp = sul;
				  sul = seat[move];
				  seat[move] = tmp;
				  
				  System.out.println(sul);
				  map.put(sul, map.get(sul)+1);
			  }else {
				  map.put(sul, map.get(sul)+1);
			  }
			  
			  
			  
		  }
		  
		  for(int i = 0; i < seat.length;i++) {
			  System.out.println(seat[i] +" "+map.get(seat[i]));
		  }
		  
		  System.out.println(sul + " "+ map.get(sul));

	  }
  

}
