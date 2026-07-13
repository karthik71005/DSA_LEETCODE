class Solution {
    public ListNode swapPairs(ListNode head) {
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
}