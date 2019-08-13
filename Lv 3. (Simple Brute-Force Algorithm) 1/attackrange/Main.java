import java.util.Scanner;

public class Main {

    static int N = 0;
    static final int MAX=120;
    static int x,y, range= 0;
    static int arr[][] = new int[MAX][MAX];
    static boolean win = true;
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        y = sc.nextInt()-1;
        x = sc.nextInt()-1;
        range = sc.nextInt();

        for(int i=0; i<N; i++){

            for(int j=0; j<N; j++){

                int distance = Math.abs(y-i)+Math.abs(x-j);

                if(range>=distance){

                    arr[i][j] = distance;
                }
            }
        }

        for(int i=0; i<N; i++){

            for(int j=0; j<N; j++){

                if(y==i&&x==j){
                    System.out.print("x ");
                }
                else{
                    System.out.print(arr[i][j]+" ");
                }
            }
            System.out.println();
        }

    }
}