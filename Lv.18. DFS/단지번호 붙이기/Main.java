import java.util.*;

public class Main {
	static int N;
	static int M;
	static final int MAX = 30;
	static int x;
	static int y;
	static boolean visited[][] = new boolean[MAX][MAX];
	static int arr[][] = new int[MAX][MAX];
	static int total = 0;
	static int[] count = new int[MAX];
	static int countIndx = 0;
	static ArrayList<Integer>[] list = new ArrayList[MAX];

	public static void main(String[] args) {

		// Please Enter Your Code Here

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			String s = sc.next();

			for (int j = 0; j < N; j++) {

				arr[i][j] = Integer.valueOf(s.charAt(j) + "");

			}
		}

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {

				int temp = total;

				if (!visited[i][j])
					dfs(arr[i][j], j, i);

				if (total > temp) {
					countIndx++;
				}
			}
		}

		System.out.println(total);
		Arrays.sort(count);
		for (int i = 0; i < MAX; i++) {

			if (count[i] != 0)
				System.out.println(count[i]);
		}
	}

	public static void dfs(int node, int x, int y) {

		if (node == 0) {
			return;
		}
		visited[y][x] = true;

		boolean b = isNew(x, y);

		// boolean b2[] = check(x, y);
		if (!b) {
			// 방문안한것
			total++;
		}

		count[countIndx]++;

		if (x > 0) {

			if (!visited[y][x - 1])
				dfs(arr[y][x - 1], x - 1, y);
		}
		if (x < N - 1) {
			if (!visited[y][x + 1])
				dfs(arr[y][x + 1], x + 1, y);
		}
		if (y < N - 1) {
			if (!visited[y + 1][x])
				dfs(arr[y + 1][x], x, y + 1);
		}
		if (y > 0) {
			if (!visited[y - 1][x])
				dfs(arr[y - 1][x], x, y - 1);
		}

	}

	public static boolean isNew(int x, int y) {

		if (x > 0) {

			if (visited[y][x - 1]) {
				return true;
			}
		}

		if (x < N - 1) {

			if (visited[y][x + 1]) {
				return true;
			}
		}

		if (y < N - 1) {

			if (visited[y + 1][x]) {
				return true;
			}
		}

		if (y > 0) {

			if (visited[y - 1][x]) {
				return true;
			}
		}

		return false;
	}

	public static boolean[] check(int x, int y) {

		boolean[] b = { false, };

		if (x > 0) {

			if (arr[x - 1][y] == 1) {
				b[0] = true;
			}
		}

		if (x < N - 1) {

			if (arr[x + 1][y] == 1) {
				b[1] = true;
			}

		}

		if (y > 0) {

			if (arr[x][y - 1] == 1) {
				b[2] = true;
			}
		}

		if (y < N - 1) {

			if (arr[x][y + 1] == 1) {
				b[3] = true;
			}
		}

		return b;
	}
}
