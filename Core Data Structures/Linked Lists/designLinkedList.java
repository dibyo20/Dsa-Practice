public class designLinkedList {
    public static class MyLinkedList {
        int val;
        MyLinkedList next;

        MyLinkedList(int val) {
            this.val = val;
        }

        MyLinkedList(int val, MyLinkedList next) {
            this.val = val;
            this.next = next;
        }
    }

    public static MyLinkedList head;
    public static MyLinkedList tail;
    public static int size;

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        MyLinkedList temp = head;
        int i = 0;
        while (temp != null) {
            if (i == index) {
                return temp.val;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public void addAtHead(int val) {
        MyLinkedList newNode = new MyLinkedList(val);
        size++;
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addAtTail(int val) {
        MyLinkedList newNode = new MyLinkedList(val);
        size++;
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        }

        if (index > size) {
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }
        MyLinkedList newNode = new MyLinkedList(val);
        MyLinkedList curr = head;
        int i = 0;
        while (i < index - 1 && curr.next != null) {
            curr = curr.next;
            i++;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }

        if (index == 0) {
            head = head.next;
            size--;

            if (head == null) {
                tail = null;
            }
            return;
        }

        MyLinkedList curr = head;
        int i = 0;

        while (i < index - 1 && curr.next != null) {
            curr = curr.next;
            i++;
        }

        if (curr.next == null) {
            tail = curr;
        }
        curr.next = curr.next.next;
        size--;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        MyLinkedList curr = head;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        designLinkedList list = new designLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        list.printList();
        list.deleteAtIndex(1);
        list.printList();
        int val = list.get(0);
        System.out.println(val);
    }
}
