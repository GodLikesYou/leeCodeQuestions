package Questions.Question1to30;

import TitleLibrary.ListNode;

/**
 *24. 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 *
 * 思路
 * 标签：链表
 * 本题的递归和非递归解法其实原理类似，都是更新每两个点的链表形态完成整个链表的调整
 * 其中递归解法可以作为典型的递归解决思路进行讲解
 * 递归写法要观察本级递归的解决过程，形成抽象模型，因为递归本质就是不断重复相同的事情。而不是去思考完整的调用栈，一级又一级，无从下手。如图所示，我们应该关注一级调用小单元的情况，也就是单个f(x)。
 *
 * 作者：guanpengchn
 *
 * 来源：力扣（LeetCode）
 *
 *
 * 其中我们应该关心的主要有三点：
 *
 * 返回值
 * 调用单元做了什么
 * 终止条件
 * 在本题中：
 *
 * 返回值：交换完成的子链表
 * 调用单元：设需要交换的两个点为 head 和 next，head 连接后面交换完成的子链表，next 连接 head，完成交换
 * 终止条件：head 为空指针或者 next 为空指针，也就是当前无节点或者只有一个节点，无法进行交换
 * 代码
 *
 * 作者：guanpengchn
 *
 * 来源：力扣（LeetCode）
 *
 */
class QuestionNumber24 {
    public ListNode swapPairs(ListNode head){
        if (head ==null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
