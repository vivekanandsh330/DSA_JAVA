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
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        int depth=1;
        while(!q.isEmpty()){
            int n=q.size();
            TreeNode node=null;
            while(n-->0){
                node=q.poll();
                if(node.right == null && node.left == null){
                    return depth;
                }
                if(node.right != null){
                    q.add(node.right);
                }
                if(node.left != null){
                    q.add(node.left);
                }
            }
            depth++;
        }
        return -1;
    }
}