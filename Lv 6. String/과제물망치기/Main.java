import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		s = s.trim();
		s = s.replace(" ", "");

		System.out.println(s);
	}
}