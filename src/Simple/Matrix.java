package Simple;

import java.util.Random;

public class Matrix {
    private int nrRows;
    private int nrCols;
    private int[][] elems;

    public Matrix() {

    }

    public Matrix(int nrRows, int nrCols) {
        this.nrRows = nrRows;
        this.nrCols = nrCols;
        this.elems = new int[nrRows][nrCols];
    }

    public int find(int row, int col) {
        return this.elems[row][col];
    }

    public void replace(int row, int col, int value) {
        this.elems[row][col] = value;
    }

    public void populateWithRandomValues() {
        final Random random = new Random();
        for(int i = 0; i < nrRows; i++) {
            for(int j = 0; j < nrCols; j++) {
                this.elems[i][j] = random.nextInt();
            }
        }
    }

    public int getNrRows() {
        return nrRows;
    }

    public void setNrRows(int nrRows) {
        this.nrRows = nrRows;
    }

    public int getNrCols() {
        return nrCols;
    }

    public void setNrCols(int nrCols) {
        this.nrCols = nrCols;
    }

    public int[][] getElems() {
        return elems;
    }

    public void setElems(int[][] elems) {
        this.elems = elems;
    }

    public void print() {
        for(int i = 0; i < nrRows; i++) {
            for(int j = 0; j < nrCols; j++) {
                System.out.print(this.elems[i][j] + " ");
            }
            System.out.println();
        }
    }
}
