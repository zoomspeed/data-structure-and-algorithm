import java.util.Scanner;

public class Main {

    static int N = 0;
    static int M = 0;
    static final int MAX=12;
    static int map[][] = new int[MAX][MAX];
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);


        N = sc.nextInt();

        for(int i=0; i<10; i++) {

            for (int j = 0; j < 10; j++) {

                map[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<N; i++){

            for(int j=0; j<10; j++){

                if(i==j){
                    continue;
                }
                if(map[i][j] ==0){

                    map[i][j] = 1;
                }
                else{
                    map[i][j] = 0;
                }
            }


            for(int j=0; j<10; j++){

                if(i==j){
                    continue;
                }
                if(map[j][i] ==0){

                    map[j][i] = 1;
                }
                else{
                    map[j][i] = 0;
                }
            }

            if(map[i][i]==0){
                map[i][i] = 1;
            }
            else{
                map[i][i] = 0;
            }

        }

        for(int i=0; i<10; i++) {

            for (int j = 0; j < 10; j++) {

                System.out.print(map[i][j]+" ");

            }
            System.out.println();
        }

    }
}
