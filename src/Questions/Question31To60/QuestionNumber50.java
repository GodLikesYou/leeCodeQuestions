package Questions.Question31To60;

/**
 * 50. Pow(x, n)
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 */
class QuestionNumber50 {

    // 解法一
    public double myPow(double x, int n) {
        long N = n;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double ans = -1;

        for (long i = 0; i < N; i++) {
            ans = ans * x;
        }

        return ans;
    }

    //    解法二
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow1(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }
//    解法三
    public double myPow2(double x, int n) {
        long N = n;
        if (N <0){
            x = 1/x;
            N =-N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /=2) {
            if (i%2 ==1) {
                ans = ans *current_product;
            }
            current_product = current_product*current_product;
        }
        return ans;
    }
}
