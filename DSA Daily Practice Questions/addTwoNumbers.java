public class addTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode addTwoNum(ListNode l1, ListNode l2) {
        ListNode Sum = new ListNode(0);
        ListNode temp = Sum;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;

            int digit = sum % 10;
            carry = sum / 10;

            temp.next = new ListNode(digit);
            temp = temp.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return Sum.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode ans = addTwoNum(l1, l2);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}
