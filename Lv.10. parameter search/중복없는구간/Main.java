import java.util.*;

public class Main {
	static int N;
	static int r;
	static boolean dup = true;
	static int k = 0;
	static final int MAX = 100000;
	static int arr[];
	static int answer = 0;
	static int temp[];
	static int testIndex = 0;
	static int output = 0;
	static int count = 0;
	static boolean isSame = true;

	static boolean isTrue = false;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		arr = new int[N];

		for (int i = 0; i < arr.length; i++) {

			arr[i] = sc.nextInt();
		}

		binarySearch1(1, arr.length);
		System.out.println(answer);
	}

	public static void binarySearch1(int start, int end) {

		int mid = 0;

		if (start > end) {
			return;
		}

		if (check(end)) {

			answer = end;
			return;
		}

		mid = (start + end) / 2;

		if (check(mid)) {
			if (mid > answer) {
				answer = mid;
			}
			binarySearch1(mid + 1, end);
		} else {
			binarySearch1(start, mid - 1);
		}

	}

	public static boolean check(int val) {

		boolean pass = true;
		int count = 0;
		if (val == 1) {
			return true;
		}
		int length = 0;
		temp = new int[MAX];

		int rank[] = new int[MAX + 10];
		int index = 0;
		int i = 0;
		while (i < arr.length) {

			count++;

			if (rank[arr[i]] < 1) {

				length++;
			}
			rank[arr[i]]++;

			if (count >= val) {

				if (length >= val) {
					return true;
				}

				for (int j = 0; j < val - length; j++) {

					rank[arr[index]]--;
					if (rank[arr[index]] <= 0) {
						length--;
					}

					index++;
				}

				i++;
				count = count - (val - length);
			} else {
				i++;
			}
		}
		return false;
	}

}