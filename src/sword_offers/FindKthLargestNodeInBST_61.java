package sword_offers;

import java.util.Stack;

public class FindKthLargestNodeInBST_61 {

    private int index = 0;

    /**
     * In-order reversal with recursion.
     *
     * @param pRoot root node of the BST
     * @param k the rank of the target node
     * @return the KthNode
     */
    public TreeNode KthNode1(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode node = KthNode1(pRoot.left, k);
            if (node != null) { return node; }
            index++;
            if (k == index) { return pRoot; }
            node = KthNode1(pRoot.right, k);
            return node;
        }

        return null;
    }

    /**
     * In-order reversal with stack instead of recursion.
     *
     * @param pRoot root node of the BST
     * @param k the rank of the target node
     * @return the KthNode
     */
    public TreeNode KthNode2(TreeNode pRoot, int k) {
        if (pRoot != null) {
            Stack<TreeNode> stack = new Stack<>();

            while (!stack.isEmpty() || pRoot != null) {
                while (pRoot != null) {
                    stack.push(pRoot);
                    pRoot = pRoot.left;
                }

                pRoot = stack.pop();
                if (--k == 0) { return pRoot; }
                pRoot = pRoot.right;
            }
        }

        return null;
    }

}
