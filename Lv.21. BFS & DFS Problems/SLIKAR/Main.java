import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static final int MAX = 55;

	static int R = 0;
	static int C = 0;

	static int x = 0;
	static int y = 0;
	static int x2 = 0;
	static int y2 = 0;

	static char arr[][] = new char[MAX][MAX];
	static boolean visited[][] = new boolean[MAX][MAX];
	static boolean Wvisited[][] = new boolean[MAX][MAX];
	static Queue<int[]> Q = new LinkedList<int[]>();
	static Queue<int[]> W = new LinkedList<int[]>();
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();

		for (int i = 0; i < MAX; i++) {

			for (int j = 0; j < MAX; j++) {

				arr[i][j] = ';';
			}
		}

		for (int i = 1; i <= R; i++) {

			String s = sc.next();
			for (int j = 1; j <= C; j++) {

				arr[i][j] = s.charAt(j - 1);

				if (arr[i][j] == 'S') {

					y = i;
					x = j;
				}

				if (arr[i][j] == '*') {

					y2 = i;
					x2 = j;
				}
			}
		}
		Q.add(new int[] { y, x, 0 });

		bfs();

		if (answer == Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(answer);
		}

	}

	public static void bfs() {

		boolean exit = false;

		while (Q.peek() != null) {

			int data[] = Q.poll();
			int y = data[0];
			int x = data[1];
			int length = data[2];

			if (arr[y][x] == ';') {

				continue;
			}

			if (visited[y][x]) {

				continue;
			}

			visited[y][x] = true;

			if (arr[y][x] == 'X') {

				continue;
			}

			if (arr[y][x] == 'D') {

				if (answer > length) {
					answer = length;
				}
				continue;
			}

			W.add(new int[] { y2, x2, 0 });
			exit = Wbfs(y, x, length);
			Wrefresh();

			if (exit) {

				continue;
			}

			Q.add(new int[] { y + 1, x, length + 1 });
			Q.add(new int[] { y - 1, x, length + 1 });
			Q.add(new int[] { y, x + 1, length + 1 });
			Q.add(new int[] { y, x - 1, length + 1 });

		}
	}

	public static boolean Wbfs(int Ytarget, int Xtarget, int di) {

		boolean gameover = false;

		while (W.peek() != null) {

			int data[] = W.poll();
			int y = data[0];
			int x = data[1];
			int length = data[2];

			if (arr[y][x] == ';') {

				continue;
			}

			if (arr[y][x] == 'X' || arr[y][x] == 'D') {

				continue;
			}

			if (Wvisited[y][x]) {

				continue;
			}

			Wvisited[y][x] = true;

			if (length > di) {
				continue;
			}

			if (Ytarget == y && Xtarget == x) {

				gameover = true;
				continue;
			}

			W.add(new int[] { y + 1, x, length + 1 });

			W.add(new int[] { y - 1, x, length + 1 });

			W.add(new int[] { y, x + 1, length + 1 });

			W.add(new int[] { y, x - 1, length + 1 });
		}
		return gameover;
	}

	public static void Wrefresh() {

		for (int i = 0; i < MAX; i++) {

			for (int j = 0; j < MAX; j++) {

				Wvisited[i][j] = false;
			}
		}
	}
}