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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean rev = false;
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<level;i++){
                if(!rev){
                    TreeNode curr = queue.removeFirst();
                    list.add(curr.val);
                    if(curr.left!=null){
                        queue.addLast(curr.left);
                    }
                    if(curr.right!=null){
                        queue.addLast(curr.right);
                    }
                }
                if(rev){
                    TreeNode curr = queue.removeLast();
                    list.add(curr.val);
                    if(curr.right!=null){
                        queue.addFirst(curr.right);
                    }
                    if(curr.left!=null){
                        queue.addFirst(curr.left);
                    }
                }
            }
            result.add(list);
            rev = !rev;
        }
        return result;
    }
}