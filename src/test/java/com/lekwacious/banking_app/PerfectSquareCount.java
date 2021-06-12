package com.lekwacious.banking_app;

public class PerfectSquareCount {
    public static void main(String[] args)
    {

        int[][] twoD = new int[2][3];
        int count = 0;
        for (int row = 0; row < twoD.length; row++) {
            for (int column = 0; column < twoD[row].length; column++ ) {
                twoD[row][column] = row + column;
                for (int k = 1; k * k <= twoD[row][column]; k++) {
                    if (k * k == twoD[row][column]) {
                        count++;
                    }
                }
            }
            System.out.println();
        }
        System.out.print(count);

    }

}
