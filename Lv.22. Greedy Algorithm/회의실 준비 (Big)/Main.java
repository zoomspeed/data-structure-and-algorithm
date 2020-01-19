import java.util.*;

public class Main {
	static PriorityQueue<table> Q = new PriorityQueue<table>();
	static int N = 0;
	static final int MAX = 100050;
	static table box[] = new table[MAX];
	static int time = 1;
	static int len = 0;
	static int answer = 0;
	static int endPoint = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 0; i < MAX; i++) {

			box[i] = new table();
		}

		for (int i = 0; i < N; i++) {

			int start = sc.nextInt();
			int end = sc.nextInt();

			box[i].start = start;
			box[i].end = end;

			if (box[i].end > endPoint) {
				endPoint = box[i].end;
			}
		}

		Arrays.sort(box, 0, N, new Comparator<table>() {

			@Override
			public int compare(table t1, table t2) {
				// TODO Auto-generated method stub

				if (t1.start > t2.start) {

					return 1;
				} else if (t1.start == t2.start) {

					if (t1.end == t2.end) {
						return 0;
					} else if (t1.end > t2.end) {
						return 1;
					} else {
						return -1;
					}
				} else {
					return -1;
				}
			}
		});
		getAnswer();

		System.out.println(answer);
	}

	public static void getAnswer() {

		time = 1;

		while (time <= endPoint) {

			boolean changed = true;
			if (!Q.isEmpty())

				while (!Q.isEmpty() && changed) {

					changed = false;

					if (time >= Q.peek().end) {

						Q.poll();
						changed = true;
					}

				}
			changed = true;

			while (changed) {

				changed = false;

				if (box[len].start != 0 && time >= box[len].start) {

					Q.add(box[len]);

					len++;
					changed = true;
				}
			}

			if (answer < Q.size()) {

				answer = Q.size();
			}
			time++;
		}
	}
}

class table implements Comparable<table> {
	int start = 0;
	int end = 0;

	@Override
	public int compareTo(table o) {

		if (this.end < o.end) {

			return -1;
		} else if (this.end > o.end) {

			return 1;
		}

		return 0;
	}
}