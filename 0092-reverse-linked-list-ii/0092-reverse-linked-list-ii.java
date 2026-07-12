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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;
        int pos =1;
        ListNode before = null;
        if(head ==null)
            return null;
        if(left==right)
            return head;

        while(temp!=null)
        {
            if(pos<left)
            {
                before = temp;
                temp = temp.next;
                pos++;
                continue;
            }
            int times = right-left+1;
            ListNode curr = temp;
            ListNode prev = null;
            while(times!=0)
            {
                ListNode next = curr.next;
                curr.next = prev;
                prev =curr;
                curr = next;
                times--;
            }
            temp.next = curr;
            if(before!=null)
            {
                before.next = prev;
                return head;
            }
            return prev;

        }
        return head;
        
    }
}