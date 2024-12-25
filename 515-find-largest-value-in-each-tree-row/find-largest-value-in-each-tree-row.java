/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int solve(List<Integer> maxarr) {
        return Collections.max(maxarr);
    }

    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        List<Integer> ans = new ArrayList<>();
        int h = 0;

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> maxarr = new ArrayList<>();
            while (n-- > 0) {
                TreeNode curr = q.poll();
                maxarr.add(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            ans.add(solve(maxarr));
        }
        return ans;

    }
}