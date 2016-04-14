package com.ymy.algorithms.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树前序遍历
 * leetcode第144题 https://leetcode.com/problems/binary-tree-preorder-traversal/
 * Created by yemengying on 16/4/14.
 */
public class PreOrder {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private List<Integer> result = new ArrayList<>();
    private Stack<TreeNode> stack = new Stack<>();

    /**
     * 不利用递归 利用stack
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        if(root == null) return new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }

        return result;

    }
}
