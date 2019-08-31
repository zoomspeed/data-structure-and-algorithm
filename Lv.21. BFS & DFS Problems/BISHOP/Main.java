import java.util.*;


public class Main {

    static int N = 0;
    static int MAX = 15;
    static int map[][] = new int[MAX][MAX];
    static int color[][] = new int[MAX][MAX];
    static int number[] = new int[MAX*MAX];
    static int bishopcnt = 0;
    static int bishop[][] = new int[MAX*MAX][MAX*MAX];
    static int dx[] = {-1,1,-1,1};
    static int dy[] = {-1,-1,1,1};
    static int answer = 0;
    static int ans[] = new int[2];
    static boolean visited[][] = new boolean[MAX][MAX];
    static boolean even = true;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for(int col=0; col<N; col++){

            for(int row=0; row<N; row++){

                map[col][row] = sc.nextInt();


                if(col%2==0){

                    if(row%2==0){

                        color[col][row] = 1;
                    }
                    else{
                        color[col][row] = 0;
                    }

                }
                else{
                    if(row%2==0){

                        color[col][row] = 0;
                    }
                    else{
                        color[col][row] = 1;
                    }
                }
            }
        }

        dfs(0,1,0);
        dfs(0,0,0);
        System.out.println(ans[0]+ans[1]);
    }



    public static void dfs(int v, int val, int cnt){
        if(ans[val]<cnt){
            ans[val] = cnt;
        }
        int y = v/N;
        int x = v%N;

        for(int i=v; v<N*N; v++){

            int col = v/N;
            int row = v%N;

            if(color[col][row]!=val || visited[col][row] || map[col][row]!=1){
                continue;
            }

            if(check(col,row)){
                visited[col][row] = true;
                dfs(v, val, cnt+1);
            }
        }
        visited[y][x] = false;

    }

    public static void draw(){

        int y =0;
        int x =0;

        for(int i=0; i<bishopcnt; i++){

            if(number[i]==1){

                y = bishop[i][0];
                x = bishop[i][1];
            }

        }

    }


    public static boolean check(int y , int x){

        //boolean b = true;
        int nextY= 0;
        int nextX = 0;
        for(int i=0; i<4; i++){
            nextY = y;
            nextX = x;

            for(int j=0; j<=N; j++){

                nextY = nextY+dy[i];
                nextX = nextX+dx[i];

                if(nextY<0||nextY>=N||nextX<0||nextX>=N){
                    continue;
                }
                if(visited[nextY][nextX]){
                    return false;
                }
            }
        }

        return true;

    }

    public static void vreset(){

        for(int i=0; i<N; i++){


            for(int j=0; j<N; j++){

                visited[i][j] = false;
            }
        }
    }
}