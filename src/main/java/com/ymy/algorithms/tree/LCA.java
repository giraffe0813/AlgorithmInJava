package com.ymy.algorithms.tree;

/**
 * 在二叉树(不是二叉搜索树)中寻找两个节点的最小公共节点
 * leetcode第236
 * 解法参考
 * Created by yemengying on 16/4/13.
 */
public class LCA {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /**
     * 大概思想:
     * 1.从根节点开始 如果根节点为null 直接返回null
     * 2.如果根节点等于node1,node2中的一个 直接返回根节点
     * 3.如果根节点不等于两个节点中的任何一个,递归在左子树和右子树查找node1,node2
     * 4.如果找到一个节点,node1和node2分别在其左子树和右子树中 那么这个节点就是lca
     * 5.如果node1,node2都在当前访问节点的左子树中 继续往左递归
     * 6.如果node1,node2都在当前访问节点的右子树中 继续往右递归
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p ,q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        return null;

    }

}
