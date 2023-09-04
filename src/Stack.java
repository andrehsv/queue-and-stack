import java.util.Arrays;

public class Stack {

    private int[] array;
    private int top;

    public Stack(int initialCapacity) {
        this.array = new int[initialCapacity];
        this.top = 0;
    }

    public void push(int element) {
        if(top == array.length) resize(2 * array.length);
        array[top++] = element;
    }

    public void pop() {
        array[top - 1] = 0;
        top--;
        if(top > 0 && top == array.length/4) resize(array.length/2);
    }

    public void resize(int newCapacity) {
        int[] newArray = new int[newCapacity];
        for(int i = 0; i < top; i++)
            newArray[i] = array[i];
        array = newArray;
    }

    @Override
    public String toString() {
        return "Stack [array=" + Arrays.toString(array) + "]";
    }
}
