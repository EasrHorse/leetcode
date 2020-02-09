/*24. 两两交换链表中的节点
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

         

        示例:

        给定 1->2->3->4, 你应该返回 2->1->4->3.*/

public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        //使用一个前继节点来指向一对节点交换之后的指向
        if (head == null) {
            return head;
        }
        ListNode pre = head;//前继节点
        ListNode cur = head;//当前节点
        if (cur.next != null) {//即有下一个节点
            head = cur.next;//把当前节点的下一个节点变成头节点,确定好头结点
            while (cur != null && cur.next != null) {//有两个节点可以进行交换
                pre.next = cur.next;//pre.next指向交换节点节点之后的第二个节点
                ListNode next = cur.next.next;//保存下一对节点的开始节点
                //交换节点
                cur.next.next = cur;//把当前节点的下一个节点的next指向当前节点
                cur.next = next;
                //交换完毕，开始下一对节点的赋值
                pre = cur;
                cur = next;

            }
        }
        return head;
    }
    }

