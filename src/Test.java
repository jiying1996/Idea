public class Test {
    /**
     * 铺砖 斐波那契数列
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(rectCover(5));
    }

    public static int rectCover(int number) {
        if (number == 0)
            return 0;
        if (number == 1)
            return 1;
        if (number == 2)
            return 2;
        int n0 = 1;
        int n1 = 2;
        int res = n0;
        for (int i = 3; i <= number; i++) {
            res = n0 + n1;
            n0 = n1;
            n1 = res;
        }
        return res;
    }
}