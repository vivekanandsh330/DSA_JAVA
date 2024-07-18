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

    void mGraph(TreeNode root,TreeNode prev,Map<TreeNode, List<TreeNode>> adj,Set<TreeNode> ln){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            ln.add(root);
        }
        if(prev != null){
            adj.computeIfAbsent(root,k -> new ArrayList<>()).add(prev);
            adj.computeIfAbsent(prev,k -> new ArrayList<>()).add(root);
        }
        mGraph(root.left,root,adj,ln);
        mGraph(root.right,root,adj,ln);

    }
    public int countPairs(TreeNode root, int distance) {
       Map<TreeNode, List<TreeNode>> adj=new HashMap<>();
       Set<TreeNode> ln=new HashSet<>();
       mGraph(root,null,adj,ln);
       int count = 0;
       for(TreeNode l: ln){
        Queue<TreeNode> q=new ArrayDeque<>();
        Set<TreeNode> v=new HashSet<>();
        q.add(l);
        v.add(l);
        for(int i=0;i <= distance;i++){
            int size =q.size();
            while(size-- >0){
                TreeNode c=q.poll();
                if(c != l && ln.contains(c)){
                    count++;
                }
                for(TreeNode n:adj.getOrDefault(c,new ArrayList<>())){
                    if(!v.contains(n)){
                        q.add(n);
                        v.add(n);
                    }
                }
            }
        }
    }
    return count/2;
    }
}