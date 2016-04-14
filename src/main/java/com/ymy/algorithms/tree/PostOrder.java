package com.ymy.algorithms.tree;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树后序遍历--先访问左子树 在访问右子树 最后访问根节点
 * leetcode 第145题 https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 解法参考:http://algorithms.tutorialhorizon.com/binary-tree-postorder-traversal-non-recursive-approach/
 * Created by yemengying on 16/4/14.
 */
public class PostOrder {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private List<Integer> result = new ArrayList<>();

    /**
     * 解法一 : 比较简单 利用递归
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {

        if(root == null) return result;

        if(root.left != null){
            postorderTraversal(root.left);
        }
        if(root.right != null){
            postorderTraversal(root.right);
        }
        result.add(root.val);
        return result;

    }


    /**
     * 解法二:利用stack
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root){
        if(root == null) return result;

        return null;

    }


}
