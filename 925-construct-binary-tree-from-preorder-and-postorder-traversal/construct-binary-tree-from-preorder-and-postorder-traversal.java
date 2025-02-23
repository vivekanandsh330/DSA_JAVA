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
   private int idx1=0;
   private int idx2=0;
   private TreeNode solve(int[] preorder, int[] postorder){
        TreeNode root=new TreeNode(preorder[idx1++]);
        if(root.val != postorder[idx2]){
            root.left=solve(preorder,postorder);
        }
        if(root.val != postorder[idx2]){
            root.right=solve(preorder,postorder);
        }
        idx2++;
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return solve(preorder,postorder);
    }
}