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
    void postOrder(TreeNode node,List<Integer> list){
        if(node == null){
            return;
        }
        postOrder(node.left,list);
        postOrder(node.right,list);
        list.add(node.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        postOrder(root,res);
        return res;
    }
}