import java.util.*;

public class Main {
	static int N;
	static final int range = 100500;
	static int arr[][] = new int[range][5];
	static int MAX[][] = new int[range][5];

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		/*
		 * 
		 * 버튼누르기 이전다음 문제 철수에게는 빨간색, 초록색, 파란색 세 개의 버튼이 있다. 버튼 하나를 누를 때 마다 특정 점수를
		 * 얻을 수 있으며, 철수는 1초에 한 번씩 버튼을 누를 수 있다. 물론, 특정 시간에는 세 개의 버튼 중에서 한 개의 버튼만을
		 * 누를 수 있다. 각 시간마다 특정 버튼을 눌렀을 때 얻는 점수는 모두 다를 수 있다. 예를 들어, 시간 1에 빨간색,
		 * 초록색, 파란색 버튼에 대한 점수가 3, 5, 7 로 주어질 수 있다. 이 경우에는 파란색을 누르는 것이 점수를 가장 많이
		 * 얻을 수 있다. 물론, 시간 2에 각 버튼에 대한 점수는 또 다를 수 있다. 버튼을 누를 때에는 한 가지 규칙이 있는데,
		 * 연속하여 색깔이 같은 버튼을 두 번 누를 수 없다는 것이다. 예를 들어, 시간 1에 초록색 버튼을 눌렀다면, 시간 2에는
		 * 초록색 버튼을 누를 수 없다. 이와 같은 규칙으로 각 시간마다 버튼을 누른다고 할 때, 철수가 얻을 수 있는 점수의 최댓값을
		 * 출력하는 프로그램을 작성하시오.
		 * 
		 * 
		 * 
		 * 입력 첫 번째 줄에 철수에게 주어진 시간 N이 주어진다. ( 1 ≤ N ≤ 100,000 ) 두 번째 줄부터 N개의 시간에
		 * 대하여 빨간색, 초록색, 파란색 버튼을 눌렀을 때 얻을 수 있는 점수가 주어진다.
		 * 
		 * 
		 * 
		 * 출력 철수가 얻을 수 있는 점수의 최댓값을 출력한다.
		 * 
		 * 
		 * 
		 * 예제 입력 3 27 8 28 18 36 40 7 20 8 예제 출력 87
		 * 
		 */
		for (int i = 0; i < N; i++) {

			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();

		}
		MAX[0][0] = arr[0][0];
		MAX[0][1] = arr[0][1];
		MAX[0][2] = arr[0][2];

		for (int i = 1; i < N; i++) {

			if (MAX[i - 1][1] >= MAX[i - 1][2]) {

				MAX[i][0] = MAX[i - 1][1] + arr[i][0];
			} else {
				MAX[i][0] = MAX[i - 1][2] + arr[i][0];
			}

			if (MAX[i - 1][0] >= MAX[i - 1][2]) {

				MAX[i][1] = MAX[i - 1][0] + arr[i][1];
			} else {
				MAX[i][1] = MAX[i - 1][2] + arr[i][1];
			}

			if (MAX[i - 1][1] >= MAX[i - 1][0]) {

				MAX[i][2] = MAX[i - 1][1] + arr[i][2];
			} else {
				MAX[i][2] = MAX[i - 1][0] + arr[i][2];
			}

		}

		if (MAX[N - 1][0] >= MAX[N - 1][1] && MAX[N - 1][0] >= MAX[N - 1][2]) {

			System.out.println(MAX[N - 1][0]);
		} else if (MAX[N - 1][1] >= MAX[N - 1][0] && MAX[N - 1][1] >= MAX[N - 1][2]) {
			System.out.println(MAX[N - 1][1]);
		} else {
			System.out.println(MAX[N - 1][2]);
		}
	}
}