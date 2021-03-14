package chapter05_1;

class Super{
	String name= "super";
	public String toString() {
		return "super name : " + name;
	}
}

class Sub extends Super{
	String name= "Sub";
	public String toString() {
		return "super name : " + super.name + " / Sub name : " + name;
	}
}
public class PolymorphismTest2 {

	public static void main(String[] args) {
		Super sup = new Super();
		System.out.println(sup.name);
		System.out.println(sup);
		
		Sub sub = new Sub();
		System.out.println(sub.name);
		System.out.println(sub);
	
		// 다형성 : 속성은 타입 따라 간다. 메서드는 virtual invocation된다.
		Super s = new Sub();
		System.out.println(s.name);
		System.out.println(s);
	
		
	}

}
