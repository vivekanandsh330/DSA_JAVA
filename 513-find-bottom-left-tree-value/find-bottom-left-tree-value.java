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
        int maxdepth=-1;
        int leftmostval=0;
        void dfs(TreeNode root,int currdepth){
        if(root == null){
            return;
        }
        if(currdepth > maxdepth){
            maxdepth=currdepth;
            leftmostval=root.val;
        }
        dfs(root.left,currdepth+1);
        dfs(root.right,currdepth+1);
    }
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return leftmostval;
    }
}