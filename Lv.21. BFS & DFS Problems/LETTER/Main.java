import java.util.*;

public class Main {
	static int N = 0;
	static int M = 0;
	static final int MAX = 30;
	static String stacked[] = new String[MAX * MAX];
	static int stackCount = 0;
	static String arr[][] = new String[MAX][MAX];
	static boolean visited[][] = new boolean[MAX][MAX];
	static int answer = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < MAX; i++) {

			for (int j = 0; j < MAX; j++) {

				arr[i][j] = ".";
			}
		}

		for (int i = 1; i <= N; i++) {

			String s = sc.next();
			for (int j = 1; j <= M; j++) {

				arr[i][j] = s.charAt(j - 1) + "";
			}
		}
		DFS(1, 1, 1);

		System.out.println(answer);

	}

	public static void DFS(int y, int x, int length) {

		boolean exit = false;

		if (arr[y][x].equals(".")) {

			return;
		}

		if (!visited[y][x]) {

			visited[y][x] = true;
		} else {

			return;
		}

		exit = check(y, x);

		if (exit) {

			visited[y][x] = false;
			return;

		}

		getMax(length);

		DFS(y - 1, x, length + 1);
		DFS(y + 1, x, length + 1);
		DFS(y, x - 1, length + 1);
		DFS(y, x + 1, length + 1);

		stackCount--;
		visited[y][x] = false;
	}

	public static boolean check(int y, int x) {

		for (int i = 0; i < stackCount; i++) {

			if (stacked[i].equals(arr[y][x])) {

				return true;
			}

		}
		stacked[stackCount++] = arr[y][x];

		return false;
	}

	public static void getMax(int length) {

		if (answer < length) {

			answer = length;
		}
	}
}