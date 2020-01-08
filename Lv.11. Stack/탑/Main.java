import java.util.*;

public class Main {
	static int N;
	static int arr[] = new int[500000];
	static int peek = 0;
	static int current[] = new int[2];
	static int i = 0;
	static int answer[] = new int[500000];
	static int index = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);
		Stack<int[]> stack = new Stack<>();
		N = sc.nextInt();

		for (int i = 0; i < N; i++) {

			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {

			while (!stack.isEmpty() && stack.peek()[0] < arr[i]) {

				stack.pop();

			}

			if (stack.isEmpty()) {

				System.out.print(0 + " ");
			} else {

				System.out.print(stack.peek()[1] + " ");
			}

			stack.push(new int[] { arr[i], i + 1 });

		}

	}
}
