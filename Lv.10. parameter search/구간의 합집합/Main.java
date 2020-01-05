import java.util.*;

public class Main {
	static long test = 0;
	static long N;
	static long s;
	static long K;
	static long arr[][];
	static long left[][];
	static long right[][];
	static long result = Long.MAX_VALUE;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);
		N = sc.nextLong();

		arr = new long[(int) N][2];

		for (int i = 0; i < N; i++) {

			// 1 4
			// 3 5

			// 1 2 3 4
			// 3 4 5

			// 1 2 3
			// 2 3 4 5 6 7 8 9 10
			// 1 2 3 4 5 6 7 8

			// 1 3 4 5 6 7 8 9 0

			// 1 3
			// 1 8
			// 2 10

			// 1 1 3 8
			// 앞자리 순으로 정렬하고....

			arr[i][0] = sc.nextLong();
			arr[i][1] = sc.nextLong();

		}

		K = sc.nextLong();

		binarySearch(1, 1000000000);
		System.out.println(result);
	}

	public static void binarySearch(long s, long e) {
		boolean answer = false;

		if (check(s)) {
			result = s;
		}

		long mid = 0;
		// x x o
		// s m e
		// s
		if (s > e) {
			return;
		}

		mid = (s + e) / 2;

		answer = check(mid);
		if (!answer) {
			binarySearch(mid + 1, e);

		} else {
			if (mid < result) {
				result = mid;
			}
			binarySearch(s, mid - 1);
		}

	}

	public static boolean check(long val) {
		test = 0;
		long answer = 0;
		for (long i = 0; i < N; i++) {

			if (val < arr[(int) i][0]) {
				continue;
			} else {
				if (val >= arr[(int) i][1]) {
					answer = answer + (arr[(int) i][1] - arr[(int) i][0]) + 1;

				} else {
					answer = answer + val - (arr[(int) i][0]) + 1;
				}

			}
			if (answer >= K + 1) {
				return true;
			}

		}
		return false;
	}

}