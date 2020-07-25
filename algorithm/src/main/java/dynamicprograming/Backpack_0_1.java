package dynamicprograming;

/**
 *  0 1  背包问题
 */

/**
 *
 * 某工厂预计明年有A、B、C、D四个新建项目，每个项目的投资额w及其投资后的收益v如下表所示
 *  w = [15, 10, 12, 8]  v = [12, 8, 9, 5]
 * ，投资总额为30万元，如何选择项目才能使总收益最大？
 */
public class Backpack_0_1 {

    public static void main(String[] args) {
        int[] w = new int[]{15, 10, 12, 8};
        int[] v = new int[]{12, 8, 9, 5};
        int N = 30;
        int n = 4;
        int[][] res = new int[n+1][N+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= N; j++) { // 投资额度 从0 到 N
                // 没有那么多钱投资这个
                if (j < w[i - 1]) {
                    res[i][j] = res[i - 1][j];
                }
                if (j >= w[i - 1]) {
                    res[i][j] = Math.max(res[i - 1][j - w[i - 1]] + v[i - 1], res[i - 1][j]);
                }
            }
        }
        System.out.println(res[4][30]);
    }
}
