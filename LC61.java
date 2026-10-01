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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Compute length and find the tail
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Handle k >= length
        k = k % length;
        if (k == 0) return head;

        // Step 3: Make it a circular list
        tail.next = head;

        // Step 4: Find the new tail: (length - k - 1) steps from head
        int stepsToNewTail = length - k;
        ListNode newTail = tail; // starting at tail, moving 'stepsToNewTail' times lands on the new tail
        while (stepsToNewTail > 0) {
            newTail = newTail.next;
            stepsToNewTail--;
        }

        // Step 5: Break the ring and get new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}