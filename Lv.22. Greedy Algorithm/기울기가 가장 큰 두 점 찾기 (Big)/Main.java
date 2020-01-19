import java.util.*;

public class Main {
	static final int MAX = 100500;
	static Pointer point[] = new Pointer[MAX];
	static int N = 0;
	static long answer = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		for (int i = 0; i < MAX; i++) {

			point[i] = new Pointer();

		}

		for (int i = 0; i < N; i++) {

			point[i].x = sc.nextInt();
			point[i].y = sc.nextInt();

		}
		Arrays.sort(point, 0, N, new Comparator<Pointer>() {

			@Override
			public int compare(Pointer p1, Pointer p2) {
				// TODO Auto-generated method stub
				if (p1.x > p2.x) {

					return 1;
				} else if (p1.x < p2.x) {
					return -1;
				} else if (p1.x == p2.x) {

					if (p1.y < p2.y) {
						return -1;
					} else if (p1.y > p2.y) {

						return 1;
					} else {
						return 0;
					}

				}

				return 0;

			}

		});
		int indx = 0;
		for (int i = 0; i < N - 1; i++) {

			if (i == 0) {

				continue;
			}

			if (point[i].x - point[i + 1].x == 0) {

				continue;
			} else {
				indx = i;
			}

			if (answer < (Math.abs(point[indx].y - point[i + 1].y)) / Math.abs((point[indx].x - point[i + 1].x))) {

				answer = Math.abs((point[indx].y - point[i + 1].y)) / Math.abs((point[indx].x - point[i + 1].x));
			}
		}
		System.out.println(String.format("%.3f", Float.valueOf(Math.round(answer * 1000) / 1000)));
	}
}

class compareMyClass1 implements Comparator<Pointer> {

	@Override
	public int compare(Pointer p1, Pointer p2) {
		// TODO Auto-generated method stub

		if (p1.x > p2.x) {

			return -1;
		} else if (p1.x < p2.x) {
			return 1;
		} else if (p1.x == p2.x && p1.y < p2.y) {
			return 1;
		} else {
			return -1;
		}
	}
}

class Pointer {

	int x;
	int y;
}