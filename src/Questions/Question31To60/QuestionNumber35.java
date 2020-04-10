package Questions.Question31To60;

/**
 * 35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 *
 * 思路
 * 标签：二分查找
 * 如果该题目暴力解决的话需要 O(n)O(n) 的时间复杂度，但是如果二分的话则可以降低到 O(logn)O(logn) 的时间复杂度
 * 整体思路和普通的二分查找几乎没有区别，先设定左侧下标 left 和右侧下标 right，再计算中间下标 mid
 * 每次根据 nums[mid] 和 target 之间的大小进行判断，相等则直接返回下标，nums[mid] < target 则 left 右移，nums[mid] > target 则 right 左移
 * 查找结束如果没有相等值则返回 left，该值为插入位置
 * 时间复杂度：O(logn)O(logn)
 * 二分查找的思路不难理解，但是边界条件容易出错，比如 循环结束条件中 left 和 right 的关系，更新 left 和 right 位置时要不要加 1 减 1。
 *
 * 下面给出两个可以直接套用的模板，记住就好了，免除边界条件出错。
 *
 * 作者：guanpengchn
 *
 * 来源：力扣（LeetCode）
 *
 */
class QuestionNumber35 {
    /**
     * 模板一
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert1(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right)/2;
            if (nums[mid] == target){}
            else if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return 0;
    }

    /**
     * 模板二
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target){
        int left = 0, right = nums.length;
        while (left < right){
            int mid = (left +right)/2;
            if (nums[mid] == target){}
            else if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return 0;
    }

    /**
     * 答案
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target){
        int left = 0, right = nums.length -1;
        while (left <= right){
            int mid = (left + right)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                right =mid -1;
            }
        }
        return left;
    }
}
