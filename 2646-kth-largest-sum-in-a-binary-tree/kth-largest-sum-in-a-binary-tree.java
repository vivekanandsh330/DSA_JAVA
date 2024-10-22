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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        if(root == null){
            return 0;
        }
        List<Long> ssum=new ArrayList<>();
        while(!q.isEmpty()){
            int n=q.size();
            long sum=0;
            while(n-->0){
                TreeNode currn=q.remove();
                sum+=currn.val;
                if(currn.left !=null){
                    q.add(currn.left);
                }
                if(currn.right!=null){
                    q.add(currn.right);
                }
            }
            ssum.add(sum);
        }
            Collections.sort(ssum);
            int l=ssum.size();
            if(k>l){
                return -1;
            }
            return ssum.get(l-k);
    }
}