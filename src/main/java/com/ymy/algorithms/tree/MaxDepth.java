package com.ymy.algorithms.tree;

import com.ymy.algorithms.model.TreeNode;

/**
 *
 * Created by yemengying on 16/5/9.
 */
public class MaxDepth {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {

        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        else{
            return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
        }

    }
}
