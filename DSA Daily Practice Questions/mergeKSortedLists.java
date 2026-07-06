import java.util.List;

public class mergeKSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0)
            return null;

        return mergeSort(lists, 0, lists.size() - 1);
    }

    private static ListNode mergeSort(List<ListNode> lists, int left, int right) {
        if (left == right) {
            return lists.get(left);
        }

        int mid = (left + right) / 2;
        ListNode l1 = mergeSort(lists, left, mid);
        ListNode l2 = mergeSort(lists, mid + 1, right);

        return merge(l1, l2);
    }

    private static ListNode merge(ListNode head1, ListNode head2) {
        ListNode mergedLL = new ListNode(-1);
        ListNode temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        List<ListNode> lists = new java.util.ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);

        ListNode ans = mergeKLists(lists);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}
