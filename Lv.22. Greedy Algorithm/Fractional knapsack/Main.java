import java.util.*;

public class Main {
	static final int MAX = 100500;
	static int N = 0;
	static int boxWeight = 0;
	static snack snacks[] = new snack[MAX];
	static double sum = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		boxWeight = sc.nextInt();

		for (int i = 0; i < MAX; i++) {

			snacks[i] = new snack();
		}
		for (int i = 0; i < N; i++) {
			int weight = sc.nextInt();
			double price = sc.nextDouble();

			snacks[i].weight = weight;
			snacks[i].value = price / weight;
		}
		Arrays.sort(snacks, 0, N, new Comparator<snack>() {

			@Override
			public int compare(snack snack1, snack snack2) {
				// TODO Auto-generated method stub
				if (snack1.value < snack2.value) {

					return 1;
				} else if (snack1.value == snack2.value) {

					if (snack1.weight == snack2.weight) {
						return 0;
					} else if (snack1.weight < snack2.weight) {
						return 1;
					} else {
						return -1;
					}
				} else {
					return -1;
				}

			}
		});
		int len = 0;
		for (int i = boxWeight; i > 0;) {

			if (len >= N) {
				break;
			}

			if (i <= snacks[len].weight) {
				sum = sum + snacks[len].value * i;

				i = 0;
			} else {
				i = i - snacks[len].weight;
				sum = sum + snacks[len].weight * snacks[len].value;
				len++;
			}
		}

		System.out.printf("%.3f", sum);
	}
}

class snack {

	double value;
	int weight;
}