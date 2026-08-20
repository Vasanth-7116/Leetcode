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
class Solution {
    Integer prev = null;
    int count = 1;
    int maxCount = 0;
    java.util.List<Integer> modes = new java.util.ArrayList<>();
    
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }
    
    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        
        inorder(node.left);
        
        if (prev != null) {
            if (node.val == prev) {
                count++;
            } else {
                count = 1;
            }
        }
        
        if (count > maxCount) {
            maxCount = count;
            modes.clear();
            modes.add(node.val);
        } else if (count == maxCount) {
            modes.add(node.val);
        }
        
        prev = node.val;
        
        inorder(node.right);
    }
}