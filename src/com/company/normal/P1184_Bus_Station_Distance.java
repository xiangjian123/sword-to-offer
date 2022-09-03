package com.company.normal;

/**
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，
 * distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 *
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 *
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/distance-between-bus-stops
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P1184_Bus_Station_Distance {
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        // 思路：正向和反向遍历，获取和，判断哪一个小
        // 重点：正向节点集合很好处理 [start,dest]
        // 重点：反向节点集合计算: [0,start] [dest, len - 1]

        int len = distance.length;
        if (len == 1 || start == destination) {
            return 0;
        }

        // switch start/dest
        int temp = destination;
        if (start > destination) {
            destination = start;
            start = temp;
        }

        int sum1 = 0;
        int sum2 = 0;

        for (int i = start; i < destination; i++) {
            sum1 += distance[i];
        }

        for (int i = 0; i < start; i++) {
            sum2 += distance[i];
        }

        for (int i = destination; i < len; i++) {
            sum2 += distance[i];
        }

        return Math.min(sum1, sum2);
    }





    public static void main(String[] args) {

    }

}
