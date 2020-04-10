package Questions.Question1to30;

import TitleLibrary.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 思路
 * 标签：链表
 * 整体思路是让前面的指针先移动n步，之后前后指针共同移动直到前面的指针到尾部为止
 * 首先设立预先指针 pre，预先指针是一个小技巧，在第2题中进行了讲解
 * 设预先指针 pre 的下一个节点指向 head，设前指针为 start，后指针为 end，二者都等于 pre
 * start 先向前移动n步
 * 之后 start 和 end 共同向前移动，此时二者的距离为 n，当 start 到尾部时，end 的位置恰好为倒数第 n 个节点
 * 因为要删除该节点，所以要移动到该节点的前一个才能删除，所以循环结束条件为 start.next != null
 * 删除后返回 pre.next，为什么不直接返回 head 呢，因为 head 有可能是被删掉的点
 * 时间复杂度：O(n)O(n)
 * <p>
 * 作者：guanpengchn
 * <p>
 * 来源：力扣（LeetCode）
 */
class QuestionNumber19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while (n != 0) {
            start = start.next;
            n--;
        }
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }
}

