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
    int pos=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pos=postorder.length-1;
        TreeNode root=constructBT(inorder,postorder,0,inorder.length-1);
        return root;
    }

    TreeNode constructBT(int[] inorder, int[] postorder,int s,int e){
        if(pos<0 || s>e){
            return null;
        }
        int val=postorder[pos];
        TreeNode node=new TreeNode(val);
        pos--;
        int i=s;
        for(;i<e;i++){
            if(val == inorder[i]){
                break;
            }
        }
        TreeNode right=constructBT(inorder,postorder,i+1,e);
        TreeNode left=constructBT(inorder,postorder,s,i-1);
        node.right=right;
        node.left=left;
        return node;
    }
}