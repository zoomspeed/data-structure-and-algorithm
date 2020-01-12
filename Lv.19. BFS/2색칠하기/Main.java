import java.util.*;

public class Main {

	static final int MAX = 1050;
	static int N;
	static int M;
	static int x;
	static int y;
	static List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static boolean visited[] = new boolean[MAX];
	static int mark[] = new int[MAX];
	static boolean answer = true;
	static Queue<int[]> Q = new LinkedList<int[]>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < N; i++) {

			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {

			x = sc.nextInt();
			y = sc.nextInt();

			list.get(x).add(y);
			list.get(y).add(x);
		}

		for (int i = 0; i < N; i++) {
			Collections.sort(list.get(i));
		}

		Q.add(new int[] { 0, 1 });
		visited[0] = true;
		bfs();

		if (answer) {
			System.out.println("YES");
		}
	}

	public static void bfs() {
		/*
		 * 9 12 0 1 0 2 0 3 1 5 2 5 3 4 4 5 5 6 5 7 5 8 6 7 7 8
		 */

		while (!Q.isEmpty()) {

			if (!answer) {

				System.out.println("NO");
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

			for (int i = 0; i < list.get(node).size(); i++) {

				int current = list.get(node).get(i);
				Q.add(new int[] { current, mark[node] });
			}
		}
	}
}
