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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> l = new ArrayList<>();
        
            for (int i = 0; i<level; i++) {
                TreeNode curr = queue.poll();
                l.add(curr.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                    
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                
                }
            }
            if(!l.isEmpty()){
                list.add(0,l);
            }
            
        }
        return list;
    }
}