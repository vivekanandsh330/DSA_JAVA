/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode,TreeNode> parent=new HashMap<>();
    void inorder(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left != null){
            parent.put(root.left,root);
        }
        inorder(root.left);
        if(root.right != null){
            parent.put(root.right,root);
        }
        inorder(root.right);
    }
    void collectkDistanceNode(TreeNode target,int k,List<Integer> ans) {
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(target);
        Set<Integer> vis=new HashSet<>();
        vis.add(target.val);
        while(!q.isEmpty()){
            int size=q.size();
            if(k==0){
                break;
            }
            while(size-- !=0){
                TreeNode curr=q.poll();

                if(curr.left != null && !vis.contains(curr.left.val)){
                    q.add(curr.left);
                    vis.add(curr.left.val);
                }
                if(curr.right != null && !vis.contains(curr.right.val)){
                    q.add(curr.right);
                    vis.add(curr.right.val);
                }
                if(parent.containsKey(curr) && !vis.contains(parent.get(curr).val)){
                    q.add(parent.get(curr));
                    vis.add(parent.get(curr).val);
                }
            }
            k--;
        }
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {


        List<Integer> ans=new ArrayList<>();
        
        inorder(root);

        collectkDistanceNode(target,k,ans);
        return ans;
        
        
    }
}