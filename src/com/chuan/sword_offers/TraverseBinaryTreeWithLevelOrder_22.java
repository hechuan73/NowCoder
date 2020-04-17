package com.chuan.sword_offers;

import java.util.ArrayList;

/**
 * @author hechuan
 */
public class TraverseBinaryTreeWithLevelOrder_22 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root != null) {
            ArrayList<TreeNode> queue = new ArrayList<>();
            queue.add(root);

            int levelLen;
            TreeNode curr;
            while (!queue.isEmpty()) {
                levelLen = queue.size();
                while (levelLen-- > 0) {
                    curr = queue.remove(0);
                    if (curr.left != null) { queue.add(curr.left); }
                    if (curr.right != null) { queue.add(curr.right); }
                    res.add(curr.val);
                }
            }
        }

        return res;
    }
}
