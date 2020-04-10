package Questions.Question1to30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * <p>
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 采用四个指针的形式，前两个遍历，后面两个用了检验数据是否正确.
 * <p>
 * 注意点:
 * . 不能重复，尽量遍历过的不能重新遍历
 * . 后两个指针从头和尾分别开始，减少时间复杂度。
 * <p>
 * 指针活动范围：
 * 1、i指针从0开始到倒数第三个；
 * 2、j指针从i后面开始到倒数第二个；
 * 3、left从前往后，right从后往前，活动范围是从j开>始到最后，left和right类似两数之和的问题。
 * <p>
 * 作者：meng-chui-lu
 * <p>
 * 来源：力扣（LeetCode）
 */
class QuestionNumber18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    if (left != j + 1 && nums[left] == nums[left - 1] || nums[i] + nums[j] + nums[right] < target) {
                        left++;
                    } else if ((right != nums.length - 1 && nums[right] == nums[right + 1] || nums[i] + nums[j] + nums[right] + nums[left] > target)) {
                        right--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);

                        result.add(list);
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
