package ProgrammerCarl.ImplementStackUsingQueues225;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 *
 * Implement the MyStack class:
 *
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 */
public class MyStack {
    Deque<Integer> deque;
    public MyStack() {
        deque = new LinkedList<>();
    }

    public void push(int x) {
        deque.offerLast(x);

    }

    public int pop() {
        int size = deque.size();
        for(int i = 0;i < size - 1;i++){
            deque.offerLast(deque.pollFirst());
        }
        return size==0 ? -1 : deque.pollFirst();
    }

    public int top() {
        int size = deque.size();
        for(int i = 0;i < size - 1;i++){
            deque.offerLast(deque.pollFirst());
        }
        int result = deque.pollFirst();
        deque.offerLast(result);
        return size==0 ? -1 : result;
    }

    public boolean empty() {
        return deque.size() == 0;
    }
}
