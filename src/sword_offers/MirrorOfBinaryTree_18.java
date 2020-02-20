package sword_offers;

/**
 * @author hechuan
 */
public class MirrorOfBinaryTree_18 {

    public void Mirror(TreeNode root) {
        if (root != null) {
            TreeNode tmp;
            tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            Mirror(root.left);
            Mirror(root.right);
        }
    }
}
