import java.util.*;

public class Main {
	static int N;
	static final int RANGE = 100500;
	static int arr[] = new int[RANGE];
	static int start = 0;
	static int end = 0;
	static int answer = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {

			arr[i] = sc.nextInt();
		}

		answer = getSum(0, N - 1);

		System.out.println(answer);

	}

	static int getSum(int start, int end) {
		// 연속 부분 최대합의 start와 end 부분을 설정하여, 각각의 왼쪽,오른쪽,중간부터 자른 최대합을 비교한후
		// 분할정복법으로 합쳐 최대값을 계산함
		// nlogn의 시간복잡도를 가짐.

		// 기저조건 : start>=end == 최소1을 가리켜 더이상 합산할 필요없음

		if (start >= end) {
			return arr[start];
		}
		// 왼쪽, 오른쪽 최대합 구함.
		// s mid e
		// 1 2 3 4 5 -1 2 3 5 7 8

		int mid = (start + end) / 2;

		int left = getSum(start, mid);
		int right = getSum(mid + 1, end);

		int leftMax = -Integer.MAX_VALUE;
		int leftSum = 0;

		for (int i = mid; i >= start; i--) {

			leftSum = leftSum + arr[i];

			if (leftSum > leftMax) {
				leftMax = leftSum;
			}
		}

		int rightMax = -Integer.MAX_VALUE;
		int rightSum = 0;

		for (int i = mid + 1; i <= end; i++) {

			rightSum = rightSum + arr[i];

			if (rightSum > rightMax) {
				rightMax = rightSum;
			}
		}

		int midMax = leftMax + rightMax;

		if (left >= right && left >= midMax) {
			return left;
		} else if (right >= left && right >= midMax) {
			return right;
		} else {
			return midMax;
		}
	}
}