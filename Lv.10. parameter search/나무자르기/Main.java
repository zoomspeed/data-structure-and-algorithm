import java.util.*;

public class Main {
	static int N;
	static int M;
	static int arr[];
	static int answer = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];

		for (int i = 0; i < arr.length; i++) {

			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		answer = binarySearch(0, arr[arr.length - 1]);

		System.out.println(answer);

	}

	public static boolean check(int val) {

		// 20 15 10 17

		// arr[i] -val 의 합이 >= m보다 크거나 같아야 한다.

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] - val > 0) {
				sum = sum + arr[i] - val;
			}

			if (sum >= M) {
				return true;
			}
		}

		return false;
	}

	public static int binarySearch(int start, int end) {

		int mid = 0;
		// 1~N

		if (check(arr[arr.length - 1])) {

			return arr.length - 1;
		}

		if (!check(1)) {

			return -1;
		}

		while (start + 1 < end) {

			mid = (start + end) / 2;

			if (check(mid)) {

				start = mid;
			} else {
				end = mid;
			}
		}

		if (!check(mid)) {

			mid--;
		} else {
		}

		return mid;
	}

}