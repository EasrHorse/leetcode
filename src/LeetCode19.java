/*
19. 删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

        示例：

        给定一个链表: 1->2->3->4->5, 和 n = 2.

        当删除了倒数第二个节点后，链表变为 1->2->3->5.
}
*/
/*思路
定义两个指针，第一个指针进行遍历，第二个指针为第一个指针的前n个节点。这样就能做到一次遍历即可删除指定的倒数第n个节点*/
public class LeetCode19 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head==null||head.next==null&&n==1)
                return null;
            ListNode node = head;
            ListNode delete = null;
            while(node!=null){
                if(n>0)n--;
                else if(delete==null)
                    delete = head;
                else
                    delete = delete.next;
                node = node.next;
            }
            if(delete!=null)
                delete.next = delete.next.next;
            else if(n==0)
                head = head.next;
            return head;
        }
    }