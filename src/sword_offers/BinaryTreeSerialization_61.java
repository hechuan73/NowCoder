package sword_offers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hechuan
 */
public class BinaryTreeSerialization_61 {

    public String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            TreeNode curr;
            int levelLen;
            boolean over = false;
            while (!queue.isEmpty()) {
                if (over) { break; }
                over = true;
                levelLen = queue.size();
                while (levelLen-- > 0) {
                    curr = queue.poll();
                    if (curr == null) {
                        sb.append("#!");
                        queue.add(null);
                        queue.add(null);
                    }
                    else {
                        sb.append(curr.val).append("!");
                        queue.add(curr.left);
                        queue.add(curr.right);
                        if (curr.left != null || curr.right != null) { over = false; }
                    }
                }
            }//"1!2!#!"
        }
        return sb.toString();
    }

    public TreeNode Deserialize(String str) {
        TreeNode root = null;
        if (!str.isEmpty()) {
            String[] nodes = str.split("!");
            Queue<TreeNode> lastLevel = new LinkedList<>();
            root = new TreeNode(Integer.parseInt(nodes[0]));
            lastLevel.add(root);
            int lastLevelLen, index = 1;
            TreeNode prev;
            //"1!#!2!#!#!#!3!"
            boolean over = false;
            while (!lastLevel.isEmpty()) {
                if (over) { break; }
                over = true;
                lastLevelLen = lastLevel.size();
                while (lastLevelLen-- > 0) {
                    prev = lastLevel.poll();
                    if (prev == null) {
                        index += 2;
                        lastLevel.add(null);
                        lastLevel.add(null);
                    }
                    else {
                        prev.left = (index >= nodes.length || nodes[index].equals("#")) ? null : new TreeNode(Integer.parseInt(nodes[index]));
                        index++;
                        prev.right = (index >= nodes.length || nodes[index].equals("#")) ? null : new TreeNode(Integer.parseInt(nodes[index]));
                        index++;
                        lastLevel.add(prev.left);
                        lastLevel.add(prev.right);
                        if (prev.left != null || prev.right != null) { over = false; }
                    }
                }
            }
        }

        return root;
    }


}
