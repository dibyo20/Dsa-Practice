public class swapNodesInPairs {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode first = head;

        if (first == null || first.next == null)
            return head;

        ListNode second = head.next;

        while (first != null && second != null) {
            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
            first = first.next;
            if (first != null) {
                second = first.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode ans = swapPairs(head);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}
