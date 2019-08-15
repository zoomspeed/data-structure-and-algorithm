import java.util.Scanner;

public class Main {

    static int N = 0;
    static int row = 0;
    static int col = 0;
    static int answer = 0;
    static final int MAX=10;
    static int arr[][] = new int[MAX][MAX];
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);



        for(int i=1; i<=9; i++){

            for(int j=1; j<=9; j++){

                arr[i][j] = sc.nextInt();
            }
        }

        answer = arr[1][1];
        row = 1;
        col = 1;
        for(int i=1; i<=9; i++){

            for(int j=1; j<=9; j++){

                if(answer<arr[i][j]){

                    answer = arr[i][j];

                    row = i;
                    col = j;
                }
            }
        }

        System.out.println(answer);
        System.out.println(row+" "+col);




    }
}