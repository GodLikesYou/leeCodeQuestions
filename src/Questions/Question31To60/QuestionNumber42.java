package Questions.Question31To60;

import java.util.Stack;

/**
 * 42. 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
 * 计算按此排列的柱子，
 * 下雨之后能接多少雨水。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
class QuestionNumber42 {
    /**
     * 解法一：按行求
     * 这是我最开始想到的一个解法，提交后直接 AC 了，自己都震惊了。就是先求高度为 11 的水，再求高度为 22 的水，再求高度为 33 的水。
     * <p>
     * 整个思路就是，求第 i 层的水，遍历每个位置，如果当前的高度小于 i，并且两边有高度大于等于 i 的，说明这个地方一定有水，水就可以加 11。
     * <p>
     * 如果求高度为 i 的水，首先用一个变量 temp 保存当前累积的水，初始化为 00。从左到右遍历墙的高度，遇到高度大于等于 i 的时候，开始更新 temp。更新原则是遇到高度小于 i 的就把 temp 加 11，遇到高度大于等于 i 的，就把 temp 加到最终的答案 ans 里，并且 temp 置零，然后继续循环。
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int sum = 0;
        int max = getMax(height);
        for (int i = 1; i <= max; i++) {
            boolean isStart = false;
            int temp_sum = 0;
            for (int j = 0; j < height.length; j++) {
                if (isStart && height[j] < i) {
                    temp_sum++;
                }
                if (height[j] >= i) {
                    sum = sum + temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }

    private int getMax(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }

    /**
     * 解法二：按列求
     * 求每一列的水，我们只需要关注当前列，以及左边最高的墙，右边最高的墙就够了。
     * <p>
     * 装水的多少，当然根据木桶效应，我们只需要看左边最高的墙和右边最高的墙中较矮的一个就够了。
     * <p>
     * 所以，根据较矮的那个墙和当前列的墙的高度可以分为三种情况。
     * <p>
     * 作者：windliang
     * <p>
     * 来源：力扣（LeetCode）
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            for (int j = i - 1; j >= 0; j++) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            int min = Math.min(max_left, max_right);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 解法三: 动态规划
     * 我们注意到，解法二中。对于每一列，我们求它左边最高的墙和右边最高的墙，都是重新遍历一遍所有高度，这里我们可以优化一下。
     * <p>
     * 首先用两个数组，max_left [i]代表第 i 列左边最高的墙的高度，max_right[i] 代表第 i 列右边最高的墙的高度。（一定要注意下，第 i 列左（右）边最高的墙，是不包括自身的，和 leetcode 上边的讲的有些不同）
     * <p>
     * 对于 max_left我们其实可以这样求。
     * <p>
     * max_left [i] = Max(max_left [i-1],height[i-1])。它前边的墙的左边的最高高度和它前边的墙的高度选一个较大的，就是当前列左边最高的墙了。
     * <p>
     * 对于 max_right我们可以这样求。
     * <p>
     * max_right[i] = Max(max_right[i+1],height[i+1]) 。它后边的墙的右边的最高高度和它后边的墙的高度选一个较大的，就是当前列右边最高的墙了。
     * <p>
     * 这样，我们再利用解法二的算法，就不用在 for 循环里每次重新遍历一次求 max_left 和 max_right 了。
     * <p>
     * 作者：windliang
     * <p>
     * 来源：力扣（LeetCode）
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_right[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 解法四：双指针
     * 动态规划中，我们常常可以对空间复杂度进行进一步的优化。
     * <p>
     * 例如这道题中，可以看到，max_left [ i ] 和 max_right [ i ] 数组中的元素我们其实只用一次，然后就再也不会用到了。所以我们可以不用数组，只用一个元素就行了。我们先改造下 max_left。
     * <p>
     * 作者：windliang
     * <p>
     * 来源：力扣（LeetCode）
     *
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int sum = 0;
        int max_left = 0;
        int[] max_right = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            max_left = Math.max(max_left, height[i - 1]);
            int min = Math.min(max_left, max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    public int trap4(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            if (height[left - 1] < height[right - 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }

    /**
     * 解法五：栈
     * 说到栈，我们肯定会想到括号匹配了。我们仔细观察蓝色的部分，可以和括号匹配类比下。每次匹配出一对括号（找到对应的一堵墙），就计算这两堵墙中的水。
     * <p>
     * 我们用栈保存每堵墙。
     * <p>
     * 当遍历墙的高度的时候，如果当前高度小于栈顶的墙高度，说明这里会有积水，我们将墙的高度的下标入栈。
     * <p>
     * 如果当前高度大于栈顶的墙的高度，说明之前的积水到这里停下，我们可以计算下有多少积水了。计算完，就把当前的墙继续入栈，作为新的积水的墙。
     * <p>
     * 总体的原则就是，
     * <p>
     * 当前高度小于等于栈顶高度，入栈，指针后移。
     * <p>
     * 当前高度大于栈顶高度，出栈，计算出当前墙和栈顶的墙之间水的多少，然后计算当前的高度和新栈的高度的关系，重复第 2 步。直到当前墙的高度不大于栈顶高度或者栈空，然后把当前墙入栈，指针后移。
     * <p>
     * 我们看具体的例子。
     * <p>
     * 首先将 height [ 0 ] 入栈。然后 current 指向的高度大于栈顶高度，所以把栈顶 height [ 0 ] 出栈，然后栈空了，再把 height [ 1 ] 入栈。current 后移。
     * <p>
     * 然后 current 指向的高度小于栈顶高度，height [ 2 ] 入栈，current 后移。
     * <p>
     * 然后 current 指向的高度大于栈顶高度，栈顶 height [ 2 ] 出栈。计算 height [ 3 ] 和新的栈顶之间的水。计算完之后继续判断 current 和新的栈顶的关系。
     * <p>
     * current 指向的高度大于栈顶高度，栈顶 height [ 1 ] 出栈，栈空。所以把 height [ 3 ] 入栈。currtent 后移。
     * <p>
     * 然后 current 指向的高度小于栈顶 height [ 3 ] 的高度，height [ 4 ] 入栈。current 后移。
     * <p>
     * 然后 current 指向的高度小于栈顶 height [ 4 ] 的高度，height [ 5 ] 入栈。current 后移。
     * <p>
     * 然后 current 指向的高度大于栈顶 height [ 5 ] 的高度，将栈顶 height [ 5 ] 出栈，然后计算 current 指向的墙和新栈顶 height [ 4 ] 之间的水。计算完之后继续判断 current 的指向和新栈顶的关系。此时 height [ 6 ] 不大于栈顶height [ 4 ] ，所以将 height [ 6 ] 入栈。current 后移。
     * <p>
     * 然后 current 指向的高度大于栈顶高度，将栈顶 height [ 6 ] 出栈。计算和新的栈顶 height [ 4 ] 组成两个边界中的水。然后判断 current 和新的栈顶 height [ 4 ] 的关系，依旧是大于，所以把 height [ 4 ] 出栈。计算 current 和 新的栈顶 height [ 3 ] 之间的水。然后判断 current 和新的栈顶 height [ 3 ] 的关系，依旧是大于，所以把 height [ 3 ] 出栈，栈空。将 current 指向的 height [ 7 ] 入栈。current 后移。
     * <p>
     * 其实不停的出栈，可以看做是在找与 7 匹配的墙，也就是 3 。
     * <p>
     * 而对于计算 current 指向墙和新的栈顶之间的水，根据图的关系，我们可以直接把这两个墙当做之前解法三的 max_left 和 max_right，然后之前弹出的栈顶当做每次遍历的 height [ i ]。水量就是 Min ( max _ left ，max _ right ) - height [ i ]，只不过这里需要乘上两个墙之间的距离。可以看下代码继续理解下。
     * <p>
     * 作者：windliang
     * <p>
     * 来源：力扣（LeetCode）
     *
     * @param height
     * @return
     */
    public int trap6(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.empty()){
                    break;
                }
                int distance = current - stack.peek() -1;
                int min = Math.min(height[stack.peek()],height[current]);
                sum = sum +distance*(min -h);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }
}
