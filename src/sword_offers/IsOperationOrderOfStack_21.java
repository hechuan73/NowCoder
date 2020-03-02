package sword_offers;

import java.util.Stack;

/**
 * @author hechuan
 */
public class IsOperationOrderOfStack_21 {

    /**
     * Using an extra stack to simulate the operations.
     *
     * @param pushA push order of the stack
     * @param popA pop order of the stack
     * @return whether it a correct stack
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0) { return false; }

        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i : pushA) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }

        return stack.isEmpty();
    }
}
