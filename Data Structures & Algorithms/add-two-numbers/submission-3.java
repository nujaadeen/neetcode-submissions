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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode itr1 = l1, itr2 = l2, itr3 = dummy;

        int carry = 0;

        while (itr1 != null || itr2 != null) {
            int val1 = 0;
            int val2 = 0;

            if (itr1 != null) {
                val1 = itr1.val;
                itr1 = itr1.next;
            }

            if (itr2 != null) {
                val2 = itr2.val;
                itr2 = itr2.next;
            }

            int sum = val1 + val2 + carry;
            int nodeVal = sum % 10;
            carry = sum / 10;

            itr3.next = new ListNode(nodeVal);
            itr3 = itr3.next;
        }


        if (carry != 0) {
            itr3.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
