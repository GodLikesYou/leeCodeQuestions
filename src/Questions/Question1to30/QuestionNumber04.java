package Questions.Question1to30;

/**
 * 4.寻找两个有序数组的中位数
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 */
class QuestionNumber04 {
    public double findMedianSortedArrays01(int[] nums1,int[] nums2){
        /**
         * 解法一
         * 简单粗暴，先将两个数组合并，两个有序数组的合并也是归并排序中的一部分。然后根据奇数，还是偶数，返回中位数。
         * 时间复杂度：遍历全部数组 (m+n)(m+n)
         *
         * 空间复杂度：开辟了一个数组，保存合并后的两个数组 O(m+n)O(m+n)
         */
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m+n];
        if (m == 0){
            if (n % 2 == 0){
                return (nums2[n/2-1]+nums2[n/2])/2.0;
            }else{
                return nums2[n/2];
            }
        }
        if (n == 0){
            if (m % 2 == 0){
                return (nums1[m/2-1]+nums1[m/2])/2.0;
            }else{
                return nums1[m/2];
            }
        }

        int count = 0;
        int i = 0,j = 0;
        while (count != (m+n)){
            if (i == m){
                while (j != n){
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (nums1[i]<nums2[j]){
                nums[count++] = nums1[i++];
            }else{
                nums[count++] = nums2[j++];
            }
        }
        if (count % 2 == 0){
            return (nums[count/2-1]+nums[count/2])/2.0;
        }else{
            return nums[count/2];
        }
    }
    public double findMedianSortedArrays02(int[] A,int[] B){
        /**
         * 解法二
         * 其实，我们不需要将两个数组真的合并，我们只需要找到中位数在哪里就可以了。
         *
         * 开始的思路是写一个循环，然后里边判断是否到了中位数的位置，到了就返回结果，但这里对偶数和奇数的分类会很麻烦。当其中一个数组遍历完后，出了 for 循环对边界的判断也会分几种情况。总体来说，虽然复杂度不影响，但代码会看起来很乱。
         *
         * 首先是怎么将奇数和偶数的情况合并一下。
         *
         * 用 len 表示合并后数组的长度，如果是奇数，我们需要知道第 （len+1）/2 个数就可以了，如果遍历的话需要遍历 int(len/2 ) + 1 次。如果是偶数，我们需要知道第 len/2和 len/2+1 个数，也是需要遍历 len/2+1 次。所以遍历的话，奇数和偶数都是 len/2+1 次。
         *
         * 返回中位数的话，奇数需要最后一次遍历的结果就可以了，偶数需要最后一次和上一次遍历的结果。所以我们用两个变量 left 和 right，right 保存当前循环的结果，在每次循环前将 right 的值赋给 left。这样在最后一次循环的时候，left 将得到 right 的值，也就是上一次循环的结果，接下来 right 更新为最后一次的结果。
         *
         * 循环中该怎么写，什么时候 A 数组后移，什么时候 B 数组后移。用 aStart 和 bStart 分别表示当前指向 A 数组和 B 数组的位置。如果 aStart 还没有到最后并且此时 A 位置的数字小于 B 位置的数组，那么就可以后移了。也就是aStart＜m&&A[aStart]< B[bStart]。
         *
         * 但如果 B 数组此刻已经没有数字了，继续取数字 B[ bStart ]，则会越界，所以判断下 bStart 是否大于数组长度了，这样 || 后边的就不会执行了，也就不会导致错误了，所以增加为 aStart＜m&&(bStart)>= n||A[aStart]<B[bStart])。
         * 时间复杂度：遍历 len/2+1 次，len=m+n，所以时间复杂度依旧是 O(m+n)O(m+n)。
         *
         * 空间复杂度：我们申请了常数个变量，也就是 m，n，len，left，right，aStart，bStart 以及 i。
         *
         * 总共 8 个变量，所以空间复杂度是 O(1）O(1）。
         *
         */
        int m = A.length;
        int n = B.length;
        int len = m+n;
        int left = -1,right = -1;
        int aStart = 0,bStart = 0;
        for (int i = 0; i < len; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])){
                right = A[aStart++];
            }else{
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0){
            return (left + right)/2.0;
        }else{
            return right;
        }

    }
}
