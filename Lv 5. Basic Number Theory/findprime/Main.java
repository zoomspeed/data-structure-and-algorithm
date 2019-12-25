import java.util.Scanner;

public class Main {
	static int N = 0;
	static boolean primenumber = false;

	public static void main(String[] args) {
		int count = 0;
		int arr[] = new int[N];
		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		arr = new int[N];

		for (int i = 0; i < N; i++) {

			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			primenumber = true;

			if (arr[i] == 1) {
				continue;
			}

			for (int j = 2; j < arr[i]; j++) {

				if (arr[i] % j == 0) {
					primenumber = false;
					break;
				}

			}

			if (primenumber) {
				count++;
			}
		}

		System.out.println(count);

	}
}