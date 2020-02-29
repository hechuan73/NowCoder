package sword_offers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hechuan
 */
public class LevelOrderReversalBinaryTree_59 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(pRoot);

            TreeNode curr;
            int levelLen;
            ArrayList<Integer> levelNums;
            while (!queue.isEmpty()) {
                levelLen = queue.size();
                levelNums = new ArrayList<>();
                while (levelLen-- > 0) {
                    curr = queue.poll();
                    if (curr.left != null) { queue.add(curr.left); }
                    if (curr.right != null) { queue.add(curr.right); }
                    levelNums.add(curr.val);
                }
                res.add(levelNums);
            }
        }

        return res;
    }
}
