package Stack;

/**
 * Created by NISHANT on 9/6/17.
 */

/*
Stack is a linear data structure which follows a particular order in which the operations are performed.
The order may be LIFO(Last In First Out) or FILO(First In Last Out).

Operations :-

Push: Adds an item in the stack. If the stack is full, then it is said to be an Overflow condition.
Pop: Removes an item from the stack. The items are popped in the reversed order in which they are pushed.
If the stack is empty, then it is said to be an Underflow condition.
Peek or Top: Returns top element of stack.
isEmpty: Returns true if stack is empty, else false.

Time Complexities of operations on stack:
push(), pop(), esEmpty() and peek() all take O(1) time. We do not run any loop in any of these operations.

Implementation:
There are two ways to implement a stack:

Using array
Using linked list
*/

/* Java program to implement basic stack operations */
public class Stack {

    static final int MAX = 1000;
    int top;
    int a[] = new int[MAX]; // Maximum size of Stack

    boolean isEmpty()
    {
        return (top < 0);
    }
    Stack()
    {
        top = -1;
    }

    boolean push(int x){

        if (top >= MAX){
            System.out.println("Stack Overflow");
            return false;
        }else {
            a[++top] = x;
            return true;
        }
    }

    int pop(){

        if (top < 0){
            System.out.println("Stach Underflow");
            return 0;
        }else {
            int x = a[top--];
            return x;
        }
    }

    // Driver code
    public static void main(String args[])
    {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
    }

}
