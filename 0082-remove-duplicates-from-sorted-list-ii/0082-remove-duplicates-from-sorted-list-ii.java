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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode current = head;
        
        while (current != null) {
            // Check if it's a beginning of duplicates sublist
            if (current.next != null && current.val == current.next.val) {
                // Move till the end of duplicates sublist
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                // Skip all duplicates
                prev.next = current.next;
            } else {
                // No duplicate, move prev pointer
                prev = prev.next;
            }
            // Move current pointer
            current = current.next;
        }
        
        return dummy.next;
    }
}