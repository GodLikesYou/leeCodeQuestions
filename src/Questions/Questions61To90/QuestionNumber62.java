package Questions.Questions61To90;

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * <p>
 * 来源：力扣（LeetCode）
 */
public class QuestionNumber62 {
    /**
     * 递归
     * 思路：先假定一个比较小的m和n值,比如m=3,n=2
     * 自行画出一个3X2的表格,定义(0,0)是起始表格,现在自己手工算一下(1,1)这个方格的路径是多少?
     * 再算一下(1,2)这个表格呢?再算一下(2,1)这个表格呢?有没有发现规律?
     * 规律:按照题目的定义,实际上表格的第一横行和第一竖列全部都是1,这个实际上就是我们递归的终止条件;
     * 接下来,(1,1)这个方格的路径数是(1,0)方格和(0,1)方格的路径和,这个实际上就是我们递归的递推公式
     * 有终止条件和递推公式了,递归的代码如下：
     */
    public int uniquePaths(int m, int n) {
        return cycle(m - 1, n - 1);
    }

    public int cycle(int i, int j) {
        if (i == 0 || j == 0) {
            return 1;
        }
        return cycle(i - 1, j) + cycle(i, j - 1);
    }

    /**
     * 带数组递归
     * 思路：如果大家都学过递归,就知道递归有重复计算的问题,我们上面写的递归在遇到m和n比较大的时候,
     * 同样会超过限制时间。那我们可以加一个备忘录,把已经计算出来的结果保存起来,
     * 下次需要计算同样的递归时,直接从备忘录中取出使用
     */
    int[][] dp = new int[100][100];

    public int uniquePaths1(int m, int n) {
        return cycle2(m - 1, n - 1);
    }

    public int cycle2(int i, int j) {
        if (i == 0 || j == 0) {
            return 1;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        dp[i][j] = cycle2(i - 1, j) + cycle2(i, j - 1);
        return dp[i][j];
    }
}
