class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int firstCrit = -1;
        int prevCrit = -1;
        int minDistance = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode temp = head.next;
        int i = 1; 

        while (temp.next != null) {
            ListNode next = temp.next;
            
            // Check if it's a critical point (either local max or local min)
            if ((temp.val < prev.val && temp.val < next.val) || 
                (temp.val > prev.val && temp.val > next.val)) {
                
                if (firstCrit == -1) {
                    firstCrit = i; // First critical point found
                } else {
                    // Update min distance with the distance to the previous critical point
                    minDistance = Math.min(minDistance, i - prevCrit);
                }
                prevCrit = i; // Update the previous critical point to current index
            }
            
            prev = temp;
            temp = next;
            i++;
        }

        // If we found fewer than 2 critical points
        if (firstCrit == -1 || firstCrit == prevCrit) {
            return new int[]{-1, -1};
        }

        // maxDistance is always the distance between the first and last critical points
        int maxDistance = prevCrit - firstCrit;
        
        return new int[]{minDistance, maxDistance};
    }
}