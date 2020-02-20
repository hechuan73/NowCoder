package sword_offers;

import java.util.Stack;

public class BSTToDoubleLinkedList_26 {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) { return null; }
        TreeNode head = new TreeNode(0);
        TreeNode prev = head;
        Stack<TreeNode> stack = new Stack<>();
        while (pRootOfTree != null || !stack.isEmpty()) {
            while (pRootOfTree != null) {
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }

            pRootOfTree = stack.pop();
            prev.right = pRootOfTree;
            pRootOfTree.left = prev;
            prev = pRootOfTree;
            pRootOfTree = pRootOfTree.right;
        }

        head = head.right;
        head.left = null;

        return head;
    }
}
