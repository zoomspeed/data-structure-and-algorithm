import java.util.Scanner;

public class Main {
	static long A = 0;
	static long B = 0;
	static long a = 0;
	static long b = 0;
	static long r = 0;

	public static void main(String[] args) {

		long lcm = 0;
		long gcd = 0;
		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		A = sc.nextInt();
		B = sc.nextInt();

		a = A;
		b = B;

		while (true) {

			if (a % b == 0) {

				break;
			}

			r = a % b;
			a = b;
			b = r;

		}

		lcm = b;

		gcd = (A / lcm) * (B / lcm) * lcm;

		System.out.println(gcd);
	}
}