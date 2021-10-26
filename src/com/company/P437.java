package com.company;

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
}

public class P437 {
    public static void main(String[] args) {

    }

    public static int pathSum(TreeNode root, int targetSum) {
        int sum = 0;
        if (root.val == targetSum) {
            sum += 1;
        } else {
            if (root.left != null) {
                if (root.val < targetSum) {
                    sum += pathSum(root.left,  targetSum - root.val);
                } else {
                    sum += pathSum(root.left,  targetSum);
                }
            }
            if (root.right != null) {
                if (root.val < targetSum) {
                    sum += pathSum(root.right,  targetSum - root.val);
                } else {
                    sum += pathSum(root.right,  targetSum);
                }
            }

        }
        return sum;
    }
}