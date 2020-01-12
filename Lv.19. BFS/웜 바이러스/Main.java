import java.util.*;

public class Main {

	static final int MAX = 1050;
	static int N;
	static int M;
	static int x;
	static int y;
	static List<Integer> list[] = new ArrayList[MAX];
	static boolean visited[] = new boolean[MAX];
	static int answer = 0;
	static Queue<Integer> Q = new LinkedList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		Q.add(1);
		visited[1] = true;
		bfs();

		System.out.println(answer);
	}

	public static void bfs() {
		/*
		 * 7 6 1 2 2 3 1 5 5 2 5 6 4 7
		 * 
		 * 
		 * answer : 4
		 */
		while (!Q.isEmpty()) {

			int node = Q.poll();
			for (int i = 0; i < list[node].size(); i++) {
				int current = list[node].get(i);
				if (!visited[current]) {
					Q.add(current);
					answer++;
					visited[current] = true;
				}
			}
		}
	}
}