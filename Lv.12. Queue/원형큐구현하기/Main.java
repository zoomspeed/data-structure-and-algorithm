import java.util.Scanner;

public class Main {

	static int N = 0;
	static int M = 0;
	static int input = 0;
	static int num = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		queue q = new queue();

		q.create(N);

		for (int i = 0; i < M; i++) {

			input = sc.nextInt();

			if (input == 1) {

				num = sc.nextInt();

				q.push(num);
			} else if (input == 2) {

				q.pop();
			} else {

				if (q.front() != -1)
					System.out.println(q.front());
			}
		}
	}
}

class queue {

	static final int MAX = 100;
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

			System.out.println("NULL");

			return -1;
		}

		return arr[f];
	}

}