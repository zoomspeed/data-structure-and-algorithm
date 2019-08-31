import java.util.*;

public class Main {

    static final int MAX = 125;
    static int N;
    static int M;
    static int temp1=0;
    static int temp2 = 0;
    static int total = 0;
    static int count = 0;

    static boolean visited[][] = new boolean[MAX][MAX];

    static int answer = 0;
    static boolean Break = false;

    static Queue<int[]> Q = new LinkedList<int[]>();
    static int arr[][] = new int[MAX][MAX];
    static boolean Broken[][] = new boolean[MAX][MAX];
    //static int remove = 0;
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for(int i=0; i<N; i++) {

            for(int j=0; j<M; j++) {

                arr[i][j] = sc.nextInt();
            }
        }
        while(true) {

            Break = true;
            count = 0;

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {

                    visited[i][j] = false;
                }
            }

            Q.add(new int[] {0,0});

            bfs();

            if(Break) {
                break;
            }

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {

                    if(Broken[i][j]) {
                        //System.out.println(i+" "+j);
                        arr[i][j] = 0;
                    }
                }
            }
            total++;

            temp1 = total;
            if(count!=0)temp2 = count;

        }

        System.out.println(temp1);
        System.out.println(temp2);

    }

    public static void bfs() {
		/*
13 12
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 1 0 0 0
0 1 1 1 0 0 0 1 1 0 0 0
0 1 1 1 1 1 1 0 0 0 0 0
0 1 1 1 1 1 0 1 1 0 0 0
0 1 1 1 1 0 0 1 1 0 0 0
0 0 1 1 0 0 0 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0

3
5
		*/
        while(!Q.isEmpty()){
            //System.out.println();
            int data[] = Q.poll();
            int y = data[0];
            int x = data[1];


            if(x>=M || x<0 || y>=N || y<0) {
                continue;
            }


            if(arr[y][x]==1) {
                Broken[y][x] = true;
                Break = false;

                count++;
                continue;
            }

            if(x<M-1 && !visited[y][x+1]) {


                visited[y][x+1] = true;
                Q.add(new int[] {y,x+1});
            }
            if(x>0 && !visited[y][x-1]) {

                visited[y][x-1] = true;
                Q.add(new int[] {y,x-1});
            }
            if(y<N-1 && !visited[y+1][x]) {

                visited[y+1][x] = true;
                Q.add(new int[] {y+1,x});
            }
            if(y>0 && !visited[y-1][x]) {

                visited[y-1][x] = true;
                Q.add(new int[] {y-1,x});
            }
        }

    }

}