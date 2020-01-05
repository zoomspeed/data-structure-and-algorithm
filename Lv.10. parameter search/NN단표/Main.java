import java.util.Scanner;

public class Main {
	static long N;
	static long K;
	static long answer;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		answer = Integer.MAX_VALUE;
		binarySearch(1, N * N);

		System.out.println(answer);
	}

	public static long check(long val) {

		long count = 0;

		for (long i = 1; i <= N; i++) {

			if (val / i >= N) {
				count = count + N;

			} else {
				// 1 2 3
				// 2 4 6
				// 3 6 9
				// 2/3 = 0
				// 2/2 = 1
				// 2/1 = 2

				// 5/1 = 5 ->3
				// 5/2 = 2
				// 5/3 = 1

				// 7/1 = 7 ->3
				// 7/2 = 3
				// 7/3 = 2

				count = count + val / i;
			}
		}

		return count;
	}

	public static void binarySearch(long s, long e) {

		long mid = 0;

		if (check(s) == K) {
			answer = check(s);
			return;
		}
		if (check(e) == K) {

			return;
		}

		// 1 2
		// 2 4

		// 1/1 = 1
		// 1/2 = 0

		// 2/1 = 2
		// 2/2 = 1

		// 1 2 3 4
		// s e
		// s e
		// x o

		// O X X X X X X X X
		// 1 2 3 4 5 6 7 8 9
		// 1
		// 2
		// 3
		// 4
		// 5
		// 2
		// 3
		// 4

		// O O O O O X X X X
		// 1 2 3 4 5 6 7 8 9
		// s m e
		//
		//

		while (s + 1 < e) {

			mid = (s + e) / 2;
			long result = check(mid);

			if (result >= K) {
				e = mid;
				if (answer > mid) {
					answer = mid;
				}

			} else {
				s = mid;
			}
		}
	}
}