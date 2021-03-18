package com.dukz.JMM;

/**
 * @author dukezheng
 * @ClassName Test1
 * @Description
 * @date 2021/3/16 20:23
 * @Version 1.0
 */
public class Test1 {
    public static final int ROW = 1024*1024;
    public static final int COL = 8;
    public static void main(String[] args) {
        int[][] arr = new int[ROW][COL];
        int sum = 0;
        // 横向遍历
        long marked = System.currentTimeMillis();
        for (int i = 0; i < ROW; i += 1) {
            for (int j = 0; j < COL; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println("Horizontal times:" + (System.currentTimeMillis() - marked)+ "ms");

        marked = System.currentTimeMillis();
        // 纵向遍历
        for (int i = 0; i < COL; i += 1) {
            for (int j = 0; j < ROW; j++) {
                sum += arr[j][i];
            }
        }
        System.out.println("Vertical times:" + (System.currentTimeMillis() - marked)+ "ms");
    }
}
