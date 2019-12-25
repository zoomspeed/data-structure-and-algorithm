import java.util.Scanner;

public class Main {
	static int N = 1;
	static boolean arr[];
	static int count = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here

		// 에라토스테네스의 체

		Scanner sc = new Scanner(System.in);

		arr = new boolean[(123456 + 1) * 2];

		for (int i = 0; i < arr.length; i++) {

			arr[i] = true;
		}

		arr[0] = false;
		arr[1] = false;
		arr[2] = true;

		Eratos();

		while (true) {

			count = 0;

			N = sc.nextInt();

			if (N == 0) {
				return;
			}

			for (int i = N + 1; i <= 2 * N; i++) {

				if (arr[i] == true) {
					count++;
				}
			}

			System.out.println(count);
		}
	}

	public static void Eratos() {

		for (int i = 2; i <= (int) Math.sqrt(arr.length); i++) {

			for (int j = i + i; j < arr.length; j = j + i) {
				arr[j] = false;
			}

		}
	}

}