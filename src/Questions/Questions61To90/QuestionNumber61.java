package Questions.Questions61To90;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */

import TitleLibrary.ListNode;

/**
 * 61. 旋转链表
 *
 * <p>给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * <p>示例 1:
 *
 * <p>输入: 1->2->3->4->5->NULL, k = 2 输出: 4->5->1->2->3->NULL 解释: 向右旋转 1 步: 5->1->2->3->4->NULL 向右旋转
 * 2 步: 4->5->1->2->3->NULL 示例 2:
 *
 * <p>输入: 0->1->2->NULL, k = 4 输出: 2->0->1->NULL 解释: 向右旋转 1 步: 2->0->1->NULL 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL 向右旋转 4 步: 2->0->1->NULL
 *
 * <p>来源：力扣（LeetCode）
 */
class QuestionNumber61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        ListNode p = new ListNode(- 1);
        p.next = head;
        ListNode cur = p;
        ListNode low = p;
        ListNode fast = p;
        int n = 0;
        while (cur.next != null) {
            cur = cur.next;
            ++ n;
        }
        if (n == 0 || k % n == 0) {
            return head;
        }
        n = k % n;
        while (fast.next != null && n > 0) {
            low = low.next;
            fast = fast.next;
        }
        fast.next = p.next;
        p.next = low.next;
        low.next = null;
        return p.next;
    }
}































