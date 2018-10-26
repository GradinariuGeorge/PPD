package Complex;

import java.util.ArrayList;
import java.util.List;

public class Matrix<T> {

    List<List<T>> cells;
    int nrcols;
    int nrrows;
    MatrixNumberGenerator matrixNumberGenerator;

    public Matrix(int nrcols, int nrrows, MatrixNumberGenerator matrixNumberGenerator) {
        this.nrcols = nrcols;
        this.nrrows = nrrows;
        cells = new ArrayList<>();
        this.matrixNumberGenerator = matrixNumberGenerator;

        for(int j=0;j<nrrows;j++){
            cells.add(new ArrayList<>());
            for(int k=0;k<nrcols;k++){
                cells.get(j).add(null);
            }
        }
    }

    public void init(){
        for(int j=0;j<nrrows;j++){
            for(int k=0;k<nrcols;k++){
                cells.get(j).set(k,(T) matrixNumberGenerator.generateRandomNumber());
            }
        }
    }

    public void print() {

        for (int i = 0; i < nrrows; i++) {
            for (int j = 0; j < nrcols; j++) {
                System.out.print(cells.get(i).get(j) + " ");
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

    public int getNrcols() {
        return nrcols;
    }

    public void setNrcols(int nrcols) {
        this.nrcols = nrcols;
    }

    public int getNrrows() {
        return nrrows;
    }

    public void setNrrows(int nrrows) {
        this.nrrows = nrrows;
    }
}
