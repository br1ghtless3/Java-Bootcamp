package web.model;

import java.util.Arrays;

public class BoardDto {
    private int[][] matrix;

    public BoardDto() {
    }

    public BoardDto(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        if (matrix == null) {
            return null;
        }
        int[][] copy = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            copy[i] = matrix[i] != null ? Arrays.copyOf(matrix[i], matrix[i].length) : null;
        }
        return copy;
    }

    public void setMatrix(int[][] matrix) {
        if (matrix == null) {
            this.matrix = null;
            return;
        }
        this.matrix = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            this.matrix[i] = matrix[i] != null ? Arrays.copyOf(matrix[i], matrix[i].length) : null;
        }
    }
}