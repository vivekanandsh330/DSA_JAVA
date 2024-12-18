/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    TreeNode xparent = null;
    TreeNode yparent = null;
    int xdepth = -1;
    int ydepth = -2;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        solve(root,x,y,0,null);
       return ((xparent != yparent) && (xdepth == ydepth));
    }
    void solve(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if (root == null) {
            return;
        }
        else if(root.val == x){
            xparent=parent;
            xdepth=depth;
        }
        else if(root.val == y){
            yparent=parent;
            ydepth=depth;
        }
        else {
            solve(root.left,x,y,depth+1,root);
            solve(root.right,x,y,depth+1,root);
        }
    }
}