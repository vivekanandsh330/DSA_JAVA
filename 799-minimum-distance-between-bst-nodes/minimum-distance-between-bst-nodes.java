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
    int ans=0;
    int prev=0;
    int min=Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        ans=min;
        prev=min;
        dfs(root);
        return ans;
    }

    void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        ans=Math.min(ans,Math.abs(root.val-prev));
        prev=root.val;
        dfs(root.right);
    }
}