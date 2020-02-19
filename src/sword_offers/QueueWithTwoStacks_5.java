package sword_offers;

import java.util.Stack;

/**
 * @author hechuan
 */
public class QueueWithTwoStacks_5 {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) { throw new RuntimeException ("Queue is empty!"); }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}
