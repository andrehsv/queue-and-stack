import java.util.Arrays;

public class Queue {
    private int[] array;
    private int head;
    private int tail;
    private int size;

    public Queue(int initialCapacity) {
        this.array = new int[initialCapacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void enqueue(int element) {
        if(size == array.length) resize(2 * array.length);
        array[tail++] = element;
        if(tail == array.length) tail = 0;
        size++;
    }

    public void dequeue() {
        array[head] = 0;
        head++;
        size--;
        if(head == array.length) head = 0;
        if(size > 0 && size == array.length/4) resize(array.length/2);
    }

    public void resize(int newCapacity) {
        int[] newArray = new int[newCapacity];
        for(int i = 0; i < size; i++)
            newArray[i] = array[(head + i) % array.length];
        array = newArray;
        head = 0;
        tail = size;
    }

    @Override
    public String toString() {
        return "Queue [array=" + Arrays.toString(array) + "]";
    }
}