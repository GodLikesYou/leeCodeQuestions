package Questions.Question31To60;

import java.util.Arrays;

/**
 *31. 下一个排列
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 *
 *
 */
class QuestionNumber31 {
    public void nextPermutation(int[] nums){
        int temp;
        for (int i = nums.length -2; i>= 0; i--){
            for (int j = nums.length - 1; j < i; j++) {
                if (nums[i] < nums[j]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    Arrays.sort(nums, i+ 1, nums.length);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }
}
