package Questions.Question31To60;

/**
 * 33. 搜索旋转排序数组
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 方法：二分查找
 * 二分查找法的模板我写在了「力扣」第 35 题：“搜索插入位置”的题解《特别好用的二分查找法模板（Python 代码、Java 代码）》。
 * <p>
 * 注意：以下代码中的边界部分，是“小于等于”还是“小于”，是“大于等于”还是“等于”，需要让两个不同情况的分支逻辑一样，二分算法才有效，这一点我说得可能不太清楚，请大家自行体会。
 * <p>
 * <p>
 * 作者：liweiwei1419
 * <p>
 * 来源：力扣（LeetCode）
 */
class QuestionNumber33 {
    /**
     * 情况 1：中间元素和右边界比较
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;

            if (nums[mid] > nums[right]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    /**
     * 情况 2：中间元素和左边界比较
     */
    public int search1(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right +1) >>> 1;

            if (nums[mid] > nums[left]){
                if (nums[left] <= target && target < nums[mid]){
                    right = mid -1;
                }else {
                    left = mid;
                }
            }else {
                if (nums[mid] <= target && target <= nums[right]){
                    left = mid;
                }else {
                    right = mid -1;
                }
            }
        }
        if (nums[left] == target){
            return left;
        }
        return -1;
    }
}
