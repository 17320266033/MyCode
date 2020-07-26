package dfs;


import java.util.Arrays;

/**
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。
 * 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 */
public class LongestIncrementalPath {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {3,4,5},
                {3,2,6},
                {2, 2, 1}
        };
        int m = nums.length;
        int n = nums[0].length;
        int[][] depth = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(nums, m, n, i, j, depth, 0));
            }
        }
        System.out.println(res);

    }

    public static int dfs(int[][] nums,int m, int n, int x, int y, int[][] depth, int d) {

        if (depth[x][y] > 0) {
            return depth[x][y] + d;
        }

        if (isBiggest(nums, x, y, m, n)) {
            depth[x][y] = d;
            System.out.println("最高点：x " + x + " y " + y + " d " + d);
            return d;
        }
        if (x - 1 >= 0 && nums[x - 1][y] > nums[x][y]) {
            depth[x][y] = Math.max(depth[x][y], dfs(nums, m, n, x - 1, y, depth, d + 1));
        }

        if (x + 1 < m && nums[x + 1][y] > nums[x][y]) {
            depth[x][y] = Math.max(depth[x][y], dfs(nums, m, n, x + 1, y, depth, d + 1));
        }
        if (y - 1 >= 0 && nums[x][y - 1] > nums[x][y]) {
            depth[x][y] = Math.max(depth[x][y], dfs(nums, m, n, x, y - 1, depth, d + 1));
        }
        if (y + 1 < n && nums[x][y + 1] > nums[x][y]) {
            depth[x][y] = Math.max(depth[x][y], dfs(nums, m, n, x, y + 1, depth, d + 1));
        }
        return depth[x][y];
    }

    public static boolean isBiggest(int[][] nums, int x, int y, int m, int n) {
        if (x - 1 >= 0 && nums[x - 1][y] > nums[x][y]) {
            return false;
        }
        if (x + 1 < m && nums[x + 1][y] > nums[x][y]) {
            return false;
        }
        if (y - 1 >= 0 && nums[x][y - 1] > nums[x][y]) {
            return false;
        }
        if (y + 1 < n && nums[x][y + 1] > nums[x][y]) {
            return false;
        }
        return true;
    }
}
