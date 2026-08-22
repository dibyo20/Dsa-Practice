public class insertionSortList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode SortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            insert(curr, dummy);
            curr = next;
        }
        return dummy.next;
    }

    private static void insert(ListNode curr, ListNode dummy) {
        ListNode prev = dummy;
        while (prev.next != null && prev.next.val < curr.val) {
            prev = prev.next;
        }
        curr.next = prev.next;
        prev.next = curr;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode sorted = SortList(head);
        while (sorted != null) {
            System.out.print(sorted.val + " ");
            sorted = sorted.next;
        }
    }
}
