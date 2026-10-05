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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // Save head of even list to connect later

        while (even != null && even.next != null) {
            odd.next = even.next; // Link next odd node
            odd = odd.next;       // Move odd forward

            even.next = odd.next; // Link next even node
            even = even.next;     // Move even forward
        }

        // Connect the end of odd list to the head of even list
        odd.next = evenHead;

        return head;
    }
}