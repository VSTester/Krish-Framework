package pratice;

public class A {
int a =100;

public void m1(A a ) {
	System.out.println(a.a);
}
public void m2() {
	m1(this);
}
	public static void main(String[] args) {
//A a = new A();
//a.m2();
		
		String s1 = "vikas";
		String s2 = "vika";
		String s3 = new String("vikas");
		
		
	System.out.println(s1==s2);		
	}

}
