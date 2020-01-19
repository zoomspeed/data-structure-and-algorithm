import java.util.*;

public class Main {

	static int N = 0;
	static final int MAX = 100050;
	static meet box[] = new meet[MAX];
	static Queue<meet> Q = new LinkedList<meet>();
	static int len = 1;
	static int count = 0;
	static int exit = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < MAX; i++) {

			box[i] = new meet();
		}

		for (int i = 0; i < N; i++) {

			box[i].start = sc.nextInt();
			box[i].end = sc.nextInt();

			if (box[i].end > exit) {

				exit = box[i].end;
			}
		}

		Arrays.sort(box, 0, N);

		start();
		System.out.println(count);
	}

	public static void start() {

		len = 0;
		int end = 0;
		for (int time = 1; time <= exit; time++) {

			if (len >= N) {
				break;
			}

			while (box[len].start < time) {

				len++;

				if (len >= N) {
					break;
				}
			}

			if (!Q.isEmpty() && Q.peek().end <= time) {

				Q.poll();
			}

			if (Q.isEmpty()) {
				count++;
				Q.add(box[len]);
			}
		}
	}
}

class meet implements Comparable<meet> {

	int start;
	int end;

	@Override
	public int compareTo(meet m) {
		// TODO Auto-generated method stub
		if ((this.end) < (m.end)) {

			return -1;
		} else if ((this.end) > (m.end)) {

			return 1;
		} else if ((this.end) == (m.end)) {

			if (this.end - this.start < m.start - m.end) {
				return 1;
			} else {

				return -1;
			}
		} else {

			return 0;
		}
	}
}