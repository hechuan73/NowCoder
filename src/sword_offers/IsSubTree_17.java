package sword_offers;

/**
 * @author hechuan
 */
public class IsSubTree_17 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) { return false;}
        return check(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean check(TreeNode root1,TreeNode root2) {
        if (root1 == null) { return root2 == null; }
        if (root2 == null) { return true; }
        if (root1.val != root2.val) { return false; }

        return check(root1.left, root2.left) && check(root1.right, root2.right);
    }
}
