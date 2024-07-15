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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> hm=new HashMap<>();
        Set<Integer> cs=new HashSet<>();
       
        for(int description[]:descriptions){
             int p=description[0];
             int c=description[1];
             int isc=description[2];

            if(!hm.containsKey(p)){
                hm.put(p,new TreeNode(p));
            }
            if(!hm.containsKey(c)){
                hm.put(c,new TreeNode(c));
            }
            if(isc == 1){
                hm.get(p).left=hm.get(c);
            }else{
                hm.get(p).right=hm.get(c);
            }
            cs.add(c);
        }
        for(int ban[]: descriptions){
            int p=ban[0];
            if(!cs.contains(p)){
                return hm.get(p);
            }
        }
        return null;
    }
}