/**
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 * 
 * Implement the MyQueue class:
 * 1. void push(int x) Pushes element x to the back of the queue.
 * 2. int pop() Removes the element from the front of the queue and returns it.
 * 3. int peek() Returns the element at the front of the queue.
 * 4. boolean empty() Returns true if the queue is empty, false otherwise.
 * 
 * Notes:
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. 
 * You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 */

package al.leetcode.easy;

import java.util.Stack;

public class problem_0232 {

    private Stack<Integer> in;
    private Stack<Integer> out;

    public problem_0232() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if (out.isEmpty()) {
            transfer();
        }
        return out.pop();
    }
    
    public int peek() {
        if (out.isEmpty()) {
            transfer();
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    public void transfer() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
    }
    
}
