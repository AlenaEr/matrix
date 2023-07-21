package com.example.matrix.computer_science;

import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {

//        int numberMatrix[][] = new int[10][];
//        for (int i = 0; i < numberMatrix.length; i++) {
//            int mas[] = new int[i + 1];
//
//            for (int j = 0; j < mas.length; j++) {
//                mas[j] = 1;
//            }
//            numberMatrix[i] = mas;
//        }
//
//        printMatrix(numberMatrix);


        System.out.println("first matrix");

/**
 * 11
 * 1
 * 11
 * 1
 * 11
 */
        int numberMatrix1[][] = new int[5][];
        for (int i = 0; i < numberMatrix1.length; i++) {
            int newMasLength = (i % 2 == 0) ? 2 : 1;
            int mas[] = new int[newMasLength];
            for (int j = 0; j < mas.length; j++) {
                mas[j] = 1;
            }
            numberMatrix1[i] = mas;
        }
        printMatrix(numberMatrix1);

        System.out.println("second matrix");

        /**
         * 1
         * 22
         * 333
         * 4444
         * 55555
         * 666666
         */
        int numberMatrix[][] = new int[6][];
        for (int i = 0; i < numberMatrix.length; i++) {
            int mas[] = new int[i + 1];

            for (int j = 0; j < mas.length; j++) {
                mas[j] = i + 1;
            }
            numberMatrix[i] = mas;
        }
        printMatrix(numberMatrix);


/**
 * 1
 * 11
 * 121
 * 1331
 * 14641
 */
        System.out.println("third matrix");
        int matrix[][] = new int[5][];
        int test[][] = new int[][]{};
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[i + 1];
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0 || j == matrix[i].length - 1) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i - 1][j - 1];
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }


//        int numberMatrix3[][] = new int[5][];
//        for (int i = 0; i < numberMatrix3.length; i++) {
//            int mas[] = new int[i];
//            int num = 1;
//            for (int j = 0; j <= mas.length; j++) {
//                System.out.print(num + " ");
//                num = num * (i - j) / (j + 1);
////                System.out.println("i = " + i + " j = " + j);
//            }
//            System.out.println();
//        }


//        public static void printMatrix(int rows) {
//            for (int i = 0; i < rows; i++) {
//                int num = 1;
//                for (int j = 0; j <= i; j++) {
//                    System.out.print(num + " ");
//                    num = num * 10 + 1;
//                }
//                System.out.println();



}

    private static void printMatrix(int[][] numberMatrix) {
        for (int i = 0; i < numberMatrix.length; i++) {
            int[] innerMas = numberMatrix[i];
            for (int j = 0; j < innerMas.length; j++) {
                System.out.print(innerMas[j] + " ");
            }
            System.out.println();
        }
    }
}
