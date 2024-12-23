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
    int minswap(List<Integer> lis) {
        int swaps = 0;
        List<Integer> sortLis = new ArrayList<>(lis);
        Collections.sort(sortLis);

        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < lis.size(); i++) {
            hm.put(lis.get(i), i);
        }
        for (int i = 0; i < lis.size(); i++) {
            if (lis.get(i).equals(sortLis.get(i))) {
                continue;
            }
            int curridx = hm.get(sortLis.get(i));
            hm.put(lis.get(i), curridx);
            hm.put(lis.get(curridx), i);
            Collections.swap(lis, curridx, i);
            swaps++;
        }
        return swaps;
    }

    public int minimumOperations(TreeNode root) {
        int count=0;
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> lis=new ArrayList<>();
            while(n-->0){
                TreeNode poll=q.poll();
                lis.add(poll.val);
                if(poll.left !=null){
                    q.add(poll.left);
                }
                if(poll.right !=null){
                    q.add(poll.right);
                }

            }
            count +=minswap(lis);
        }
        return count;
    }
}