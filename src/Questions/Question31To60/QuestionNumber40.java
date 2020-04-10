package Questions.Question31To60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 *
 */
class QuestionNumber40 {
    /**
     * 思路：
     *
     * 遍历数组中的值，如果nums[i] < target , 尝试把nums[i]作为一个加数，把目标值减去nums[i]，下一次递归从i+1开始遍历数组寻找下一个加数
     * 如果target=0，说明找到了一组加数
     * 否则把上一个加数从list中去掉
     * 去重：需要先对数组进行排序，每次递归寻找的是一个位置的加数值，同一个位置不能使用相同的加数值,
     *
     * 作者：sysong
     *
     * 来源：力扣（LeetCode）
     *
     * @param candidates
     * @param target
     * @return
     */
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        if (candidates.length == 0){
            return ans;
        }
        Arrays.sort(candidates);
        helper(candidates,0,target,new ArrayList<>());
        return ans;
    }
    private void helper(int[] nums, int l, int target , List<Integer> list){
        if (target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = l; i < nums.length; i++) {
            if (i>l && nums[i] == nums[i-1]){
                continue;
            }
            if (target-nums[i] >=0){
                list.add(nums[i]);
                helper(nums,i+1 ,target -nums[i],list);
                if (list.size() >0){
                    list.remove(list.size() -1);
                }
            }
        }
    }
}
