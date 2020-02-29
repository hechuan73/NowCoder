package sword_offers;

import java.util.Stack;

public class BSTToDoubleLinkedList_26 {

    /**
     * In-order reversal with stack.
     *
     * @param pRootOfTree root node of the BST
     * @return the head of double linked list
     */
    public TreeNode Convert1(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
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


    /**
     * 记录子树链表的最后一个节点，终结点只可能为只含左子树的非叶节点与叶节点
     */
    private TreeNode leftLast = null;

    /**
     * In-order reversal with recursion.
     *
     * @param pRootOfTree root node of the BST
     * @return the head of double linked list
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) { return null; }

        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            // 最后的一个节点可能为最右侧的叶节点
            leftLast = pRootOfTree;
            return pRootOfTree;
        }

        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(pRootOfTree.left);
        // 2.如果左子树链表不为空的话，将当前root追加到左子树链表
        if (left!= null) {
            leftLast.right = pRootOfTree;
            pRootOfTree.left = leftLast;
        }

        // 3.当根节点只含左子树时，则该根节点为最后一个节点
        leftLast = pRootOfTree;
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(pRootOfTree.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if (right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }

        return left == null ? pRootOfTree : left;
    }
}