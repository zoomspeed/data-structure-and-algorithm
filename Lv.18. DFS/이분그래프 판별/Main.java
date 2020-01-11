import java.util.*;

public class Main {
	static int N;
	static int M;
	static final int MAX = 1050;
	// static final int MMAX = 100050;
	static int x;
	static int y;
	static boolean visited[] = new boolean[MAX];
	static int left[] = new int[MAX];
	static int right[] = new int[MAX];
	static int mark[] = new int[MAX];
	static ArrayList<Integer>[] list = new ArrayList[MAX];
	static boolean answer = true;

	// static boolean matrix[][] = new boolean[NMAX][MMAX];
	public static void main(String[] args) {

		// Please Enter Your Code Here

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

		dfs(list[x].get(0), 1);

		if (answer) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

	public static void dfs(int node, int m) {

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

		for (int i = 0; i < list[node].size(); i++) {

			current = list[node].get(i);
			dfs(current, mark[node]);
		}
	}
}
