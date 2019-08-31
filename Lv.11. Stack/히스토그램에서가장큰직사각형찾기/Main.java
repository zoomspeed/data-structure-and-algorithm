import java.util.*;
import java.util.Queue;
import java.util.Scanner;
public class Main{

    static int N = 0;
    static Stack<int[]> stack = new Stack<int[]>();
    static int y = 0;
    static int x = 0;
    static int max = 0;
    static int count = 0;
    static int histogram[] = new int[100500];


    public static void main(String[] args){

        // Please Enter Your Code Here
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for(int i=1; i<=N; i++){

            histogram[i] = sc.nextInt();

        }
        int left = 1;
        count = 0;
        for(int i=1; i<=N+1; i++){

            if(stack.isEmpty()||stack.peek()[0]<=histogram[i]){
                stack.push(new int[]{histogram[i],i});
                continue;
            }
            else{
                left = 1;
                while(!stack.isEmpty()&&stack.peek()[0]>histogram[i]){

                    int data[] = stack.pop();
                    int value = 0;

                    if(stack.isEmpty()){
                        left = 0;
                    }
                    else{
                        left = stack.peek()[1];
                    }

                    value = (i-left-1)*data[0];
                    if(value > max){
                        max = value;
                    }
                }
                stack.push(new int[]{histogram[i],i});
            }
        }

        System.out.println(max);
    }
}

