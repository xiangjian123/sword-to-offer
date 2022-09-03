package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P200_Island_Number {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            System.out.println();
            maxAns = Math.max(maxAns, pre);
            System.out.println("pre" + pre + ",max " + maxAns);
        }
        System.out.println(maxAns);
    }

    public static int numIslands(char[][] grid) {
        // 孤立的1的数量
        // 顺序检索1，发现1之后，开始处理
        // 节点向外衍生，检索最多4个临近节点后，停止。将发现的1，加入到队列中。
        // 循环直到所有节点停止检索。记录所有探测过的节点。后续检索新节点跳过这些节点。
        int rNum = grid.length;
        int cNum = grid[0].length;

        int count = 0;
        int[][] recog = new int[rNum][cNum];
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < rNum; i++) {
            for (int j = 0; j < cNum; j++) {
                if (grid[i][j] == '1' && recog[i][j] == 0) {
                    // 发现1个1节点。开始处理
                    queue.offer(i + ":" + j);
                    System.out.println("pos: " + i + ":" + j);
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        System.out.println("queue: " + queue.toString());
                        for (int s1 = 1; s1 <= size; s1++) {
                            String[] arr = queue.poll().split(":");
                            int rN = Integer.parseInt(arr[0]);
                            int cN = Integer.parseInt(arr[1]);

                            // 检索周边节点，标记search。如果为1，并且未处理，加入到处理列表中
                            recog[rN][cN] = 1;

                            if (rN - 1 >= 0) {
                                if (grid[rN - 1][cN] == '1' && recog[rN - 1][cN] == 0) {
                                    queue.offer((rN - 1) + ":" + cN);
                                }
                            }
                            if (rN + 1 < rNum) {
                                if (grid[rN + 1][cN] == '1' && recog[rN + 1][cN] == 0) {
                                    queue.offer((rN + 1) + ":" + cN);
                                }
                            }
                            if (cN - 1 >= 0) {
                                if (grid[rN][cN - 1] == '1' && recog[rN][cN - 1] == 0) {
                                    queue.offer(rN + ":" + (cN - 1));
                                }
                            }
                            if (cN + 1 < cNum) {
                                if (grid[rN][cN + 1] == '1' && recog[rN][cN + 1] == 0) {
                                    queue.offer(rN + ":" + (cN + 1));
                                }
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
