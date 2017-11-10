package com.se.algorithm.greedy;

/**
 * Created by lty on 2017-11-3.
 */
public class GreedyPackage {

    public static final int MAX_WEIGHT = 150;
    public static int weights[] = {35, 30, 60, 50, 40, 10, 25};
    public static int values[] = {10, 40, 30, 50, 35, 40, 30};

    public void packageGreedy(int cap, int[] weights, int[] values) {
        int len = weights.length;
        double[] r = new double[len];
        int[] index = new int[len];
        for (int i = 0; i < len; i++) {
            r[i] = (double) values[i] / weights[i];
            index[i] = i;
        }

        double temp;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (r[i] < r[j]) {
                    temp = r[i];
                    r[i] = r[j];
                    r[j] = temp;

                    int x = index[i];
                    index[i] = index[j];
                    index[j] = x;
                }

            }
        }


        int total = 0;
        for (int i = 0; i < len; i++) {
            if (total + weights[index[i]] <= cap) {
                total += weights[index[i]];
            } else {
                break;
            }
        }
        System.out.println(total);


    }


    public static void main(String[] args) {
        GreedyPackage gp = new GreedyPackage();
        gp.packageGreedy(GreedyPackage.MAX_WEIGHT, GreedyPackage.weights, GreedyPackage.values);
    }


}
