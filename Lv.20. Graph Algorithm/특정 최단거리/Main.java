import java.util.*;

public class Main {
	static int N;
	static int M;
	static final int MAX = 10500;

	static ArrayList<Integer> list[] = new ArrayList[MAX];
	static ArrayList<Integer> cost[] = new ArrayList[MAX];
	static boolean visited[] = new boolean[MAX];
	static boolean visited2[] = new boolean[MAX];
	static boolean visited3[] = new boolean[MAX];
	static boolean visited4[] = new boolean[MAX];
	static int Table[] = new int[MAX];
	static int Table2[] = new int[MAX];
	static int Table3[] = new int[MAX];
	static int Table4[] = new int[MAX];
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int start = 1;
	static int answer = Integer.MAX_VALUE;
	static int end = 0;
	static int pass1 = 0;
	static int pass2 = 0;
	static int result = 0;
	static int result2 = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < MAX; i++) {

			list[i] = new ArrayList<Integer>();
			cost[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {

			int x = sc.nextInt();
			int y = sc.nextInt();
			int c = sc.nextInt();

			list[x].add(y);
			list[y].add(x);

			cost[x].add(c);
			cost[y].add(c);

		}
		start = 1;
		end = N;
		pass1 = sc.nextInt();
		pass2 = sc.nextInt();

		dijkstral(Table, visited, list, 1);

		result = result + Table[pass1];
		dijkstral(Table2, visited2, list, pass1);
		result = result + Table2[pass2];
		dijkstral(Table3, visited3, list, pass2);
		result = result + Table3[end];

		result2 = result2 + Table[pass2];
		dijkstral(Table3, visited3, list, pass2);
		result2 = result2 + Table3[pass1];
		dijkstral(Table2, visited2, list, pass1);
		result2 = result2 + Table2[end];

		answer = Math.min(result, result2);

		System.out.println(answer);

	}

	public static void dijkstral(int Table[], boolean visited[], ArrayList<Integer> list[], int start) {

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