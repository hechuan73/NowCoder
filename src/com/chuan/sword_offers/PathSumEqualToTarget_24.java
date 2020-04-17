package com.chuan.sword_offers;

import java.util.ArrayList;

/**
 * @author hechuan
 */
public class PathSumEqualToTarget_24 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), root, target);
        // long path first
        res.sort((a, b) -> b.size()-a.size());

        return res;
    }

    private void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, TreeNode root,int target) {
        if (root != null) {
            target -= root.val;
            path.add(root.val);
            if (target == 0 && root.left == null && root.right == null) {
                res.add(new ArrayList<>(path));
            }

            if (target > 0) {
                dfs(res, path, root.left, target);
                dfs(res, path, root.right, target);
            }
            path.remove(path.size()-1);
        }
    }
}
