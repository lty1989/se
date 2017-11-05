package com.se;

import java.util.LinkedList;

public class Graph {
    private int vertexSize;
    private int[] vertexts;
    private boolean[] isVisted;
    private int[][] matrix;
    public static final int MAX_WEIGHT = 1000;


    public Graph(int vertexSize) {
        this.vertexSize = vertexSize;
        matrix = new int[this.vertexSize][this.vertexSize];
        vertexts = new int[this.vertexSize];
        isVisted = new boolean[this.vertexSize];
        for (int i = 0; i < this.vertexSize; i++) {
            vertexts[i] = i;
            isVisted[i] = false;
        }

    }

    /**
     * 获取某个顶点的出度
     *
     * @param index
     * @return
     */
    public int getOutDegree(int index) {
        int outDegree = 0;
        for (int i = 0; i < matrix[index].length; i++) {
            int weight = matrix[index][i];
            if (weight > 0 && weight < MAX_WEIGHT) {
                outDegree++;
            }
        }
        return outDegree;
    }

    /**
     * 获取某个顶点的入度
     *
     * @param index
     * @return
     */
    public int getInDegree(int index) {
        int inDegree = 0;
        for (int i = 0; i < matrix[index].length; i++) {
            int weight = matrix[i][index];
            if (weight > 0 && weight < MAX_WEIGHT) {
                inDegree++;
            }
        }
        return inDegree;
    }


    /**
     * 获取某个顶点的第一个临接点
     *
     * @param index
     * @return
     */
    private int getFirstNeighbor(int index) {

        for (int i = 0; i < vertexSize; i++) {
            int v = matrix[index][i];
            if (v > 0 && v < MAX_WEIGHT) {
                return i;
            }
        }
        return -1;

    }


    /**
     * @param v
     * @param index
     * @return
     */
    private int getNextNeighbor(int v, int index) {

        for (int i = index + 1; i < vertexSize; i++) {
            if (matrix[v][i] > 0 && matrix[v][i] < MAX_WEIGHT) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 对外公开遍历方法
     */
    public void depthFirstSearch() {
        isVisted = new boolean[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            if (!isVisted[i]) {
                depthFirstSearch(i);
            }
        }
        isVisted = new boolean[vertexSize];


    }

    /**
     * 图的广度遍历
     */
    public void broadFisrtSearch() {
        isVisted = new boolean[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            if (!isVisted[i]) {
                broadFisrtSearch(i);
            }
        }
    }

    private void broadFisrtSearch(int i) {
        int u, w;
        LinkedList<Integer> queue = new LinkedList<>();
        isVisted[i] = true;
        queue.add(i);
        while (!queue.isEmpty()) {
            u = queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisted[w]) {
                    System.out.println("访问到" + w);
                    isVisted[w] = true;
                    queue.add(w);
                }
                w = getNextNeighbor(u, w);
            }

        }


    }

    /**
     * 普里姆
     */
    public void prim() {
        //最小代价顶点权值
        int[] lowest = new int[vertexSize];
        int[] adjvex = new int[vertexSize];
        int min, minIdx, sum = 0;
        for (int i = 1; i < vertexSize; i++) {
            lowest[i] = matrix[0][i];
        }
        for (int i = 1; i < vertexSize; i++) {
            min = MAX_WEIGHT;
            minIdx = 0;
            for (int j = 1; j < vertexSize; j++) {
                if (lowest[j] < min && lowest[j] < 0) {
                    min = lowest[j];
                    minIdx = j;
                }
            }
            sum += min;
            lowest[minIdx] = 0;
            for (int j = 1; j < vertexSize; j++) {

                if (lowest[j] > 0 && matrix[minIdx][j] < lowest[j]) {
                    lowest[j] = matrix[minIdx][j];
                    adjvex[j] = minIdx;
                }

            }
        }


    }


    /**
     * 图的深入优先遍历
     *
     * @param index
     */
    public void depthFirstSearch(int index) {
        isVisted[index] = true;
        int v = getFirstNeighbor(index);
        while (v != -1) {
            if (!isVisted[v]) {
                System.out.println("访问到了" + v + "顶点");
                depthFirstSearch(v);
            }
            v = getNextNeighbor(index, v);
        }

    }

    /**
     * 获取两个顶点的权值
     *
     * @param v1
     * @param v2
     * @return 有返回权值  没有返回-1
     */
    public int getWeight(int v1, int v2) {

        if (matrix[v1][v2] > 0 && matrix[v1][v2] < MAX_WEIGHT) {
            return matrix[v1][v2];
        }
        return -1;
    }


    public int[] getVertexts() {
        return vertexts;
    }

    public void setVertexts(int[] vertexts) {
        this.vertexts = vertexts;
    }


    public static void main(String[] args) {
        Graph graph = new Graph(5);
        int[] a1 = {0, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 6};
        int[] a2 = {9, 0, 3, MAX_WEIGHT, MAX_WEIGHT};
        int[] a3 = {2, MAX_WEIGHT, 0, 5, MAX_WEIGHT};
        int[] a4 = {MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0, 1};
        int[] a5 = {MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0};

        graph.matrix[0] = a1;
        graph.matrix[1] = a2;
        graph.matrix[2] = a3;
        graph.matrix[3] = a4;
        graph.matrix[4] = a5;


        int degree = graph.getOutDegree(0);
        System.out.println("出度为：" + degree);


    }

}
