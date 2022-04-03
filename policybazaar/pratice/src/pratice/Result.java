package pratice;

public class Result {

	public static void fizzBuzz(int n) {
		// Write your code here
		for (int i = 0; i <= n; i++) {
			if (i % 3 == 0&&i%5!=0 && i!=0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0 && i%3!=0&& i!=0)
				System.out.println("Buzz");

			else if (i % 3 == 0 && i % 5 == 0 && i!=0)
				System.out.println("Fizz BUzz");
			else
				System.out.println(i);

		}
	}

}