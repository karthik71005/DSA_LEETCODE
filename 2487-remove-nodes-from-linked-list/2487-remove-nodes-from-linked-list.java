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
    public ListNode removeNodes(ListNode head) {
        Deque <ListNode> stack =  new ArrayDeque<>();
        ListNode curr = head;
        while(curr!=null)
        {
            stack.push(curr);
            curr=curr.next;
        } 
        ListNode result = null;
        int max = Integer.MIN_VALUE;
        while(!stack.isEmpty())
        {
            ListNode node = stack.peek();
            if(node.val>=max)
            {
                max = node.val;
                node.next = result;
                result = node;
            }
            stack.pop();
        }
        return result;
    }
}