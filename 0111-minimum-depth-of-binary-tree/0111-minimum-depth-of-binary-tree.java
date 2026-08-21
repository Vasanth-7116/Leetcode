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
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        if(root==null){
            return 0;
        }
        int depth = 1;
        while(!queue.isEmpty()){
            int level = queue.size();
            for(int i=0;i<level;i++){
                TreeNode curr = queue.poll();
                if(curr.left==null&&curr.right==null){
                    return depth;
                }
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
            depth++;
        }
        return -1;
    }
}