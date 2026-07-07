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

        while (itr1 != null && itr2 != null) {
            int sum = itr1.val + itr2.val + carry;
            int nodeVal = sum % 10;
            carry = sum / 10;

            itr3.next = new ListNode(nodeVal);

            itr1 = itr1.next;
            itr2 = itr2.next;
            itr3 = itr3.next;
        }

        while (itr1 != null) {
            int sum = itr1.val + carry;
            int nodeVal = sum % 10;
            carry = sum / 10;

            itr3.next = new ListNode(nodeVal);

            itr1 = itr1.next;
            itr3 = itr3.next;
        }

        while (itr2 != null) {
            int sum = itr2.val + carry;
            int nodeVal = sum % 10;
            carry = sum / 10;

            itr3.next = new ListNode(nodeVal);

            itr2 = itr2.next;
            itr3 = itr3.next;
        }

        if (carry != 0) {
            itr3.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
