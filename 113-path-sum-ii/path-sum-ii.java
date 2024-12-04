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
    void inorder(TreeNode root, int targetSum,List<Integer> temp,int sum, List<List<Integer>> ans){
        if(root == null){
            return;
        }
        sum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == targetSum){
            ans.add(new ArrayList<>(temp));
            }
        }
        inorder(root.left,targetSum,temp,sum,ans);
        inorder(root.right,targetSum,temp,sum,ans);
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> temp=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        int sum=0;
        inorder(root,targetSum,temp,sum,ans);
        return ans;
    }
}