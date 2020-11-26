package NHN;

import java.util.HashMap;

public class test {
	public static void main(String[] args) {
		char a = 65;
		System.out.println(a);
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		map.put('A', 1);
		map.put('A', 2);
		
		map.put('A', map.get('A')+1);
		System.out.println(map.get('A'));
	}
}

E
F
L
A
F
G
J
H
B 0
C 0
D 0
L 1
E 2
F 2
J 2
I 0
G 1
K 0
A 2
M 0
N 0
O 0
P 0
Q 0
H 2
