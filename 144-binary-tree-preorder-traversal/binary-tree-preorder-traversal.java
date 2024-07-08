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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        preOrder(root,ans);
        return ans;
    }
    void preOrder(TreeNode noot,List<Integer> ans){
        if(noot == null){
            return;
    }
    ans.add(noot.val);
    preOrder(noot.left,ans);
    preOrder(noot.right,ans);
    }
}