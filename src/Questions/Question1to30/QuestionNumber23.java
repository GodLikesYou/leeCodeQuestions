package Questions.Question1to30;

import TitleLibrary.ListNode;

/**
 * 23. 合并K个排序链表
 * <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 */
class QuestionNumber23 {
    public ListNode mergeKlists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return solve(lists, 0, lists.length - 1);
    }

    private ListNode solve(ListNode[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int mid = (left + right) >> 1;
        ListNode lNode = solve(arr, left, mid);
        ListNode rNode = solve(arr, mid + 1, right);
        return merge(lNode, rNode);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        if (node1.val < node2.val) {
            node1.next = merge(node1.next, node2);
            return node1;
        } else {
            node2.next = merge(node1, node2.next);
            return node2;
        }
    }
}
