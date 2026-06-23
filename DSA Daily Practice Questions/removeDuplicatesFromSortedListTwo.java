public class removeDuplicatesFromSortedListTwo {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;p
    }
}
