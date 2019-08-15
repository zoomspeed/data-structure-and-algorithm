import java.util.Scanner;

public class Main {

    static int N = 0;
    static int answer = 0;
    static final int MAX=120;
    static int x,y, Xrange, Yrange= 0;
    static int color = 1;
    static int arr[][] = new int[MAX][MAX];
    static boolean win = true;
    public static void main(String args[]){
        //101칸 가로, 세로가 최대임.
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for(int i=0; i<N; i++){

            x = sc.nextInt();
            y = 100-sc.nextInt();
            Xrange = sc.nextInt();
            Yrange = sc.nextInt();

            for(int row=y; row>y-Yrange; row--){

                for(int col=x; col<Xrange+x; col++){

                    if(row<0 || row>100 || col<0 || col>100){

                        break;
                    }
                    arr[row][col] = color;
                }
            }

            color++;
        }

        color = 1;

        for(int i=0; i<N; i++){

            answer = 0;

            for(int row=0; row<MAX; row++){

                for(int col=0; col<MAX; col++){

                    if(arr[col][row]==color){
                        answer++;
                    }
                }
            }

            color++;

            System.out.println(answer);
        }


    }
}