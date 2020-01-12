import java.util.*;

public class Main {

	static final int MAX = 1050;
	static int N;
	static int M;
	static int x;
	static int y;
	static List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static boolean visited[] = new boolean[MAX];
	static boolean visited2[] = new boolean[MAX];
	static Queue<Integer> Q = new LinkedList<Integer>();

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

		bfs(0);
		System.out.println();
		Q.add(0);
		visited2[0] = true;
		dfs();
	}

	public static void bfs(int node) {

		visited[node] = true;
		int current = 0;

		System.out.print(node + " ");

		for (int i = 0; i < list.get(node).size(); i++) {

			current = list.get(node).get(i);

			if (!visited[current]) {

				bfs(current);
			}
		}
	}

	public static void dfs() {
		/*
		 * 9 12 0 1 0 2 0 3 1 5 2 5 3 4 4 5 5 6 5 7 5 8 6 7 7 8
		 */

		while (!Q.isEmpty()) {

			int node = Q.poll();
			System.out.print(node + " ");

			for (int i = 0; i < list.get(node).size(); i++) {

				int current = list.get(node).get(i);
				if (visited2[current] == false) {

					visited2[current] = true;
					Q.add(current);
				}
			}
		}
	}
}