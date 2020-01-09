import java.util.Scanner;

public class Main {
	static int N;
	static int K;
	static final int MAX = 200000;
	static boolean isBreak = false;
	static int data = 0;
	static int count = 0;
	static int answer = 0;

	static int arr[] = new int[MAX];
	static int rank[] = new int[MAX];

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		queue q = new queue();

		q.create(MAX);

		q.push(K);

		rank[K] = 1;

		while (q.front() != -1) {
			// 3 6
			// 1 2 4 8
			// 0 0 1 2
			data = q.front();
			q.pop();
			count++;

			if (data / 3 >= 1 && rank[data / 3] == 0) {

				// System.out.println(data/3);
				rank[data / 3] = 1;
				// count++;
				q.push(data / 3);// 1 2
			}

			if (data * 2 <= N && rank[data * 2] == 0) {

				// System.out.println(data*2);
				rank[data * 2] = 1;
				// count++;
				q.push(data * 2);// 6 12 2
			}

		}

		answer = N - count;
		System.out.println(answer);
	}

}

class queue {

	static final int MAX = 100010;
	static int arr[] = new int[MAX];
	int ElementNum = 0;
	int capacity = 0;
	int r = 0, f = 0;

	public queue() {

	}

	public void create(int x) {

		capacity = x;

	}

	public void push(int x) {
		// 1 2 3 4 5
		//
		if (ElementNum >= capacity) {
			System.out.println("Overflow");
			return;
		}
		ElementNum++;

		arr[r] = x;
		r = (r + 1) % MAX;

	}

	public void pop() {
		// 1 2 3 4 3 -
		// f f f f f

		if (ElementNum <= 0) {
			System.out.println("Underflow");
			return;
		}

		ElementNum--;
		arr[f] = 0;

		f = (f + 1) % MAX;

	}

	public int front() {
		//
		if (ElementNum <= 0) {

			return -1;
		}

		return arr[f];
	}

}
