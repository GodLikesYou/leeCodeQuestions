package Questions.Question31To60;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 *
 */
class QuestionNumber34 {
    public int[] searchRange(int[] nums, int target){
        int[] result = new int[2];
        result[0] = findTarget(nums,target,false);
        result[1] = findTarget(nums, target, true);
        return result;
    }
    public int findTarget( int[] nums, int target, boolean tag){
        if (nums.length == 0 || nums[0] > target || nums[nums.length - 1] <target){
            return -1;
        }
        int res = -1;
        int left = 0, right = nums.length -1;
        int mid;
        while (left <= right){
            mid = left +(right - left )/2;
            if (nums[mid] == target){
                if (!tag){
                    right =mid -1;
                    if (mid ==0 || nums[mid -1] < target){
                        right = mid -1;
                        if (mid == 0 || nums[mid -1] < target){
                            return mid;
                        }
                    }else{
                        left = mid +1;
                        if (mid == nums.length -1 || nums[mid +1] > target){
                            return mid;
                        }
                    }
                }else if (nums[mid] >target){
                    right = mid -1;
                }else {
                    left = mid -1;
                }
            }
        }
        return res;
    }
}
