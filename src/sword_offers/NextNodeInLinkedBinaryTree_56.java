package sword_offers;

/**
 * @author hechuan
 */
public class NextNodeInLinkedBinaryTree_56 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) { return null; }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) { pNode = pNode.left; }
            return pNode;
        }

        while (pNode.next != null) {
            if (pNode.next.left == pNode) { return pNode.next; }
            pNode = pNode.next;
        }

        // pNode is the root node and does not have right node.
        return null;
    }
}
