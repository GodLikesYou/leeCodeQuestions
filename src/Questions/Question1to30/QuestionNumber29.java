package Questions.Question1to30;

/**
 * 29. 两数相除
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * 来源：力扣（LeetCode）
 *
 * 思想就是:除数倍增,商的计数器count也倍增,直到除数刚好比被除数小,就用被除数减去除数,更新数值,再进行下一次循环,直到被除数绝对值小于除数绝对值,其间需要考虑除数溢出,count溢出的情况。我不喜欢位运算,所以就用除数倍增来做了。这道题挺坑的(我有点菜),
 *
 * 作者：heator
 *
 * 来源：力扣（LeetCode）
 *
 */
class QuestionNumber29 {
    public int divide(int dividend, int divisor){
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int count = 0;
        int tmpdivisor = divisor;
        int doubledivisor = tmpdivisor;
        int counttime = 1;
        int doublecounttime = counttime;
        while (dividend != 0){
            tmpdivisor = divisor;
            doubledivisor = tmpdivisor;
            counttime = 1;
            doublecounttime = counttime;
            if ((dividend <= 0 && divisor < 0 && dividend <= divisor) || (dividend >= 0 && divisor > 0 && dividend >= divisor)|| (dividend <= 0 && divisor > 0 && dividend <= 0 -dividend)|| (dividend >= 0 && divisor < 0 && 0 - dividend <= divisor) ){
                while ((dividend <= 0 && divisor < 0 && dividend <= doubledivisor && (Integer.MIN_VALUE-doubledivisor)<=doubledivisor) || (dividend >= 0 && divisor > 0 && dividend >= doubledivisor &&(Integer.MAX_VALUE-doubledivisor)>=doubledivisor) || (dividend <= 0 && divisor > 0 && dividend <= 0-doubledivisor && (Integer.MIN_VALUE+doubledivisor)<=0-doubledivisor) || (dividend >= 0 && divisor < 0 && 0-dividend <= doubledivisor) && (Integer.MAX_VALUE+doubledivisor)>=0-doubledivisor){
                    tmpdivisor = doubledivisor;
                    counttime = doublecounttime;
                    doubledivisor += doubledivisor;
                    doublecounttime += doublecounttime;
                }
                count += (dividend <= 0 && divisor < 0) || (dividend >= 0 && divisor >0) ? counttime : 0 - counttime;
                dividend -= (dividend <= 0 && divisor <0) || (dividend >= 0 && divisor >0)? tmpdivisor : 0 - tmpdivisor;
            }else {
                return count;
            }
        }
        return count;
    }
}
