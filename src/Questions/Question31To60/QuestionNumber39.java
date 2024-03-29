package Questions.Question31To60;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 *
 */
class QuestionNumber39 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates,int target){
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        addElement(candidates,list,sum,target,0);
        return res;
    }
    private void addElement (int[] candidates, List<Integer> list ,int sum , int target, int index){
        if (sum > target){
            return;
        }
        if (sum == target){
            res.add(list);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            List<Integer> tList = new ArrayList<>();
            tList.add(candidates[i]);
            addElement(candidates,tList, sum + candidates[i], target,1);
        }
    }
}
