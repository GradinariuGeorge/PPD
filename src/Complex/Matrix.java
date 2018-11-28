package Complex;

import java.util.ArrayList;
import java.util.List;

public class Matrix<T> {

    List<List<T>> cells;
    int nrCols;
    int nrRows;
    MatrixNumberGenerator matrixNumberGenerator;

    public Matrix(int nrCols, int nrRows, MatrixNumberGenerator matrixNumberGenerator) {
        this.nrCols = nrCols;
        this.nrRows = nrRows;
        cells = new ArrayList<>();
        this.matrixNumberGenerator = matrixNumberGenerator;

        for(int j = 0; j< nrRows; j++){
            cells.add(new ArrayList<>());
            for(int k = 0; k< nrCols; k++){
                cells.get(j).add(null);
            }
        }
    }

    public void init(){
        for(int j = 0; j< nrRows; j++){
            for(int k = 0; k< nrCols; k++){
                cells.get(j).set(k,(T) matrixNumberGenerator.generateRandomNumber());
            }
        }
    }

    public void print() {

        for (int i = 0; i < nrRows; i++) {
            for (int j = 0; j < nrCols; j++) {
//                System.out.print(cells.get(i).get(j) + " ");
                System.out.print((T)(cells.get(i).get(j)).toString() + " ");
            }
            System.out.println("");
        }
    }

    public void setElement(int row, int column,T element){
        cells.get(row).set(column,element);
    }

    public T getElement(int row, int column){
        return cells.get(row).get(column);
    }

    public int getNrCols() {
        return nrCols;
    }

    public void setNrCols(int nrCols) {
        this.nrCols = nrCols;
    }

    public int getNrRows() {
        return nrRows;
    }

    public void setNrRows(int nrRows) {
        this.nrRows = nrRows;
    }
}
