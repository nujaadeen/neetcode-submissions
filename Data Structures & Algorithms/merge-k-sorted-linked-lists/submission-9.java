/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null  || lists.length == 0) {
            return null;
        }

        while (lists.length > 1) {
            int newSize = (lists.length + 1) / 2;
            ListNode[] mergedList = new ListNode[newSize];

            int index = 0;
            for (int i = 0; i < lists.length; i += 2) {
                ListNode head1 = lists[i];
                ListNode head2 = (i + 1) < lists.length ? lists[i+1] : null;

                mergedList[index] = (mergeTwoLists(head1, head2));
                index++;
            }

            lists = mergedList;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();

        ListNode tail = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        tail.next = head1 != null ? head1 : head2;

        return dummy.next;
    }
}
