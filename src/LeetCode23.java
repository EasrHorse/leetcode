/*
23. 合并K个排序链表
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

        示例:

        输入:
        [
          1->4->5,
          1->3->4,
          2->6
        ]
        输出: 1->1->2->3->4->4->5->6
*/

public class LeetCode23 {
  /*  如果 lists 不是空，就弹出一个最小的结点。

    时间复杂度是最高的：O(nk) 的时间， O(1) 的空间*/
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode root = new ListNode(0);
            ListNode cursor = root;

            while (!isEmpty(lists)) {
                // 选择一个最小的结点
                cursor.next = popMin(lists);
                cursor = cursor.next;
            }

            return root.next;
        }

        private boolean isEmpty(ListNode[] lists) {
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) return false;
            }

            return true;
        }

        private ListNode popMin(ListNode[] lists) {
            ListNode min = null;
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) continue;

                if (min == null || lists[i].val < min.val) {
                    min = lists[i];
                    index = i;
                }
            }

            lists[index] = min.next;
            return min;
        }
    }
