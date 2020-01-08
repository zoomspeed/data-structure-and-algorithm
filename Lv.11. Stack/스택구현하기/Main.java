import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int input;
	static int output;
	static int num;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		stack s = new stack();

		s.create(N);

		for (int i = 0; i < M; i++) {

			input = sc.nextInt();
			if (input == 1) {

				num = sc.nextInt();
				s.push(num);
			} else if (input == 2) {
				s.pop();

			} else if (input == 3) {

				output = s.top();
				if (output != -1) {

					System.out.println(output);
				}
			}

		}
	}
}

class stack {

	int capacity = 0;
	int arr[];
	int len = 0;

	public stack() {

	}

	public void create(int N) {

		this.capacity = N;
		arr = new int[N];
	}

	public int size() {

		System.out.println(arr.length);
		return arr.length;
	}

	public void push(int n) {

		if (capacity == len) {

			System.out.println("Overflow");
		} else {
			arr[len++] = n;
		}
	}

	public int pop() {

		if (len == 0) {

			System.out.println("Underflow");
			return -1;
		} else {

			return arr[--len];
		}
	}

	public int top() {

		if (len == 0) {

			System.out.println("NULL");
			return -1;
		} else {

			return arr[len - 1];
		}
	}

}