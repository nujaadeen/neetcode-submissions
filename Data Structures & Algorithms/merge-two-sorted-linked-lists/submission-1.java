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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();

        ListNode itr1 = list1, itr2 = list2, itrRes = res;

        while (itr1 != null && itr2 != null) {
            if (itr1.val <= itr2.val) {
                itrRes.next = itr1; 
                itr1 = itr1.next;
            } else {
                itrRes.next = itr2; 
                itr2 = itr2.next;
            }
            
            itrRes = itrRes.next;     
        }

        if (itr1 != null) {
            itrRes.next = itr1;
        } else if (itr2 != null){
            itrRes.next = itr2;
        }

        return res.next;
    }
}