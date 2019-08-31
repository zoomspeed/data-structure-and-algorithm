import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N = 0;
    static final int MAX = 100500;
    static ArrayList<Integer> list[] = new ArrayList[MAX];
    static boolean visited[] = new boolean[MAX];
    static int pNode = 0;
    static int count = 0;
    static int answer[] = new int[MAX];
    static int answerLen = 0;
    static boolean cycle = false;
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for(int i=0; i<MAX; i++){

            list[i] = new ArrayList<Integer>();
        }



        for(int i=1; i<=N; i++){

            int data = sc.nextInt();
            list[i].add(data);

        }

        for(int i=1; i<=N; i++){

            reset();
            cycle = false;
            pNode = i;

            //boolean b = dfs(i);
            //System.out.println(b);
            dfs(i);
            //System.out.println(cycle);

            if(cycle){
                answer[answerLen++] = i;
                count++;
            }
        }


        System.out.println(count);
        for(int i=0; i<answerLen; i++){

            System.out.print(answer[i]+" ");
        }





    }

    public static void dfs(int node){

        //boolean cycle = false;

        if(visited[node] && pNode==node){

            cycle = true;
            //return cycle;
        }


        for(int i=0; i<list[node].size(); i++){

            int node2 = list[node].get(i);

            if(!visited[node2]){

                visited[node2] = true;

                //return dfs(node2);
                dfs(node2);
            }
        }

        //return cycle;
    }

    public static void reset(){

        for(int i=0; i<MAX; i++){

            visited[i] = false;
        }
    }

}