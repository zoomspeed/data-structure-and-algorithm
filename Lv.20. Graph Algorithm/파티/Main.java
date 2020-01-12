import java.util.*;

public class Main {
	static int N;
	static int M;
	static final int MAX = 10500;
	static ArrayList<Integer> list[] = new ArrayList[MAX];
	static ArrayList<Integer> cost[] = new ArrayList[MAX];
	static boolean visited[] = new boolean[MAX];
	static int Table[] = new int[MAX];
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int start = 1;
	static int answer = Integer.MAX_VALUE;
	static int end = 0;
	static int pass1 = 0;
	static int result = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		start = sc.nextInt();

		for (int i = 0; i < MAX; i++) {

			list[i] = new ArrayList<Integer>();
			cost[i] = new ArrayList<Integer>();

		}

		for (int i = 0; i < M; i++) {

			int x = sc.nextInt();
			int y = sc.nextInt();
			int c = sc.nextInt();

			list[x].add(y);
			cost[x].add(c);
		}
		end = N;

		for (int i = 1; i <= N; i++) {

			if (i == start) {
				continue;
			}
			dijkstra(Table, visited, list, i);

			result = result + Table[start];
		}

		dijkstra(Table, visited, list, start);

		for (int j = 1; j < N + 1; j++) {

			if (j == start) {
				continue;
			}
			result = result + Table[j];
		}
		System.out.println(result);
	}

	public static void dijkstra(int Table[], boolean visited[], ArrayList<Integer> list[], int start) {

		for (int i = 0; i < MAX; i++) {

			Table[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < MAX; i++) {

			visited[i] = false;
		}

		Table[start] = 0;

		for (int i = 0; i < N; i++) {

			int index = -1;
			int value = Integer.MAX_VALUE;

			for (int j = 0; j < N + 1; j++) {

				if (!visited[j] && Table[j] < value) {
					index = j;
					value = Table[j];
				}
			}

			visited[index] = true;

			for (int j = 0; j < list[index].size(); j++) {

				int node2 = list[index].get(j);
				int costs2 = cost[index].get(j);

				if (Table[node2] > costs2 + Table[index]) {

					Table[node2] = costs2 + Table[index];
				}
			}
		}
	}
}