import java.util.*;

public class Main {
	static long N;
	static long M;
	static long NMG = 0;
	static final int MAX = 10000;
	static long arr[] = new long[MAX];
	static int index = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		N = sc.nextLong();
		M = sc.nextLong();
		NMG = N;

		while (M != 1) {
			if (M % 2 == 1) {

				arr[index] = NMG;
				index++;

			}

			NMG = NMG * NMG;
			NMG = NMG % 10007;

			M = M / 2;

		}

		for (int i = 0; i < index; i++) {
			NMG = (NMG * arr[i]) % 10007;
		}

		System.out.println(NMG);
	}
}