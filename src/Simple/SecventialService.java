package Simple;



public class SecventialService {
    private Matrix matrix1,matrix2,result;
    private boolean debug;

    public SecventialService(Matrix matrix1, Matrix matrix2, Matrix result, boolean debug) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.debug = debug;
    }

    public void multiplyMatricesSecv() {
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < matrix1.getNrRows(); i++) {
            for(int j = 0; j < matrix2.getNrCols(); j++) {
                int value = 0;
                for(int k = 0; k < matrix1.getNrCols(); k++) {
                    value += matrix1.find(i, k) *  matrix2.find(k, j);
                }
                result.replace(i, j, value);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Multiply time secvential: " + (endTime - startTime));
        if(debug) {
            result.print();
        }
    }

    public void addMatricesSecv() {
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < matrix1.getNrRows(); i++) {
            for(int j = 0; j < matrix1.getNrCols(); j++) {
                result.replace(i, j, matrix1.find(i, j) + matrix2.find(i, j));
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Add time secvential: " + (endTime - startTime));
        if(debug) {
            result.print();
        }
    }

}
