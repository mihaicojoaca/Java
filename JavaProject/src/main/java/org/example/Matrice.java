package org.example;

public class Matrice {
    public static final Integer n = 6;
    public static String[][] matrix = new String[100][100];

    public static String[][] generate() {
        Integer count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    matrix[i][j] = count.toString();
                } else {
                    matrix[i][n - j - 1] = count.toString();
                }
                count++;
            }

        }
        return matrix;
    }
}
