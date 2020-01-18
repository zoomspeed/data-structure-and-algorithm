import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int D = 0;
	static int P = 0;
	static final int MAX = 1050;
	static ArrayList<Integer> list[] = new ArrayList[MAX];
	static boolean visited[] = new boolean[MAX];
	static boolean mark[] = new boolean[MAX];
	static boolean camera[] = new boolean[MAX];
	static int start = 0;
	static ArrayList<Integer> list2[] = new ArrayList[MAX];
	static boolean box[] = new boolean[MAX];
	static int count = 0;

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		D = sc.nextInt();
		P = sc.nextInt();

		for (int i = 0; i < MAX; i++) {

			list[i] = new ArrayList<Integer>();
			list2[i] = new ArrayList<Integer>();

		}

		for (int i = 0; i < P; i++) {

			int parent = sc.nextInt();
			int child = sc.nextInt();

			list[parent].add(child);
			list[child].add(parent);
			list2[parent].add(child);

		}

		for (int i = 0; i < D; i++) {

			if (list[i].size() == 0) {

				visited[i] = true;
				camera[i] = true;
				count++;
				continue;
			}
			if (!visited[i]) {

				visited[i] = true;
				dfs(i);
			}
		}
		if (!mark[0]) {

			for (int i = 0; i < list[0].size(); i++) {

				int current = list[0].get(i);

				if (!camera[current] && !camera[0]) {
					camera[0] = true;
					mark[0] = true;
					count++;
				}
			}

		}
		System.out.println(count);
	}

	public static void dfs(int node) {

		if (list2[node].isEmpty()) {
			return;
		}
		boolean watched = false;

		for (int i = 0; i < list2[node].size(); i++) {

			int node2 = list2[node].get(i);

			if (list2[node2].size() != 0 && !visited[node2]) {

				visited[node2] = true;
				dfs(node2);
			}

			if (!mark[node2] && !camera[node]) {

				camera[node] = true;
				mark[node] = true;
				count++;
				for (int j = 0; j < list[node].size(); j++) {

					int current = list[node].get(j);
					if (!mark[current]) {

						mark[current] = true;
					}
				}
			}
		}
	}
}
