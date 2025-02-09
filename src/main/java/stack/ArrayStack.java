package stack;

/** Array-based implementation of Stack ADT.  Used in the TextEditor.
 *  Do not modify for the homework.
 *  The code is based on the code of Prof. Galles.
 */

public class ArrayStack implements Stack {
    public static final int DEFAULT_INITIAL_SIZE = 100;

    private Object data[]; // the array to store elements

    // top is the index of the element right after the element
    // at the top of the stack
    private int top;
    private int size; // the maximum number of elements in the stack

    /** Initialize as an array of a default size */
    public ArrayStack() {
        data = new Object[DEFAULT_INITIAL_SIZE];
        top = 0;
        size = DEFAULT_INITIAL_SIZE;
    }

    /** Initialize as an array of a given size */
    public ArrayStack(int initSize) {
        data = new Object[initSize];
        top = 0;
        size = initSize;
    }

    /** Return true if the stack is empty */
    public boolean empty() {
        return top == 0;
    }

    /** Push the element onto the stack. If the stack is full,
     *  before pushing an element, will call growStack()
     *  to create a larger array. */
    public void push(Object elem) {
        if (top == size) {
            System.out.println("Stack is full, cannot add an element");
            return;
        }
        data[top] = elem;
        top++;
    }

    /** Pop the element off the top of the stack */
    public Object pop() {
        if (top > 0)
            return data[--top];
        else
            return null; // nothing to pop, stack is empty
    }

    public Object peek() {
        if (top > 0)
            return data[top - 1];
        else
            return null;
    }

    /** Print elements of the stack */
    public String toString() {
        String result = "[";
        if (top > 0) {
            result = result + data[top - 1];
        }
        for (int i = top - 2; i >= 0; i--) {
            result = result + "," + data[i];
        }
        result = result + "]";
        return result;
    }

}

