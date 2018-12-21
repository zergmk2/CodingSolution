package codetest.DataStructure;

class MyCircularQueue {

    private int[] circleQueue;
    private int head, tail;
    private int size;
    private int cnt;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        circleQueue = new int[k];
        size = k;
        head = 0;
        tail = 0;
        cnt = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull())
        {
            return false;
        }
        else
        {
            if (isEmpty())
            {
                circleQueue[tail] = value;
            }
            else
            {
                tail = moveNext(tail);
                circleQueue[tail] = value;
            }

            cnt++;
            return true;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty())
        {
            return false;
        }
        else {
            if (head != tail)
            {
                head = moveNext(head);
            }
            cnt--;
            return true;
        }
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty())
        {
            return -1;
        }
        return circleQueue[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty())
        {
            return -1;
        }
        return circleQueue[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return cnt == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return cnt == size;
    }

    private int moveNext(int x)
    {
        return (x + 1) % size;
    }

    private int movePrev(int x)
    {
        return (size + x - 1) % size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
