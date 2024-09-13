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
    void  makeAdj(TreeNode curr,int parent,Map<Integer,List<Integer>> adj){
        if(curr == null){
            return;
        }
        if(parent !=-1){
          adj.computeIfAbsent(curr.val,k -> new ArrayList<>()).add(parent);
        }
        if(curr.left != null){
          adj.computeIfAbsent(curr.val,k-> new ArrayList<>()).add(curr.left.val);
        }
        if(curr.right != null){
          adj.computeIfAbsent(curr.val,k-> new ArrayList<>()).add(curr.right.val);
        }
        makeAdj(curr.left,curr.val,adj);
        makeAdj(curr.right,curr.val,adj);
    }
    
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        makeAdj(root,-1,adj);
        Queue<Integer> q=new ArrayDeque<>();
        q.add(start);
        Set<Integer> vis=new HashSet<>();
        vis.add(start);
        int time=0;
        while(!q.isEmpty()){
            int n=q.size();
            while(n-->0){
                int curr=q.poll();
                for(int nigh: adj.getOrDefault(curr,Collections.emptyList())){
                    if(!vis.contains(nigh)){
                        q.add(nigh);
                        vis.add(nigh);
                    }
                }
            }
            time++;
        }
        return time-1;
    }
}