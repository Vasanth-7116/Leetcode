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
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        queue.add(root);
        list.add(root.val);
        while(!queue.isEmpty()){
            int level = queue.size();
           
            for(int i=0;i<level;i++){
                TreeNode curr = queue.poll();
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
            if(!queue.isEmpty()){
                list.add(queue.getLast().val);
            }
            
        }
        return list;
    }
}