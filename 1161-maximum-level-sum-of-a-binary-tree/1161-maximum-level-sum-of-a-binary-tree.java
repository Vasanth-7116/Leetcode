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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;

        int ans = 0;
        queue.add(root);
        int l =1;
        while(!queue.isEmpty()){
            int sum = 0;
           
            int level = queue.size();
            
            for(int i=0;i<level;i++){
                TreeNode curr = queue.poll();
                sum+=curr.val;
                
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }

            if(sum>max){
                max = sum;
                ans = l;
            }
            l++;
        }
        return ans;
    }
}