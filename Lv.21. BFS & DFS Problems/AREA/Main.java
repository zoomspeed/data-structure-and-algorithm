import java.util.*;

public class Main {

    static int N = 0;
    static int M = 0;
    static int K = 0;
    static final int MAX = 150;
    static int map[][] = new int[MAX][MAX];
    static boolean visited[][] = new boolean[MAX][MAX];
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    static int xy1[][] = new int[MAX][2];
    static int xy2[][] = new int[MAX][2];
    static Queue<int[]> queue = new LinkedList<int[]>();
    static int count[] = new int[MAX];
    static int count_len = 0;
    static int answer = 0;
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        for(int k=0; k<K; k++){

            xy1[k][1] = sc.nextInt();
            xy2[k][0] = N-sc.nextInt();
            xy2[k][1] = sc.nextInt();
            xy1[k][0] = N-sc.nextInt();
        }


        for(int k=0; k<K; k++){

            for(int col = xy1[k][0]; col<xy2[k][0]; col++){

                for(int row = xy1[k][1]; row<xy2[k][1]; row++){

                    map[col][row] = 1;
                }
            }
        }

        for(int col=0; col<N; col++){

            for(int row=0; row<M; row++){

                if(map[col][row]==0 && !visited[col][row]){

                    visited[col][row] = true;

                    queue.add(new int[]{col,row});
                    answer++;

                    bfs();
                    count_len++;
                }
            }

        }

        //System.out.println(count_len);
        Arrays.sort(count,0, count_len);


        System.out.println(answer);

        for(int i=0; i<count_len; i++){

            System.out.print(count[i]+" ");
        }

    }

    public static void vreset(){

        for(int col=0; col<MAX; col++){

            for(int row=0; row<MAX; row++){

                visited[col][row] = false;
            }
        }
    }

    public static void bfs(){

        while(queue.peek()!=null){

            int data[] = queue.poll();

            int col = data[0];
            int row = data[1];


            count[count_len]++;

            for(int i=0; i<4; i++){

                int x = row + dx[i];
                int y = col + dy[i];

                if( y<0 || y>=N || x<0 || x>=M){
                    continue;
                }
                //System.out.println("!!");
                if(visited[y][x]){
                    continue;
                }

                if(map[y][x]==1){
                    continue;
                }

                visited[y][x] = true;

                queue.add(new int[]{y,x});
            }
        }
    }

}