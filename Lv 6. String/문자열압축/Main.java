import java.util.Scanner;

public class Main {
	static int count = 1;
	static char val;
	static int length = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		val = s.charAt(0);
		String output = "";

		length = s.length();

		for (int i = 0; i < length; i++) {

			if (i != length - 1 && s.charAt(i) == s.charAt(i + 1)) {

				count++;
			} else {

				if (count == 1) {
					output = output + "" + s.charAt(i);
				} else {
					output = output + "" + count + "" + s.charAt(i);
				}

				count = 1;
			}
		}

		System.out.println(output);
	}
}