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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode left = head;
        ListNode previousLeft = null;
        ListNode nextLeft =null;
        ListNode res = null;
        ListNode right = null;
        int i =0;
        while(true)
        {
            right = left;
            for(i =0;i<(k-1);i++){
                if(right == null)
                    break;
                right=right.next;
            }
            if (right == null) {
                break; 
            }
            nextLeft = right.next;
            ListNode reversedHead = reverse(left,k);
            if(res == null)
                res =reversedHead;
            

            if(previousLeft!=null)
            {
                previousLeft.next =reversedHead;
            }

            left.next =nextLeft;
            previousLeft=left;
            left=nextLeft;
           


        }
        return res != null ? res : head;
        
    }
    public ListNode reverse(ListNode temp,int k){
        ListNode curr = temp;
        ListNode prev = null;
        while(k!=0)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;
            k--;
        }
        return prev;
    }
}