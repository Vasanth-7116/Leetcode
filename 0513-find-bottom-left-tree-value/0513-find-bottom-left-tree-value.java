/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode current = null;
        
        while (!queue.isEmpty()) {
            current = queue.poll();
            
            // Important: add RIGHT child first, then LEFT child
            if (current.right != null) {
                queue.offer(current.right);
            }
            if (current.left != null) {
                queue.offer(current.left);
            }
        }
        
        // The last node processed will be the leftmost node of the last row
        return current.val;
    }
}