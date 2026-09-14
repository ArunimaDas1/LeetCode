public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // 1 step forward
            fast = fast.next.next;   // 2 steps forward

            if (slow == fast) {
                return true; // Cycle detected
            }
        }

        return false; // Fast reached end of list
    }
}