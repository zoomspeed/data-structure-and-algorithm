import java.util.Scanner;

public class Main {

    /**
     * n명의 사람중 m명을 순서에 상관없이 뽑는 경우의 수를 조합이라고 하며 nCm으로 나타낸다.
     *
     * 이 조합은 파스칼의 삼각형과 아주 밀접한 관련이 있다고 한다.
     *
     * n과 m이 주어졌을때 nCm의 값을 출력하는 프로그램을 작성하시오.
     *
     * nCm은 수식으로 n!/m!(n-m)! 으로 구할 수 있다. (5! = 12345)
     *
     * 첫째 줄에 정수 n, m(0≤m≤n≤30)이 들어온다.
     * 첫째 줄에 nCm의 값을 출력한다.
     *
     * 5 2
     *
     * 10
     *
     * @param args
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int result = (combinationDigits(n,m));


        System.out.println(result);
    }

    private static int combinationDigits(int n, int m) {

        int topFives=0, botFives=0;
        int topTwos=0, botTwos=0;

        //top: n!
        //bot: m! + (n-m)!

        topFives = findTrailingZeros(n,5);
        botFives = findTrailingZeros(m,5) + findTrailingZeros((n-m),5);

        topTwos = findTrailingZeros(n,2);
        botTwos = findTrailingZeros(m,2) + findTrailingZeros((n-m),2);

        int trailingZerosFives = topFives - botFives;
        int trailingZerosTwos = topTwos -botTwos;

        return Math.min(trailingZerosFives, trailingZerosTwos);
    }

    private static int findTrailingZeros(int n, int num) {
        int count=0;
        while (n!=0){
            n/=num;
            count+=n;
        }

        return count;
    }


}