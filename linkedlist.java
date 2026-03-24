public class linkedlist {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) { // TC: O(1)
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast(int data) { // TC: O(1)
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addMiddle(int data, int position) { // TC: O(n)
        if (head == null || position <= 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node current = head; // Current is the pointer to traverse the list
        int i = 0;
        while (i < position - 1 && current.next != null) {
            current = current.next;
            i++;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void removeFirst() { // TC: O(1)
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        size--;
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    public void removeLast() { // TC: O(n)
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        size--;
        if (head.next == null) {
            head = null; // If there's only one element
            tail = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        tail = current;
    }

    public int iterativeSearch(int key) { // TC: O(n)
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int recursiveSearch(Node head, int key) { // TC: O(n)
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int indx = recursiveSearch(head.next, key);
        if (indx == -1) {
            return -1;
        }
        return indx + 1; // Increment index for each recursive call
    }

    public void reverse() { // TC: O(n)
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev; // As curr becomes null, prev will be at last node
    }

    public void deleteNthfromEnd(int n) {  // TC: O(n)
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if (n == sz) {
            head = head.next;
            return;
        }

        int i = 1;
        int iToFind = sz - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        i++;
    }

    public void printList() { // TC: O(n)
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]) {
        linkedlist list = new linkedlist();
        // System.out.println("ADDING ELEMENTS TO THE LINKED LIST:");
        // list.addFirst(30);
        // list.printList();
        // list.addFirst(20);
        // list.printList();
        // list.addFirst(10);
        // list.printList();
        // list.addLast(40);
        // list.printList();
        // list.addLast(50);
        // list.printList();
        // list.addLast(60);
        // list.printList();
        // list.addMiddle(25, 2);
        // list.printList();
        // System.out.println("Size of the linked list: " + size);
        // System.out.println("Head element: " + head.data);
        // System.out.println("Tail element: " + tail.data);
        // System.out.println("--------------------------------------");

        // System.out.println("REMOVING ELEMENTS FROM THE LINKED LIST:");
        // list.removeFirst();
        // list.printList();
        // list.removeLast();
        // list.printList();
        // System.out.println("Size of the linked list: " + size);
        // System.out.println("Head element: " + head.data);
        // System.out.println("Tail element: " + tail.data);

        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        list.addLast(70);
        list.addLast(80);
        list.printList();
        // System.out.println("Element '40' found using IterativeSearch at index: " +
        // list.iterativeSearch(40));
        // System.out.println("Element '100' found using IterativeSearch at index: " +
        // list.iterativeSearch(100));
        // System.out.println("Element '30' found using RecursiveSearch at index: " +
        // list.recursiveSearch(head, 30));
        // System.out.println("Element '100' found using RecursiveSearch at index: " +
        // list.recursiveSearch(head, 100));
        // list.reverse();
        // list.printList();
        // list.reverse();
        // list.printList();
        list.deleteNthfromEnd(3);
        list.printList();

    }
}
