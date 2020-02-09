/*
1.25. K 个一组翻转链表
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

        k 是一个正整数，它的值小于或等于链表的长度。

        如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

        示例 :

        给定这个链表：1->2->3->4->5

        当 k = 2 时，应当返回: 2->1->4->3->5

        当 k = 3 时，应当返回: 3->2->1->4->5
*/

public class LeetCode25 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            int len = 0;
            ListNode tmp = head;
            //计算链表长度
            while (tmp != null) {
                len++;
                tmp = tmp.next;
            }
            len /= k;
            //当没有要反转链表的时候直接返回
            if (len == 0)
                return head;
            ListNode cur = head;
            ListNode tail = cur;
            for (int i = 0; i < len; i++) {
                //newlist表示分离出来的链表
                ListNode newlist = null;
                //newhead表示分离出来链表的头
                ListNode newhead = cur;
                int count = k;
                //反转分离出来的链表
                while (count > 0) {
                    tmp = cur;
                    cur = cur.next;
                    tmp.next = newlist;
                    newlist = tmp;
                    count--;
                }
                //只有当第一次反转链表时不用将首尾相连，因为只有头，所以只需要将链表原本的头
                //更新即可，在后面的链表反转中，则需要将分离出来的链表与之前的链表首尾相连
                if (i == 0) {
                    head = newlist;
                } else {
                    tail.next = newlist;
                    tail = newhead;
                }
            }
            //链接链表剩余的部分
            while (cur != null) {
                tail.next = cur;
                tail = tail.next;
                cur = cur.next;
            }
            //返回头节点
            return head;
        }
    }
}