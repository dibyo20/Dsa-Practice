public class deleteTheMiddleNodeOfALinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode Slow = head;
        ListNode Fast = head;
        ListNode prev = null;

        while (Fast != null && Fast.next != null) {
            prev = Slow;
            Slow = Slow.next;
            Fast = Fast.next.next;
        }

        prev.next = Slow.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode ans = deleteMiddle(head);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}
