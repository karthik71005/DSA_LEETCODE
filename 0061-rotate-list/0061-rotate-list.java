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
    public ListNode rotateRight(ListNode head, int k) { 
        int n=1;
        if(head ==null)
            return head;
        ListNode dummy = head ;

        while(dummy.next!=null){
            n++;
            dummy = dummy.next;
        }
        k = k%n;
        if(k==0)
            return head;
        ListNode temp = head;
        int count =1;
        while(temp!=null)
        {
            if(count == (n-k))
                break;
            count++;
            temp = temp.next;
        }
        ListNode temp1 = temp.next;
        ListNode t = temp.next;
        temp.next =null;
        while(t.next!=null)
        {
            t=t.next;
        }
        t.next = head;
        head = temp1;
        return head;




        
    }
}