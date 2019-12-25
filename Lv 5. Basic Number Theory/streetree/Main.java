import java.util.Scanner;

public class Main {
	static int N = 0;
	static int sum = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int arr[] = new int[N];
		int range = 0;
		int n = 0;
		int gcd = 0;
		for (int i = 0; i < arr.length; i++) {

			arr[i] = sc.nextInt();
		}

		range = arr[1] - arr[0];

		gcd = getGCD(range, arr[1] - arr[0]);

		for (int i = 1; i < arr.length; i++) {

			gcd = getGCD(gcd, arr[i] - arr[i - 1]);

		}

		System.out.println((arr[N - 1] - arr[0]) / gcd + 1 - N);

	}

	public static int getGCD(int a, int b) {

		int temp = 0;
		int r = 0;

		if (b > a) {
			temp = a;
			a = b;
			b = temp;
		}

		r = a % b;

		if (r == 0) {

			return b;
		} else {
			return getGCD(b, r);
		}

	}
}