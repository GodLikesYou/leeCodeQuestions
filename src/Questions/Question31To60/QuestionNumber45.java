package Questions.Question31To60;

/**
 * 45. 跳跃游戏 II
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 */
class QuestionNumber45 {
    /**
     * 解题思路：
     * 从数组的第 0 个位置开始跳，跳的距离小于等于数组上对应的数。求出跳到最后个位置需要的最短步数。比如上图中的第 0 个位置是 2，那么可以跳 1 个距离，或者 2 个距离，我们选择跳 1 个距离，就跳到了第 1 个位置，也就是 3 上。然后我们可以跳 1，2，3 个距离，我们选择跳 3 个距离，就直接到最后了。所以总共需要 2 步。
     * <p>
     * 解法一 ：顺藤摸瓜
     * <p>
     * 作者：windliang
     * <p>
     * 来源：力扣（LeetCode）
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int end = 0;
        int maxPostion = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPostion = Math.max(maxPostion, nums[i] + i);
            if (i == end) {
                end = maxPostion;
                steps++;
            }
        }
        return steps;
    }

    /**
     * 解法二：顺瓜摸藤
     * 我们知道最终要到达最后一个位置，然后我们找前一个位置，遍历数组，找到能到达它的位置，离它最远的就是要找的位置。然后继续找上上个位置，最后到了第 0 个位置就结束了。
     *
     * 至于离它最远的位置，其实我们从左到右遍历数组，第一个满足的位置就是我们要找的。
     *
     *
     * 作者：windliang
     *
     * 来源：力扣（LeetCode）
     *
     * @param nums
     * @return
     */
    public int jump1(int[] nums){
        int position = nums.length - 1;
        int steps = 0;
        if (position != 0) {
            for (int i = 0; i < position; i++) {
                if (nums[i] >= position -i){
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
