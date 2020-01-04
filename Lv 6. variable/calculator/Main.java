import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		String cal = sc.next();
		int b = sc.nextInt();
		int result = 0;

		if (cal.equals("+")) {
			result = a + b;
		} else if (cal.equals("-")) {
			result = a - b;
		} else if (cal.equals("/")) {
			result = a / b;
		} else if (cal.equals("*")) {
			result = a * b;
		}

		System.out.println(result);
	}
}