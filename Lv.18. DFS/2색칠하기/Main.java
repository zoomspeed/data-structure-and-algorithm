import java.util.*;

public class Main {
	static int N;
	static int M;
	static final int MAX = 1050;
	// static final int MMAX = 100050;
	static int x;
	static int y;
	static boolean visited[] = new boolean[MAX];
	static int mark[] = new int[MAX];
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static boolean answer = true;

	// static boolean matrix[][] = new boolean[NMAX][MMAX];
	public static void main(String[] args) {

		// Please Enter Your Code Here

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

		bfs(0, 1);

		if (answer) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	public static void bfs(int node, int m) {

		int current = 0;

		if (!answer) {

			return;
		}

		if (m != 0 && mark[node] != 0) {

			if (mark[node] == m) {

				answer = false;
			}
			return;
		}

		if (m == 1) {

			mark[node] = 2;
		} else {
			mark[node] = 1;
		}

		for (int i = 0; i < list.get(node).size(); i++) {

			current = list.get(node).get(i);

			bfs(current, mark[node]);
		}
	}
}