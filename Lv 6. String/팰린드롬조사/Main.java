import java.util.Scanner;

public class Main {
	static int start = 0, end = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		end = s.length() - 1;
		if (pal(s)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	public static boolean pal(String s) {

		if (start >= end) {
			return true;
		}

		if (s.charAt(start) != s.charAt(end)) {
			return false;
		}

		start++;
		end--;

		return pal(s);

	}
}