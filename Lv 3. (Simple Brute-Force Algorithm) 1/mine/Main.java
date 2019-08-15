import java.util.Scanner;

public class Main {

    static int N,M = 0;
    static int answer = 0;
    static final int MAX=120;
    static int x,y = 0;
    static int dy[] = {-1,1,0,0,-1,1,-1,1};
    static int dx[] = {0,0,-1,1,-1,-1,1,1};
    static int arr[][] = new int[MAX][MAX];
    public static void main(String args[]){
        //101칸 가로, 세로가 최대임.
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        y = sc.nextInt()-1;
        x = sc.nextInt()-1;

        for(int i=0; i<N; i++){

            for(int j=0; j<M; j++){

                arr[i][j] = sc.nextInt();
            }
        }

        if(arr[y][x]==1){

            System.out.println("game over");
            return;
        }

        for(int i=0; i<8; i++){

            int nextY=y+dy[i];
            int nextX=x+dx[i];

            if(nextY<0 || nextY>=100 || nextX<0 || nextX>=100){

                continue;
            }

            if(arr[nextY][nextX]==1){
                answer++;
            }
        }

        System.out.println(answer);
    }
}
