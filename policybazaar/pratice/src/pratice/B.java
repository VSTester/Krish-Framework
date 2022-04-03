package pratice;

public class B {

	public void n1() {
		System.out.println("I am n1 in B");
	}
	public void n2() {
		System.out.println("I am n2 in B");
	}	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
 class A1 extends B{
public void n1() {
	System.out.println("I am n1 of A");
}
public void x1() {
	System.out.println("I am x1 of A");
}
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
B b = new A1();
//b.n1();
b.n1();
		}	
}
