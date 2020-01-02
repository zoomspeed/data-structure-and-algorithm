import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		for (int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(s.length() - 1 - i));
		}
	}
}