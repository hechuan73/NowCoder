package sword_offers;

public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    /**
     * next pointer refers to its parent node.
     */
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
