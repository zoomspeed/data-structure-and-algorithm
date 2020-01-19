import java.util.*;

public class Main {
	static int N = 0;
	static final int MAX = 1050;
	static int arr[] = new int[MAX];
	static int answer = 1;

	public static void main(String[] args) {

		// Please Enter Your Code Here

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N - 1; i++) {
			int parent = sc.nextInt();
			int child = sc.nextInt();
			arr[child] = arr[parent] + 1;

			if (arr[child] > answer) {
				answer = arr[child];
			}
		}
		System.out.println(answer);
	}
}