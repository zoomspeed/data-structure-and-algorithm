import java.util.*;

public class Main {

    static final int MAX = 1050;
    static int N;
    static int M;
    static int x;
    static int y;
    static List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static boolean visited[] = new boolean[MAX];
    static boolean visited2[] = new boolean[MAX];
    static Queue<Integer> Q = new LinkedList<Integer>();

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);


        N = sc.nextInt();
        M = sc.nextInt();
        int start = sc.nextInt();

        for(int i=0; i<=N; i++) {

            list.add(new ArrayList<Integer>());
        }


        for(int i=0; i<M; i++) {

            x = sc.nextInt();
            y = sc.nextInt();

            list.get(x).add(y);
            list.get(y).add(x);
        }

        for(int i=0; i<N; i++) {
            Collections.sort( list.get(i));
        }






        dfs(start);
        System.out.println();
        visited2[start] = true;
        Q.add(start);
        bfs();

/*
		for(int i=0; i<list.size(); i++) {
			System.out.print(i+" : ");
			for(int j=0; j<list.get(i).size(); j++) {

				System.out.print(list.get(i).get(j));
			}

			System.out.println();
		}*/

    }


    public static void dfs(int node) {

        visited[node] = true;
        int current = 0;

        System.out.print(node+" ");

        for(int i=0; i<list.get(node).size(); i++) {

            current = list.get(node).get(i);

            if(!visited[current]) {

                dfs(current);
            }

        }
    }


    public static void bfs() {
		/*
		9 12
		0 1
		0 2
		0 3
		1 5
		2 5
		3 4
		4 5
		5 6
		5 7
		5 8
		6 7
		7 8
		*/

        while(!Q.isEmpty()){
            //System.out.println();
            int node = Q.poll();

            //visited2[node] = true;
            //0

            System.out.print(node+" ");

            for(int i=0; i<list.get(node).size(); i++) {


                int current = list.get(node).get(i);
                //System.out.print(visited2[current]+" ");
                if(visited2[current] == false) {

                    visited2[current] = true;
                    Q.add(current);
                }
            }


        }

    }

}