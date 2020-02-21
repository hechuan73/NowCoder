package sword_offers;

/**
 * @author hechuan
 */
public class IsBalancedForBinaryTree_39 {

    /**
     * Simple method with recursion.
     *
     * @param root root node of the binary tree
     * @return whether the binary tree is balanced
     */
    public boolean IsBalanced_Solution1(TreeNode root) {
        if (root == null) { return true; }

        return Math.abs(TreeDepth(root.left)-TreeDepth(root.right)) < 2 &&
                IsBalanced_Solution1(root.left) && IsBalanced_Solution1(root.right);
    }


    private int TreeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }

    /**
     * 上面的做法有很明显的问题，在判断上层结点的时候，会多次重复遍历下层结点，增加了不必要的开销。如果改为从下往上遍历，如果子树是平衡二叉树，则
     * 返回子树的高度；如果发现子树不是平衡二叉树，则直接停止遍历，这样至多只对每个结点访问一次。-1表示不平衡，>= 0表示高度。
     *
     * @param root root node of the binary tree
     * @return whether the binary tree is balanced
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) { return 0; }
        int left = getDepth(root.left);
        if (left == -1) { return -1; }
        int right = getDepth(root.right);
        if (right == -1) { return -1; }

        return Math.abs(left-right) > 1 ? -1 : Math.max(left, right);

    }
}
