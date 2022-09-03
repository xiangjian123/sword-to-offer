package com.company.mid;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}

public class P687_Longest_Tree_Same_Value_Path {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        TreeNode node2 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(5);
//        TreeNode node4 = new TreeNode(1);
//        TreeNode node5 = new TreeNode(1);
//        TreeNode node6 = new TreeNode(5);
//
//        root.left = node2;
//        root.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.right = node6;

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(5);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        System.out.println(longestUnivaluePath(root));

    }

    public static int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getPath(root, 1) - 1;
    }

    private static int getPath(TreeNode node, int num) {
        if (node == null) {
            return num;
        }

        if (node.left == null && node.right == null) {
            return num;
        }

        int cur = 0;

        System.out.println(node.toString() + " " + num);
        int left = 0;
        int right = 0;
        if (node.left != null) {
            if (node.val == node.left.val) {
                left = getPath(node.left, num + 1);
            } else {
                left = getPath(node.left, 1);
            }
        }

        if (node.right != null) {
            if (node.val == node.right.val) {
                right = getPath(node.right, num + 1);
            } else {
                right = getPath(node.right, 1);
            }
        }

        if (node.left != null && node.right != null) {
            if (node.left.val == node.val && node.right.val == node.val) {
                cur = left + right - 1;
            }
        }

        System.out.println("left: " + left + ", right: " + right + ", cur: " + cur);
        return Math.max(Math.max(left, right), cur);
    }
}
