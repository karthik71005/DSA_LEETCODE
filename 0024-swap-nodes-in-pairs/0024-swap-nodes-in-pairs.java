class Solution {
    public ListNode swapPairs1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Ensure there is a pair to swap
        while (prev.next != null && prev.next.next != null) {
            // prev.next is the head of the current pair
            prev.next = swapOnePair(prev.next);
            
            // Move prev two nodes ahead to the end of the swapped pair
            prev = prev.next.next;
        }

        return dummy.next;
    }

    // Swaps a single pair and returns the new head of this pair
    private ListNode swapOnePair(ListNode head) {
        ListNode first = head;
        ListNode second = head.next;

        // Swap links
        first.next = second.next;
        second.next = first;

        // Return the new front of the pair (which was the second node)
        return second;
    }
    public ListNode swapPairs(ListNode head) {
        int k=2;
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