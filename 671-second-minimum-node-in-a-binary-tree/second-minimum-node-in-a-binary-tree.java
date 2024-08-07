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
    public int findSecondMinimumValue(TreeNode root) {
        HashSet<Integer> hs=new HashSet<>();
        inOrder(root,hs);
        int k=0;
        int ans[]=new int[hs.size()];
        for(var i: hs){
            ans[k++]=i;
        }
        Arrays.sort(ans);
        if(ans.length == 1){
            return -1;
        }
        return ans[1];
        
    }
    void inOrder(TreeNode root, HashSet<Integer> hs){
        if(root.left !=null){
            inOrder(root.left,hs);
        }
        hs.add(root.val);
        if(root.right != null){
            inOrder(root.right,hs);
        }
    }
}