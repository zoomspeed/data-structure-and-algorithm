import java.util.Scanner;

public class Main {

    static int N = 0;
    static int M = 0;
    static int NMG = 1;
    static final int MAX=120;
    static int arr[][] = new int[MAX][MAX];
    static int map[][] = new int[MAX][MAX];
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);


        N = sc.nextInt();
        M = sc.nextInt();

        for(int i=0; i<N; i++) {

            for (int j = 0; j < M; j++) {

                arr[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<N; i++){

            for(int j=0; j<M; j++){

                map[i][M-j-1] = arr[i][j];
            }
        }

        for(int i=0; i<N; i++) {

            for (int j = 0; j < M; j++) {

                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }
}