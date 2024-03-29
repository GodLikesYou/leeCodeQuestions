package Questions.Question1to30;

import TitleLibrary.ListNode;

/**
 * 21. 合并两个有序链表
 * <p>
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 思路
 * 标签：链表、递归
 * 这道题可以使用递归实现，新链表也不需要构造新节点，我们下面列举递归三个要素
 * 终止条件：两条链表分别名为 l1 和 l2，当 l1 为空或 l2 为空时结束
 * 返回值：每一层调用都返回排序好的链表头
 * 本级递归内容：如果 l1 的 val 值更小，则将 l1.next 与排序好的链表头相接，l2 同理
 * O(m+n)O(m+n)，mm 为 l1的长度，nn 为 l2 的长度
 * <p>
 * 作者：guanpengchn
 * <p>
 * 来源：力扣（LeetCode）
 */
class QuestionNumber21 {
    public ListNode mergetwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val){
            l1.next = mergetwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergetwoLists(l1, l2.next);
            return l2;
        }
    }
}

