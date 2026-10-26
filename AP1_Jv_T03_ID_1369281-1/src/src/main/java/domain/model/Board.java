package domain.model;

import java.util.Arrays;

public class Board {
    public static final int SIZE = 3;
    public static final int EMPTY = 0;
    public static final int PLAYER = 1;
    public static final int COMPUTER = 2;

    private int[][] matrix;

    public Board() {
        this.matrix = new int[SIZE][SIZE];
    }

    public Board(int[][] matrix) {
        setMatrix(matrix);
    }

    public int[][] getMatrix() {
        int[][] copy = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            copy[i] = Arrays.copyOf(this.matrix[i], SIZE);
        }
        return copy;
    }

    public void setMatrix(int[][] newMatrix) {
        if (newMatrix == null || newMatrix.length != SIZE || newMatrix[0].length != SIZE) {
            throw new IllegalArgumentException("Размер игрового поля должен быть 3x3");
        }
        this.matrix = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            this.matrix[i] = Arrays.copyOf(newMatrix[i], SIZE);
        }
    }

    public int getCell(int row, int col) {
        checkBounds(row, col);
        return matrix[row][col];
    }

    public void setCell(int row, int col, int value) {
        checkBounds(row, col);
        matrix[row][col] = value;
    }

    public boolean isEmpty(int row, int col) {
        return getCell(row, col) == EMPTY;
    }

    public Board deepCopy() {
        return new Board(this.matrix);
    }

    private void checkBounds(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            throw new IndexOutOfBoundsException("Координаты выходят за пределы игрового поля.");
        }
    }
}
