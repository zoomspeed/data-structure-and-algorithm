import java.util.Scanner;

public class Main {
	public static int f = 0;
	public static int N = 0;
	public static int arr[] = new int[46];

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		f = fibonacci(N);

		System.out.println(f);
	}

	public static int fibonacci(int n) {
		int v = 0;

		if (n <= 0) {
			return 0;
		}

		if (n == 1) {

			return 1;
		}

		if (arr[n] != 0) {
			return arr[n];
		} else {
			arr[n] = fibonacci(n - 1) + fibonacci(n - 2);
			return arr[n];
		}

	}
}