package com.ymy.algorithms.tree;

/**
 * 在二叉搜索树中寻找两个节点的最小公共节点
 * 解法参考:http://algorithms.tutorialhorizon.com/lowest-common-ancestor-in-a-binary-tree-not-binary-search-tree/
 * leetcode
 * Created by yemengying on 16/4/13.
 */
public class LCA2 {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return root;
        if(root == p || root == q){
            return root;
        }
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }

        return root;
    }



}
