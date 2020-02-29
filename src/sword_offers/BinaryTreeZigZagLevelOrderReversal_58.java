package sword_offers;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeZigZagLevelOrderReversal_58 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (pRoot != null) {
            // save nodes in odd levels
            Stack<TreeNode> stack1 = new Stack<>();
            // save nodes in even levels
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(pRoot);

            ArrayList<Integer> levelNode;
            TreeNode curr;
            while (!stack1.isEmpty() || !stack2.isEmpty()) {
                levelNode = new ArrayList<>();
                if (stack1.isEmpty()) {
                    while (!stack2.isEmpty()) {
                        curr = stack2.pop();
                        levelNode.add(curr.val);
                        if (curr.right != null) { stack1.push(curr.right); }
                        if (curr.left != null) { stack1.push(curr.left); }
                    }
                }
                else {
                    while (!stack1.isEmpty()) {
                        curr = stack1.pop();
                        levelNode.add(curr.val);
                        if (curr.left != null) { stack2.push(curr.left); }
                        if (curr.right != null) { stack2.push(curr.right); }
                    }
                }
                res.add(levelNode);
            }
        }

        return res;
    }
}