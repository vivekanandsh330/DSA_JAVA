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
    public boolean isCousins(TreeNode root, int x, int y) {
       Queue<TreeNode> q=new ArrayDeque<>();
       q.add(root);
       TreeNode xparent=null;
       TreeNode yparent=null;
       while(!q.isEmpty()){
        int n=q.size();
        while(n-->0){
            TreeNode curr=q.poll();
           
            if(curr.left != null){
                q.add(curr.left);
                if(curr.left.val == x){
                    xparent=curr;
                }
                if(curr.left.val == y){
                    yparent=curr;
                }
            }
            if(curr.right != null){
                q.add(curr.right);
                if(curr.right.val == x){
                    xparent=curr;
                }
                if(curr.right.val == y){
                    yparent=curr;
                }
            }

            if(xparent != null && yparent != null){
                return xparent != yparent;
            }


        }
        if( (xparent != null && yparent == null) || (xparent == null && yparent != null)){
            return false;
        }
        
       }
       return false;
    }
}