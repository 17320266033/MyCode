package insatiable;


/**
 * 环形路上有n个加油站，第i个加油站的汽油量是gas[i].
 *
 * 你有一辆车，车的油箱可以无限装汽油。从加油站i走到下一个加油站（i+1）花费的油量是cost[i]，你从一个加油站出发，刚开始的时候油箱里面没有汽油。
 *
 * 求从哪个加油站出发可以在环形路上走一圈。返回加油站的下标，如果没有答案的话返回-1。
 *
 * 原文链接：https://blog.csdn.net/weixin_43548025/article/details/106254611
 */
public class Gas {
    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3, 4, 5, 1,2};
        int sum = 0, total= 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        if (total < 0) {
            System.out.println(-1);
            return ;
        }
        System.out.println(start);
    }
}
