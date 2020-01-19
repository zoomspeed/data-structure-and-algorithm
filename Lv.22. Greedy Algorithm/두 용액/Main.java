import java.util.*;

public class Main {
	static final int MAX = 100050;
	static int N = 0;
	static Integer arr[] = new Integer[MAX];
	static int answer = Integer.MAX_VALUE;
	static int ans[] = new int[2];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {

			int num = sc.nextInt();
			arr[i] = num;
		}
		Arrays.sort(arr, 0, N, Comparator.comparingInt(Math::abs));
		for (int i = 0; i < N; i++) {

			int pointer = arr[i];
			int leftMin = Integer.MAX_VALUE;
			int rightMin = Integer.MAX_VALUE;
			int left = 0;
			int right = 0;
			if (i != 0) {

				int j = i - 1;
				leftMin = Integer.MAX_VALUE;
				while (true) {

					if (Math.abs(leftMin) > Math.abs(arr[i] + arr[j])) {

						leftMin = arr[i] + arr[j];
						left = arr[j];
					}

					if (Math.abs(leftMin) <= Math.abs(arr[i]) || j == 0) {
						break;
					}
					j--;
				}
			}

			if (i <= N - 2) {

				int j = i + 1;
				rightMin = Integer.MAX_VALUE;
				while (true) {

					if (Math.abs(rightMin) > Math.abs(arr[i] + arr[j])) {

						rightMin = arr[i] + arr[j];
						right = arr[j];
					}

					if (Math.abs(rightMin) <= Math.abs(arr[i]) || j >= N - 1) {

						break;
					}
					j++;
				}
			}

			if (answer > Math.abs(rightMin)) {

				answer = rightMin;
				ans[0] = arr[i];
				ans[1] = right;
			} else if (Math.abs(answer) == Math.abs(rightMin)) {

				if (answer > rightMin) {

					answer = rightMin;
					ans[0] = arr[i];
					ans[1] = right;
				}

				else if ((right < ans[0] && right < ans[1]) || (arr[i] < ans[0] && arr[i] < arr[1])) {

					ans[0] = arr[i];
					ans[1] = right;
				}
			}

			if (Math.abs(answer) > Math.abs(leftMin)) {

				answer = leftMin;
				ans[0] = arr[i];
				ans[1] = left;
			} else if (Math.abs(answer) == Math.abs(leftMin)) {

				if (answer > leftMin) {

					answer = leftMin;
					ans[0] = arr[i];
					ans[1] = left;
				} else if ((left < ans[0] && left < ans[1]) || (arr[i] < ans[0] && arr[i] < arr[1])) {

					ans[0] = arr[i];
					ans[1] = left;
				}
			}
		}

		Arrays.sort(ans);
		System.out.println(ans[0] + " " + ans[1]);

	}
}