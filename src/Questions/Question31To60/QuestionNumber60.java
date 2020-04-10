package Questions.Question31To60;

import java.util.ArrayList;
import java.util.List;

/**
 * 60. 第k个排列
 * <p>
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * <p>
 * 来源：力扣（LeetCode）
 */
class QuestionNumber60 {
    /**
     * 方法一:阶乘值通过计算得到.
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            used[i] = false;
        }
        List<String> pre = new ArrayList<>();
        return dfs(nums, used, n, k, 0, pre);
    }

    private int factorial(int n) {
        int res = 1;
        while (n > 0) {
            res *= n;
            n -= 1;
        }
        return res;
    }

    private String dfs(int[] nums, boolean[] used, int n, int k, int depth, List<String> pre) {
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (String c : pre) {
                sb.append(c);
            }
            return sb.toString();
        }
        int ps = factorial(n - 1 - depth);
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            if (ps > k) {
                k -= ps;
                continue;
            }
            pre.add(nums[i] + "");
            used[i] = true;
            return dfs(nums, used, n, k, depth + 1, pre);
        }
        throw new RuntimeException("参数错误");
    }

    /**
     * 方法二:阶乘值直接查表得到
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation1(int n, int k) {
        int[] nums = new int[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
            used[i] = false;
        }
        int[] factorial = {1,1,2,6,24,120,720,5040,40320,36280};
        List<String> pre = new ArrayList<>();
        return dfs1(nums,used,n,k,0,pre,factorial);
    }

    private String dfs1(int[] nums,boolean[] used,int n, int k,int depth,List<String> pre,int[] factorial){
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for(String c : pre){
                sb.append(c);
            }
            return sb.toString();
        }
        int ps = factorial[n -1 -depth];
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            if (ps>k) {
                k-=ps;
                continue;
            }
            pre.add(nums[i]+"");
            used[i] = true;
            return dfs1(nums,used,n,k,depth+1,pre,factorial);
        }
        throw new RuntimeException("参数错误");
    }
}
