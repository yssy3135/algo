package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

abstract class Vehicle{ // 추상 클래스 기능의 이름들만 명시 반드시 상속해야 사용가능
	String name;
	abstract public String getName(String val); // 추상 메소드
	public String getName() {
		return "vehicle name :"+name;
	}
}

class Car extends Vehicle{	 // Car는 Vehicle의 기능의 이름을 상속받아 기능을 추가하여 사용 
	
	public Car(String val) { // Car String val 라는 매개변수를 가진 생성자.
		name = super.name = val;
	}
	
	public String getName(String val) { //Vehicle의  추상 메소드 getName를 상속받아 기능을 추가해 사용하는 메소드 매개변수로 String 형식이 들어와야 사용가능
	
		return "Carname:"+ val;
	}
	
	public String getName(byte val[]) { //getName이름의 메소드  매개변수로 byte[] 형식이 들어와야 사용가능 
		return "Car name :"+val;
		
	}
	
}


public class Main {
	
	
	public static void main(String[] args) {
		Vehicle obj = new Car("spark"); // 추상클래스 Vehicle형식으로 이름이 obj인  CAR(Car는 Vehicle의 자식이라 생성가능) 생성
		// new Car("spark"); 는  Car 의 Car String val 라는 매개변수를 가진 생성자 호출하여 val 같에 spark 가 저장됨
		// name = super.name = val     val 변수의값 "spark"를  super.name -> 부모 클래스 Vehicle의 name 에 "spark" 저장   자신의 name 에도 저장 
		
		System.out.println(obj.getName());
		
		//  obj.getName() -> getName() 괄호안에 아무것도 안들어갔으니  Vehicle의 getname 호출 -> super.name 이용하여 부모클래스name에 "spark" 가 저장되었으니  "vehicle name : spark" 출력
		
	}
	
   
	
	
	
	
	
}
