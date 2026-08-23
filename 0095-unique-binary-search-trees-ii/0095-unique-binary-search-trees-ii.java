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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateSubtrees(1, n);
    }
    
    private List<TreeNode> generateSubtrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateSubtrees(start, i - 1);
            List<TreeNode> rightTrees = generateSubtrees(i + 1, end);
            
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currentTree = new TreeNode(i);
                    currentTree.left = left;
                    currentTree.right = right;
                    allTrees.add(currentTree);
                }
            }
        }
        
        return allTrees;
    }
}