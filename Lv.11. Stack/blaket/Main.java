import java.util.Scanner;

public class Main {
	static int input;
	static int output;
	static int num;
	static String s1;
	static char c;
	static boolean NVPS = false;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);
		s1 = sc.next();

		stack s = new stack();

		s.create(s1.length());
		for (int i = 0; i < s1.length(); i++) {

			c = s1.charAt(i);
			s.push(c);
			NVPS = s.getVPS(c);

			if (NVPS) {
				System.out.println("NO");
				return;
			}
		}

		if (s.getPoint() != 0) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}

	}
}

class stack {

	int point = 0;
	int capacity = 0;
	char arr[];
	int len = 0;

	public stack() {

	}

	public int getPoint() {

		return point;
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

			System.out.println("NULL");
			return '0';
		} else {

			return arr[len - 1];
		}
	}

	public boolean getVPS(char c) {

		if (c == '(') {

			point++;
		} else if (c == ')') {

			point--;
		}

		if (point < 0) {
			return true;
		}

		return false;
	}

}