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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        // Move prev to the node just before the 'left' position
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        
        ListNode current = prev.next;
        ListNode nextNode = current.next;
        
        // Reverse the sublist
        for (int i = 0; i < right - left; i++) {
            current.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
            nextNode = current.next;
        }
        
        return dummy.next;
    }
}