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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int matrix[][] = new int[m][n];
        for(int i=0;i<matrix.length;i++){
            Arrays.fill(matrix[i],-1);
        }
        int toprow=0;
        int bottomrow=m-1;
        int leftcol=0;
        int rightcol=n-1;
        while(head != null){
        for(int col=leftcol;col<=rightcol;col++){
           if(head==null)
            break;
            matrix[toprow][col]=head.val;
            head=head.next;
        }
        toprow++;
        for(int row=toprow;row<=bottomrow;row++){
             if(head==null)
            break;
            matrix[row][rightcol]=head.val;
            head=head.next;
        }
        rightcol--;
        for(int col=rightcol;col>=leftcol;col--){
            if(head==null)
            break;
            matrix[bottomrow][col]=head.val;
            head=head.next;
        }
        bottomrow--;
        for(int row=bottomrow;row>=toprow;row--){
             if(head==null)
            break;
            matrix[row][leftcol]=head.val;
            head=head.next;
        }
        leftcol++;
        }

        return matrix;
    }
    
}