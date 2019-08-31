import java.util.Scanner;
public class Main{
    static int N;
    static int index=0;
    static final int MAX = 90;
    static int arr[] = new int[MAX];

    public static void main(String[] args){

        // Please Enter Your Code Here
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();


        getGoodseq(1,1);

        for(int i=0; i<N; i++){

            System.out.print(arr[i]);
        }
    }

    public static void getGoodseq(int num, int depth){


        boolean b = false;


        //기저조건 : 해당 숫자가 3을 초과하거나?
        //기저조건 : 해당 depth가 문제의 요구사항N을 넘어 갔을 시 종료.

        //if N == 8
        //depth의 초기값 : 1
        //1 2 3 4 5 6 7 8 (O) 9(X)
        if(depth>N){
            //System.out.println(depth);
            return;
        }
        //System.out.println("@@@"+num+" "+depth);

        if(num>3){
            return;
        }



        //depth부터 검사해서 배열의 끝까지 검사함.
        //index의 값은 확정된 배열의 값이 증가할 때 마다 하나씩 증가함.

        //먼저 검사하여 넣을 수 있는 값인지 check함수로 확인 후에 아닐경우 return 해주고,
        //넣을 수 있는 값일 때 아래 과정 수행함.


        //arr[]에 값 넣어 비교후 해당값이 맞지 않으면 index 앞당기기..
        arr[index] = num;
        index++;
        b = check(num, depth);
        //
        //값이 참일때(해당 배열이 좋은 수열을 만족함)
        if(b || depth==1){
            //해당값이 적합한 값이면 다음 depth로 넘어감/


            getGoodseq(1, depth+1);
            //System.out.println(index+ " "+ num+ " "+depth);

        }
        else{
            //해당값이 적합한 값이 아니면 다음 depth로 넘어가지 않고 다음숫자를 증가시켜 비교함.
            index--;

            if(num>=3){
                //System.out.println(index);
                //System.out.println(num+ "  "+depth+" "+(arr[depth-2]+1));
                getGoodseq((arr[--index]+1),depth-1);
            }
            else {
                getGoodseq(num+1, depth);
            }

        }


        //return;
    }


    public static boolean check(int num, int depth){
        //b가 true면 중복되는것
        boolean b = true;
        //depth/2 한 값만큼의 크기를 가진 범위의 수를 탐색함.
        //맨 처음에 1의 값이 들어온다면, 현재 depth를 가리키는 값의 인덱스인 곳의
        //전번지까지 비교
        //depth 1 (현재수,현재수-1) 비교
        //depth 2 (현재수,현재수-1), (현재수-2,현재수-3) 번지 비교
        //depth 3 (현재수, 현재수-1, 현재수-2), (현재수-3, 현재수-4, 현재수-5)

        //비교할 값을 저장할 compare 배열 2개를 선언후에 각각 넣어서 비교한다??
        //그냥 비교한다???
        //1. 직접 값 안넣고 현재 번지수의 값과 비교할 대상을 하나씩 배열에서 선정하여 비교하기
        //
        //System.out.println("@@@"+num);
        for(int i=1; i<depth/2+1; i++){
            b = true;
            for(int j=depth-1; j>depth-1-i; j--){
                //7>6 1번
                //7>5 1,2 번수행
                if(arr[j]!=arr[j-i]){
                    //j값 7,6,5,4
                    //i값 6
                    //7, 6
                    //7 5 2번째
                    //6 4
                    //7 4
                    //6 3
                    //5 2 3번째
                    //7 3, 6 2, 5 1, 4 0
                    //System.out.println(arr[j]+"  "+arr[j-i]);
                    b = false;
                    break;


                }

            }

            if(b){
                return false;
            }

        }
        return true;
    }
}