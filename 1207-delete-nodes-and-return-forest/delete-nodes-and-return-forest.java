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
    TreeNode solve(TreeNode root,Set<Integer> st,List<TreeNode> ans){
        if(root == null){
            return null;
        }
        root.left=solve(root.left,st,ans);
        root.right=solve(root.right,st,ans);

        if(st.contains(root.val)){
            if(root.left != null){
                ans.add(root.left);
            }
            if(root.right != null){
                ans.add(root.right);
            }
            return null;
        }
        else{
            return root;
        }

    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans=new ArrayList<>();
        Set<Integer> st=new HashSet<>();
        for(int i: to_delete){
            st.add(i);
        }

        solve(root,st,ans);
        if(!st.contains(root.val)){
            ans.add(root);
        }
        return ans;
    }
}