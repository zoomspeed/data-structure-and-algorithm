import java.util.Scanner;

public class Main {

    static int N = 0;
    static final int MAX=10;
    static int x,y= 0;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    static int arr[][] = new int[MAX][MAX];
    static boolean win = true;
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        for(int i=0; i<MAX; i++){

            for(int j=0; j<MAX; j++){

                arr[i][j] = -1;
            }
        }

        for(int i=1; i<=8; i++){

            for(int j=1; j<=8; j++){

                arr[i][j] = sc.nextInt();

                if(arr[i][j]==1){
                    y = i;
                    x = j;
                }
            }
        }

        for(int i=0; i<4; i++){

            int nextY = y+dy[i];
            int nextX = x+dx[i];

            while(arr[nextY][nextX]!=3 && arr[nextY][nextX]!=-1){

                if(arr[nextY][nextX]==2){
                    win = false;
                    break;
                }

                nextY += dy[i];
                nextX += dx[i];
            }

            if(!win){
                break;
            }
        }

        if(win){
            System.out.println(0);
        }
        else{
            System.out.println(1);
        }

    }
}
