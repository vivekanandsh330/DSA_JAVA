/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ArrayList<Integer> ans=new ArrayList<>();
        ArrayList<Integer> res=new ArrayList<>();
        ListNode temp=head.next;
        while(temp != null){
            ans.add(temp.val);
            temp=temp.next;
        }
        int sum=0;
        for(int i=0;i<ans.size();i++){
            if(ans.get(i)!= 0){
                sum += ans.get(i);
            }
            else{
                if(sum >0){  
                res.add(sum);
                sum=0;
            }
            }
        }
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        for(Integer i: res){
            curr.next=new ListNode(i);
            curr=curr.next;
        }
        return dummy.next;
    }
}