package com.se.graph;

/**
 * Created by lty on 2017-11-6.
 */
public class Dijistra {

    private final static int MAXVEX = 9;
    private final static int MAX_WEIGHT = 65536;
    private int shortTablePAth[] = new int[MAXVEX];

    /**
     * 获取一个图最短路径
     *
     * @param g
     */
    public void shortestPathDijstra(Graph g) {
        int min;
        int k;//记录下标
        boolean isgetPath[] = new boolean[MAXVEX];
        for (int i = 0; i < g.getVertexSize(); i++) {
            shortTablePAth[i] = g.getMatrix()[0][i];
        }
        shortTablePAth[0] = 0;
        isgetPath[0] = true;
        for (int i = 1; i < g.getVertexSize(); i++) {
            min = MAX_WEIGHT;
            for (int j = 0; j < g.getVertexSize(); j++) {
                if (!isgetPath[j] && shortTablePAth[j] < min) {
                    k = j;
                    min = shortTablePAth[j];
                }
            }
        }


    }

}
