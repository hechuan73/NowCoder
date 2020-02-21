package sword_offers;

/**
 * @author hechuan
 */
public class DepthOfBinaryTree_38 {

    public int TreeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(TreeDepth(root.right), TreeDepth(root.right));
    }
}
