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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> q1=new ArrayDeque<>();
        q1.add(root);
        while(!q1.isEmpty()){
            int n=q1.size();
            TreeNode node=null;
            while(n-->0){
                node=q1.poll();
                if(node.left != null){
                    q1.add(node.left);
                }
                if(node.right != null){
                    q1.add(node.right);
                }
            }
            ans.add(node.val);
        }
        return ans;
    }
}