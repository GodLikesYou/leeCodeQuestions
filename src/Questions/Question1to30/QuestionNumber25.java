package Questions.Question1to30;

import TitleLibrary.ListNode;

/**
 * 25. K 个一组翻转链表
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 */
class QuestionNumber25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int i = k;
        ListNode[] stack = new ListNode[k];
        ListNode q = head;
        while (k > 0) {
            stack[i - k] = q;
            if (q != null) {
                q = q.next;
            } else {
                return head;
            }
            k--;
        }
        while (k < i - 1) {
            k++;
            stack[i - k].next = stack[i - k - 1];
        }
        stack[0].next = reverseKGroup(q, k + 1);
        return stack[i - 1];
    }
}
