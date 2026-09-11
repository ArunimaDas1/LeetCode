ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;  // Q2
    
    ListNode second = head.next;                          // this is "2"
    head.next = swapPairs(second.next);                   // Q3: trust the box on "3->4"
    second.next = head;                                    // Q4: attach 2 -> 1
    
    return second;                                         // 2 is new front
}public class LC24 {

}
