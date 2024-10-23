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
    public int maxLevelSum(TreeNode root) {
         if(root == null){
            return 0;
         }
         Queue<TreeNode> q=new ArrayDeque<>();
         q.add(root);
         PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
         int h=1;
         int maxs=Integer.MIN_VALUE;
         while(!q.isEmpty()){
            int n=q.size();
            int currs=0;
            while(n-->0){
                TreeNode currn=q.remove();
                currs+=currn.val;
                if(currn.left != null){
                    q.add(currn.left);
                }
                if(currn.right != null){
                    q.add(currn.right);
                }
            }
            pq.offer(new int[]{currs,h++});
         }
         return pq.peek()[1];
    }
}