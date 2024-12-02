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
    HashMap<Integer, Integer> hm = new HashMap<>();
    int maxfre = 0;

    int postorder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = postorder(root.left);
        int r = postorder(root.right);
        int sum = l + r + root.val;
        hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        maxfre = Math.max(maxfre, hm.get(sum));
        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        postorder(root);

        List<Integer> arr = new ArrayList<>();
        for (int i : hm.keySet()) {
            if (hm.get(i) == maxfre) {
                arr.add(i);
            }
        }
        int ans[] = new int[arr.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
}