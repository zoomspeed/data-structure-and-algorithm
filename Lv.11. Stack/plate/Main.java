import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static String input;
	static int index = 0;
	static int outputindx = 0;
	static String output[] = new String[10000];
	static char alpabet[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		input = sc.next();
		N = input.length();

		stack s = new stack();

		s.create(N);

		int i = 'a';

		while (index < input.length()) {

			if (s.top() != input.charAt(index) && (char) i > input.charAt(index)) {

				System.out.println("impossible");
				return;
			}

			if (s.top() < input.charAt(index)) {

				s.push((char) i);
				output[outputindx++] = "push";
				i++;

			} else if (s.top() == input.charAt(index)) {
				s.pop();
				output[outputindx++] = "pop";
				index++;

			}

		}

		for (int j = 0; j < outputindx; j++) {
			System.out.println(output[j]);
		}

	}
}

class stack {

	int capacity = 0;
	char arr[];
	int len = 0;

	public stack() {

	}

	public void create(int N) {

		this.capacity = N;
		arr = new char[N];
	}

	public int size() {

		return arr.length;
	}

	public void push(char n) {

		if (capacity == len) {

			System.out.println("Overflow");
		} else {
			arr[len++] = n;
		}
	}

	public char pop() {

		if (len == 0) {

			System.out.println("Underflow");
			return '0';
		} else {

			return arr[--len];
		}
	}

	public char top() {

		if (len == 0) {

			return '0';
		} else {

			return arr[len - 1];
		}
	}

}