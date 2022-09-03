package com.company.normal;

import java.util.*;

public class P102_Binary_Tree_Level_Search {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list1 = new ArrayList<>();
            int currentSize = queue.size();
            for (int i = 1; i <= currentSize; i++) {
                TreeNode node = queue.poll();
                list1.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(list1);
        }
        return ret;
    }
}
