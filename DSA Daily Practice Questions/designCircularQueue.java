public class designCircularQueue {
    static class MyCircularQueue {
        private int[] arr;
        private int size;
        private int front;
        private int rear;

        public MyCircularQueue(int k) {
            arr = new int[k];
            size = k;
            front = -1;
            rear = -1;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }

            if (front == -1) {
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = value;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }

            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;
            }

            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return arr[front];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return arr[rear];
        }

        public boolean isEmpty() {
            return front == -1;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }
    }

    public static void main(String[] args) {
        MyCircularQueue q = new MyCircularQueue(3);

        System.out.println(q.enQueue(1));
        System.out.println(q.enQueue(2));
        System.out.println(q.enQueue(3));
        System.out.println(q.enQueue(4));

        System.out.println("Front = " + q.Front());
        System.out.println("Rear = " + q.Rear());

        System.out.println(q.deQueue());

        System.out.println("Front = " + q.Front());

        System.out.println(q.enQueue(4));

        System.out.println("Rear = " + q.Rear()); 

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());

        System.out.println(q.isEmpty());
    }
}