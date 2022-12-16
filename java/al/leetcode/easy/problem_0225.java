/**
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 * Implement the MyStack class:
 * 1. void push(int x) Pushes element x to the top of the stack.
 * 2. int pop() Removes the element on the top of the stack and returns it.
 * 3. int top() Returns the element on the top of the stack.
 * 4. boolean empty() Returns true if the stack is empty, false otherwise.
 * 
 * Notes:
 * You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 */

package al.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Queue;

public class problem_0225 {

    Queue<Integer> a;
    Queue<Integer> b;

    public problem_0225() {
        a = new ArrayDeque<>();
        b = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if (!a.isEmpty()) {
            b.offer(a.poll());
        }
        a.offer(x);
    }
    
    public int pop() {
        int pop = a.poll();
        int size = b.size();
        while (size > 1) {
            a.offer(b.poll());
            b.offer(a.poll());
            size--;
        }
        if (!b.isEmpty()) {
            a.offer(b.poll());
        }
        return pop;
    }
    
    public int top() {
        return a.peek();
    }
    
    public boolean empty() {
        return this.a.isEmpty() && this.b.isEmpty();
    }
    
}
