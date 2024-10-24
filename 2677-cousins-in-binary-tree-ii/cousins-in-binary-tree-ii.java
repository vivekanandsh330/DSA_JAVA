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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        List<Integer> ss=new ArrayList<>();
        int h=0;
        while(!q.isEmpty()){
            int n=q.size();
            int currs=0;
            while(n-->0){
                TreeNode currn=q.poll();
                currs+=currn.val;
                if(currn.left!=null){
                    q.add(currn.left);
                }
                if(currn.right!=null){
                    q.add(currn.right);
                }
            }
            h++;
            ss.add(currs);
        }
        q.add(root);
        root.val=0;
        int i=1;
        while(!q.isEmpty()){
            int l=q.size();
            while(l-->0){
                TreeNode currno=q.poll();
                int siblingsum = currno.left !=null ? currno.left.val:0;
                siblingsum += currno.right !=null ? currno.right.val:0;
                if(currno.left != null){
                    currno.left.val=ss.get(i)-siblingsum;
                    q.add(currno.left);
                }
                if(currno.right!= null){
                    currno.right.val=ss.get(i)-siblingsum;
                    q.add(currno.right);
                }
            }
            i++;
        }
        return root;
        
    }
   
}