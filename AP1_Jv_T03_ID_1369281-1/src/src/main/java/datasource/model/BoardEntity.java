package datasource.model;

import java.util.Arrays;

public class BoardEntity {
    public static final int SIZE = 3;
    private int[][] matrix;

    public BoardEntity() {
        this.matrix = new int[SIZE][SIZE];
    }

    public BoardEntity(int[][] matrix) {
        setMatrix(matrix);
    }

    public int[][] getMatrix() {
        if (matrix == null) {
            return null;
        }
        int[][] copy = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            copy[i] = Arrays.copyOf(matrix[i], SIZE);
        }
        return copy;
    }

    public void setMatrix(int[][] matrix) {
        if (matrix == null || matrix.length != SIZE || matrix[0].length != SIZE) {
            throw new IllegalArgumentException("Размер матрицы должен быть 3x3");
        }
        this.matrix = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            this.matrix[i] = Arrays.copyOf(matrix[i], SIZE);
        }
    }
}