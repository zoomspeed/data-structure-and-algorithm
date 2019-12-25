import java.util.Scanner;

public class Main {
	static int start;
	static int end;
	static int N;
	static int sum = 0;
	static boolean check;
	static int speed = 0;
	static int count = 0;

	// static int nextSpeed = 0;
	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		start = sc.nextInt();
		end = sc.nextInt();
		N = end - start;

		speed = 0;

		for (; sum < N;) {

			check = check(speed + 1, N - sum);

			if (check) {
				sum = sum + speed;
				speed++;
			} else if (check(speed, N - sum)) {
				sum = sum + speed;
			} else {

				speed--;
				sum = sum + speed;

			}

			count++;
		}

		System.out.println(--count);

	}

	public static boolean check(int N, int length) {

		int total = 0;

		for (int i = N; i >= 1; i--) {

			total = total + i;

		}

		if (total <= length) {
			return true;
		}
		return false;
	}
}