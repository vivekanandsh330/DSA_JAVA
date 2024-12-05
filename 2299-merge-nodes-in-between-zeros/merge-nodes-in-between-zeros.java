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
        ListNode n1=head.next;
        ListNode n2=n1;
        while(n2 != null){
            int sum=0;
            while(n2 != null && n2.val != 0){
                sum += n2.val;
                n2=n2.next;
            }
            n1.val=sum;
            n2=n2.next;
            n1.next=n2;
            n1=n1.next;
        }
        return head.next;
    }
}