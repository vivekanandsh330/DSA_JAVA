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
    int level[]=new int[1000001];
    int height[]=new int[100001];
    int levelmax[]=new int[100001];
    int levelsecmax[]=new int[100001];
    int findheight(TreeNode root,int l){
        if(root == null){
            return 0;
        }
        level[root.val]=l;
        height[root.val]=Math.max(findheight(root.left,l+1),findheight(root.right,l+1))+1;
        if(levelmax[l]<height[root.val]){
            levelsecmax[l]=levelmax[l];
            levelmax[l]=height[root.val];
        }
        else if(levelsecmax[l]<height[root.val]){
            levelsecmax[l]=height[root.val];
        }
        return height[root.val];
    }
    public int[] treeQueries(TreeNode root, int[] queries) {
        findheight(root,0);
        int ans[]=new int[queries.length];
       for (int i = 0; i < queries.length; i++) {
           int n = queries[i];
           int L=level[n];
           int tempans=L+(levelmax[L]==height[n] ? levelsecmax[L]:levelmax[L])-1;
           ans[i]=tempans;
        }
        return ans;
    }
}