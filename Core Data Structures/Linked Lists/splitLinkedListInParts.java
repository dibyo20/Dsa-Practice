public class splitLinkedListInParts {
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

    public static ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null)
            return new ListNode[k];

        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        int baseSize = len / k;
        int extra = len % k;
        ListNode[] ans = new ListNode[k];

        curr = head;
        for (int i = 0; i < k; i++) {
            int size = baseSize + (i < extra ? 1 : 0);

            if (size == 0) {
                ans[i] = null;
                continue;
            }

            ans[i] = curr;

            for (int j = 1; j < size; j++) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        ListNode[] ans = splitListToParts(head, 3);
        for (ListNode node : ans) {
            while (node != null) {
                System.out.print(node.val + " ");
                node = node.next;
            }
            System.out.println();
        }
    }
}
