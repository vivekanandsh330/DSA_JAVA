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
    public ListNode reverseList(ListNode head) {

        List<Integer> arr=new ArrayList<>();
        ListNode temp=head;
        while( temp != null){
            arr.add(temp.val);
            temp=temp.next;
        }
       Collections.reverse(arr);
       LinkedList<Integer> linkedList = new LinkedList<>(arr);
       ListNode dummy=new ListNode(0);
       ListNode curr=dummy;
       for(Integer l: linkedList){
        curr.next=new ListNode(l);
        curr=curr.next;
       }
       return dummy.next;
        
      
    }
}