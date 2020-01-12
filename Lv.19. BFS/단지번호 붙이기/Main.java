import java.util.*;

public class Main {

	static final int MAX = 1050;
	static int N;
	static int M;
	static int x;
	static int y;
	static int count = 0;// 현재 찾는곳의 단지 수
	static int total = 0; // 전체 단지번호 개수
	static boolean visited[][] = new boolean[MAX][MAX];
	static int house[] = new int[MAX];
	static int answer = Integer.MAX_VALUE;
	static Queue<int[]> Q = new LinkedList<int[]>();
	static int arr[][] = new int[MAX][MAX];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 0; i < N; i++) {

			String s = sc.next();

			for (int j = 0; j < s.length(); j++) {
				arr[i][j] = Integer.valueOf(s.charAt(j) + "");
			}
		}

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {

				count = 0;
				boolean b = getCheck(i, j);

				int temp = total;
				if (arr[i][j] == 1 && !b && !visited[i][j]) {
					total++;
				}
				Q.add(new int[] { i, j });
				bfs();
				if (temp < total) {
					house[total - 1] = count;
				}
			}
		}
		Arrays.sort(house);

		System.out.println(total);

		for (int i = 0; i < MAX; i++) {
			if (house[i] != 0)
				System.out.println(house[i]);
		}
	}

	public static void bfs() {
		/*
		 * 7 0110100 0110101 1110101 0000111 0100000 0111110 0111000
		 * 
		 * 
		 * 3 7 8 9
		 * 
		 * answer : 22
		 */
		while (!Q.isEmpty()) {
			int position[] = Q.poll();
			int y = position[0];
			int x = position[1];

			if (y < 0 || y >= N || x < 0 || x >= N) {
				continue;
			}

			if (visited[y][x]) {
				continue;
			}

			if (arr[y][x] == 0) {
				continue;
			}

			visited[y][x] = true;
			count++;

			if (y != 0) {

				if (!visited[y - 1][x]) {

					Q.add(new int[] { y - 1, x });
				}

			}

			if (y != N - 1) {

				if (!visited[y + 1][x]) {

					Q.add(new int[] { y + 1, x });
				}
			}

			if (x != 0) {

				if (!visited[y][x - 1]) {

					Q.add(new int[] { y, x - 1 });
				}
			}

			if (x != N - 1) {
				if (!visited[y][x + 1]) {

					Q.add(new int[] { y, x + 1 });
				}
			}
		}
	}

	public static boolean getCheck(int y, int x) {

		boolean b = false;

		if (x > 0) {
			if (visited[y][x - 1]) {
				b = true;
			}
		} else if (x <= N - 1) {
			if (visited[y][x + 1]) {
				b = true;
			}
		} else if (y > 0) {
			if (visited[y - 1][x]) {
				b = true;
			}
		} else if (y <= N - 1) {

			if (visited[y + 1][x]) {
				b = true;
			}
		}

		return b;
	}
}