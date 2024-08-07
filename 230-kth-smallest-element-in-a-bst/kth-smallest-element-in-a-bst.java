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
    int k=0;
    Set<Integer> hs=new HashSet();
    public int kthSmallest(TreeNode root, int k) {
      
        inOrder(root,k);
        int j=0;
        int arr[]=new int[hs.size()];
        for(int l: hs){
            arr[j++]=l;
        }
        Arrays.sort(arr);
        return arr[k-1];
    }
     void inOrder(TreeNode root,int k){
        if(root.left != null){
            inOrder(root.left,k);
        }
        hs.add(root.val);
        if(root.right != null){
            inOrder(root.right,k);
        }

     }
}