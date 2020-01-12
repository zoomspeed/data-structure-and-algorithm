import java.util.*;

public class Main {

	static final int MAX = 1050;
	static int N;
	static int M;
	static int x;
	static int y;
	static List<Integer> list[] = new ArrayList[MAX];
	static int mark[] = new int[MAX];
	static boolean answer = true;
	static Queue<int[]> Q = new LinkedList<int[]>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < MAX; i++) {

			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {

			x = sc.nextInt();
			y = sc.nextInt();

			list[x].add(y);
			list[y].add(x);
		}

		Q.add(new int[] { list[x].get(0), 1 });
		bfs();

		if (answer) {
			System.out.println("Yes");
		}
	}

	public static void bfs() {

		while (!Q.isEmpty()) {

			if (!answer) {

				System.out.println("No");
				return;
			}

			int box[] = Q.poll();
			int node = box[0];
			int m = box[1];

			if (m != 0 && mark[node] != 0) {

				if (m == mark[node]) {
					answer = false;

				}
				continue;
			}

			if (m == 1) {

				mark[node] = 2;
			} else {
				mark[node] = 1;
			}

			for (int i = 0; i < list[node].size(); i++) {
				int current = list[node].get(i);
				Q.add(new int[] { current, mark[node] });
			}
		}
	}
}