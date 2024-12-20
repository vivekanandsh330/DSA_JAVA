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
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return root;
        }
        int d = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            List<TreeNode> ln = new ArrayList<>();
            while (n-- > 0) {
                TreeNode curr = q.poll();
                ln.add(curr);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            if (d % 2 == 1) {
                int i = 0;
                int j = ln.size() - 1;
                while (i < j) {
                    int temp = ln.get(i).val;
                    ln.get(i).val = ln.get(j).val;
                    ln.get(j).val = temp;
                    i++;
                    j--;
                }
            }
            d++;
        }
        return root;
    }
}