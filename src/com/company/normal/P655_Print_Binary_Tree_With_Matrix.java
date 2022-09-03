package com.company.normal;

import java.util.ArrayList;
import java.util.List;

public class P655_Print_Binary_Tree_With_Matrix {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        root.left = node;

        System.out.println(printTree(root));
    }

    public static List<List<String>> printTree(TreeNode root) {
        // 递归法求得树的高度，确定height，确定行数n，以及列数m
        // 开始从 matrix[0][(n-1)/2]进行填充

        if (root == null) {
            return new ArrayList<>();
        }

        int height = getHeight(root);
        int m = height + 1;
        int n = 1 << (height + 1) - 1;

        String[][] matrix = new String[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = "";
            }
        }

        // 递归 填写
        fillMathix(root, matrix, height, m, n, 0, (n - 1) / 2);

        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<String> arr = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                arr.add(matrix[i][j]);
            }

            result.add(arr);
        }

        return result;
    }

    private static void fillMathix(TreeNode root, String[][] matrix, int height, int m, int n, int row, int column) {
        if (root == null || row < 0 || row >= m || column < 0 || column >= n) {
            return;
        }

        matrix[row][column] = String.valueOf(root.val);

        int leftR = row + 1;
        int rightR = row + 1;

        int leftC = column - (1 << (height - column - 1));
        int rightC = column + (1 << (height - column - 1));

        fillMathix(root.left, matrix, height, m, n, leftR, leftC);
        fillMathix(root.right, matrix, height, m, n, rightR, rightC);
    }


    private static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return Math.max(left, right) + 1;
    }
}
