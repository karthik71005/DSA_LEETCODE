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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode leftNode = head;

        for(int i=1;i<k;i++)
        {
            leftNode = leftNode.next;
        }
        ListNode curr = leftNode;
        ListNode temp = head;
        while(curr.next!=null)
        {
            curr= curr.next;
            temp = temp.next;
        }
        int val = leftNode.val;
        leftNode.val = temp.val;
        temp.val =val;

        return head;
        
        
    }
}