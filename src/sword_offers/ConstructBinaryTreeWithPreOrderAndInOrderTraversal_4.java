package sword_offers;

/**
 * @author hechuan
 */
public class ConstructBinaryTreeWithPreOrderAndInOrderTraversal_4 {

    /**
     * 1. 前序数组第一个值为树的根，构建根节点；
     * 2. 在中序数组中找到第一步中树的根，则前半部分为树的左子树中序数组，后半部分为树的右子树中序数组；
     * 3. 通过第二步，计算出左子树的节点数n，则可以在前序数组中确定出左子树的前序序列（根节点后的n个数即为左子树的前序数组部分，另一部分为右子树
     *    的前序数组部分）；
     * 4. 递归构建根节点的左子树和右子树。
     *
     * Note: 可以使用散列表来存储inorder数组的值，以便于每次不需要在遍历inorder来查找根节点在其中的位置，可以将时间复杂度降为O(n).
     *
     * Time Complexity: O(n*h)  best: O(nlogn)  worst: O(n^2)
     * Space Complexity: O(n/2)
     *
     * @param pre the preorder array
     * @param in the inorder array
     * @return the tree
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return build(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    private TreeNode build(int [] pre, int pStart, int pEnd, int [] in, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) { return null; }

        TreeNode root = new TreeNode(pre[pStart]);
        int i = iStart;
        for (; i <= iEnd; i++) {
            if (in[i] == root.val) {
                break;
            }
        }

        int leftChildLen = i-iStart, rightChildLen = iEnd-i+1;

        root.left = build(pre, pStart+1, pStart+leftChildLen, in, iStart, i-1);
        root.right = build(pre, pStart+leftChildLen+1, pEnd, in, i+1, iEnd);

        return root;
    }


}
