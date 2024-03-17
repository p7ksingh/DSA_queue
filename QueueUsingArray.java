package one.ozone.www;

public class QueueUsingArray {
    private int[] data;
    private int front;
    private int rear;
    private int size;

    public QueueUsingArray() {
        data = new int[5];
        front = -1;
        rear = -1;
    }

    // size of queue
    public int size() {
        return size;
    }

    // check queue is empty
    public boolean isEmpty() {

        return size == 0;
    }

    // front element
    public int front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        return data[front];
    }

    public void enqueue(int elem) throws QueueEmptyException {
        // check queue is full
        if (size == data.length) {
            throw new QueueEmptyException();
        }
        // check queue is empty
        if (size == 0) {
            front = 0;
        }
        rear++;
        // check rear index of queue
        if (rear == data.length) {
            rear = 0;
        }
        data[rear] = elem;
        size++;
    }

    public int dequeue() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();

        }
        int temp = data[front];
        front++;
        size--;
        if (size == 0) {
            front = -1;
            rear = -1;
        }
        return temp;
    }

    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray();

        int arr[] = { 1, 2, 3, 4, 5, };
        for (int ele : arr) {
            try {
                queue.enqueue(ele);
            } catch (QueueEmptyException e) {

                e.printStackTrace();
            }
        }
        while (!queue.isEmpty()) {
            try {
                System.out.println(queue.dequeue());
            } catch (QueueEmptyException e) {

                e.printStackTrace();
            }
        }
    }
}