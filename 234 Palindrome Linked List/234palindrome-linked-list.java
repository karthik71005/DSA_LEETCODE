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
    public boolean isPalindrome(ListNode head) {
        if(head == null ||head.next == null)
            return true;

        ListNode slow=head;
        ListNode fast =head;
        while(fast!=null && fast.next!=null)
        {
            slow =slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode curr = slow;
        while(curr!=null)
        {
            ListNode temp = curr.next;
            curr.next =prev;
            prev=curr;
            curr=temp;
        }
        ListNode fH=head;
        ListNode sH=prev;
        while(sH!=null)
        {
            if(fH.val != sH.val)
                return false;
            fH=fH.next;
            sH=sH.next;
        }
        return true;

        
    }
}