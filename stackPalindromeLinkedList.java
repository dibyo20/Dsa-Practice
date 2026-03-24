public class stackPalindromeLinkedList {
    public class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    Node top = null;
    Node left;

    public void push(char data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public char pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return '0';
        }
        char popVal = top.data;
        top = top.next;
        return popVal;
    }

    public char peek() {
        if (top == null) {
            return '0';
        }
        return top.data;
    }

    void display() {
        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }

        Node temp = top;
        System.out.print("Stack elements: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public boolean isPalindrome() {
        left = top;
        return checkPalindrome(top);
    }

    public boolean checkPalindrome(Node right) {
        if (right == null) {
            return true;
        }

        boolean result = checkPalindrome(right.next);

        if (!result)
            return false;

        if (left.data == right.data) {
            left = left.next;
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        stackPalindromeLinkedList stack = new stackPalindromeLinkedList();
        stack.push('A');
        stack.push('B');
        stack.push('C');
        stack.push('B');
        stack.push('A');

        // stack.display();
        if (stack.isPalindrome()) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}
