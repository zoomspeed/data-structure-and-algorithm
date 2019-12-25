import java.util.Scanner;

public class Main {
	static int N[] = new int[2];
	static int M[] = new int[2];
	static int numerator;
	static int denominator;
	static int GCD = 1;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		N[0] = sc.nextInt();
		N[1] = sc.nextInt();

		M[0] = sc.nextInt();
		M[1] = sc.nextInt();

		numerator = N[1] * M[0] + N[0] * M[1];
		denominator = N[1] * M[1];

		GCD = getGCD(denominator, numerator);

		numerator = (N[1] * M[0] / GCD) + (N[0] * M[1] / GCD);
		denominator = denominator / GCD;

		System.out.println(numerator + " " + denominator);
	}

	static int getGCD(int a, int b) {

		int answer = 1;
		int r = 0;
		int temp = 0;

		if (b > a) {
			temp = a;
			a = b;
			b = temp;
		}

		r = a % b;
		if (r == 0) {
			answer = b;
		} else {
			answer = getGCD(b, r);
		}

		return answer;
	}
}