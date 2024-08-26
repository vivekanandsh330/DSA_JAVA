/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        if(root == null){
            List<Integer> baseList=new ArrayList<>();
            return baseList;
        }

        List<Integer> list=new ArrayList<>();
        for(Node child: root.children){
            List<Integer> clist=postorder(child);
            for(int x: clist){
                list.add(x);
            }
            
        }
        list.add(root.val);
        return list;
    }
}