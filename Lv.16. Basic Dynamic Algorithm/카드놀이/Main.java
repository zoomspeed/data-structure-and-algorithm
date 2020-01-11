import java.util.*;

public class Main {
	static int N;
	static final int range = 100500;
	static int MAX[] = new int[range];
	static int arr[] = new int[range];
	static int comp1 = 0;
	static int comp2 = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		/*
		 * 카드놀이
		 * 
		 * 문제 N개의 카드가 주어지고, 각각은 자연수의 점수를 가진다. 철수는 이제 이 카드를 가져감으로써 카드에 적혀있는 수 만큼의
		 * 점수를 얻는다. 단, 카드를 가져갈 때 한가지 규칙이 있는데, 이는 연속하여 3개의 카드는 가져갈 수 없다는 것이다. 예를
		 * 들어, 6개의 카드 “1 3 5 2 7 3”가 주어질 경우, 3+5+7+3 = 18 만큼의 점수를 얻는 것이 최대이다.
		 * N개의 카드가 주어질 때, 얻을 수 있는 점수의 최댓값을 출력하는 프로그램을 작성하시오.
		 * 
		 * 
		 * 
		 * 입력 첫 번째 줄에 N이 주어진다. ( 1 ≤ N ≤ 100,000 ) 두 번째 줄에 N개의 숫자가 주어지며, 이는 각
		 * 카드의 점수를 나타낸다.
		 * 
		 * 출력 얻을 수 있는 점수의 최댓값을 출력한다.
		 * 
		 * 
		 * 
		 * 예제 입력 6 1 3 5 2 7 3 예제 출력 18
		 */

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		// 2 3 5 2 7 3 8
		// 2 3 왼쪽 오른쪽 비교 선택
		// 3 5 1칸
		// 2 5 2 2칸(1+)
		// 2 3 2 7 3칸(2+)
		// 3 5 7 3 4칸(3+)->3칸일때 왼쪽 선택할건지 올느쪽 선택할껀지?
		// 3 5 3 8 (8+11)
		// 2 3 2 7 8 (5+9+8) = 22

		// 2 3 5 2 7 3 8
		// 2
		// 2 3
		// 3 5
		// 2 5 2
		// 2 3 2 7
		// 3 5 7 3
		// 2 5 2 3 8
		// 2 3 2 7 8

		// 2
		// 2 3
		// 3 5
		//

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		MAX[0] = arr[0];

		for (int i = 1; i < N; i++) {

			comp2 = 0;
			comp1 = 0;

			comp2 = arr[i];
			comp1 = arr[i];

			if (arr[i - 1] > 0) {
				comp1 = comp1 + arr[i - 1];

			}

			if (i - 3 >= 0 && MAX[i - 3] > 0) {
				comp1 = comp1 + MAX[i - 3];
			}

			if (i - 2 >= 0 && MAX[i - 2] > 0) {

				comp2 = comp2 + MAX[i - 2];
			}

			if (comp1 >= MAX[i - 1] && comp1 >= comp2) {
				MAX[i] = comp1;
			} else if (comp2 >= MAX[i - 1] && comp2 >= comp1) {
				MAX[i] = comp2;
			} else {
				MAX[i] = MAX[i - 1];
			}
		}

		System.out.println(MAX[N - 1]);
	}
}