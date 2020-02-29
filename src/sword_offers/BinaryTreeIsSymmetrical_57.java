package sword_offers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author hechuan
 */
public class BinaryTreeIsSymmetrical_57 {

    /**
     * DFS with recursion.
     *
     * @param pRoot the root node of tree
     * @return whether the tree is symmetrical
     */
    public boolean isSymmetrical1(TreeNode pRoot) {
        if (pRoot == null) { return true; }
        return compare(pRoot.left, pRoot.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null) { return right == null; }
        if (right == null) { return false; }
        if (left.val != right.val) { return false; }
        return compare(left.left, right.right)  && compare(left.right, right.left);
    }

    /**
     * DFS with stack instead of recursion.
     *
     * @param pRoot the root node of tree
     * @return whether the tree is symmetrical
     */
    public boolean isSymmetrical2(TreeNode pRoot) {
        if (pRoot == null) { return true; }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot.left);
        stack.push(pRoot.right);
        TreeNode left, right;
        while (!stack.isEmpty()) {
            // pop two symmetrical nodes
            left = stack.pop();
            right = stack.pop();
            if (left == null && right == null) { continue; }
            if (left == null || right == null) { return false; }
            if (left.val != right.val) { return false; }

            // push two symmetrical nodes
            stack.push(left.left);
            stack.push(right.right);
            // push two symmetrical nodes
            stack.push(left.right);
            stack.push(right.left);
        }

        return true;
    }

    /**
     * BFS with queue instead of recursion.
     *
     * @param pRoot the root node of tree
     * @return whether the tree is symmetrical
     */
    public boolean isSymmetrical3(TreeNode pRoot) {
        if (pRoot == null) { return true; }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot.left);
        queue.offer(pRoot.right);
        TreeNode left, right;
        while (!queue.isEmpty()) {
            // pop two symmetrical nodes
            left = queue.poll();
            right = queue.poll();
            if (left == null && right == null) { continue; }
            if (left == null || right == null) { return false; }
            if (left.val != right.val) { return false; }

            // push two symmetrical nodes
            queue.offer(left.left);
            queue.offer(right.right);
            // push two symmetrical nodes
            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }
}
