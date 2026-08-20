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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculateDepth(root);
        return maxDiameter;
    }

    int calculateDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = calculateDepth(root.left);
        int right = calculateDepth(root.right);
        maxDiameter = Math.max(maxDiameter,left+right);
        return Math.max(left,right)+1;
    }
}