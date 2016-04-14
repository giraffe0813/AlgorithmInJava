package com.ymy.algorithms.tree;

import java.time.temporal.Temporal;
import java.util.List;

/**
 * 在二叉搜索树中寻找第k小的元素  1<=k<=元素总数
 * leetcode 230题
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Created by yemengying on 16/4/13.
 */
public class KthSmallestInBST {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /**
     * 解法一:
     * 将k和坐左子树的元素数作比较
     * 如果k等于左子树的元素数+1 返回根节点的值
     * 如果k大于左子树的元素数+1 递归在右子树中找第k-left-1个元素
     * 如果k小于左子树的元素数+1 递归在左子树中找第k个元素
     *
     * 时间复杂度是O(h) h是树的高度
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k){
        int left = getSize(root.left);
        int right = getSize(root.right);
        if(k == left + 1) return root.val;
        if(k > left + 1) return kthSmallest(root.right, k-left-1);
        return  kthSmallest(root.left, k);


    }
    public int getSize(TreeNode root){
        if(root == null) return 0;
        int size = 0;
        if(root.left != null){
            size = size + getSize(root.left);
        }
        if(root.right != null){
            size = size + getSize(root.right);
        }
        return size + 1;
    }



}
