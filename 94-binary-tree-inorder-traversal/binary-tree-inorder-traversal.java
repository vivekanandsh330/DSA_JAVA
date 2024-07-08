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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        TreeNode curr=root;
        while(curr != null){
            if(curr.left == null){
                ans.add(curr.val);
                curr=curr.right;
            }else{
            TreeNode leftC=curr.left;
            while(leftC.right != null){
                leftC=leftC.right;
            }
            leftC.right=curr;
            TreeNode temp= curr;
            curr=curr.left;
            temp.left=null;
            }
        }
        return ans;
    }
}