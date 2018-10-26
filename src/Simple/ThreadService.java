package Simple;



public class ThreadService extends Thread {
    private String operationType;
    private int startingPoint, endingPoint;
    private Matrix matrix1, matrix2, result;

    public ThreadService(Matrix matrix1, Matrix matrix2, Matrix result, int startingPoint, int endingPoint, OperationType operationType) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.operationType = operationType.toString();
    }

    @Override
    public void run() {
        switch(operationType) {
            case "SUM":
                addMatrices();
                break;
            case "MULTIPLY":
                multiplyMatrices();
                break;

        }

    }

    private void multiplyMatrices() {
        for(int i = startingPoint; i < endingPoint; i++) {
            int rowIndexResult = i / matrix2.getNrCols();
            int colIndexResult = i % matrix2.getNrCols();
            int resultValue = 0;
            for(int j = 0; j < matrix1.getNrCols(); j++) {
                resultValue += matrix1.find(rowIndexResult, j) + matrix2.find(j, colIndexResult);
            }
            result.replace(rowIndexResult, colIndexResult, resultValue);
        }
    }


    private void addMatrices() {
        for(int i = startingPoint; i < endingPoint; i++) {
            int valueMatrix1 = matrix1.find(i / matrix1.getNrCols(), i % matrix1.getNrCols());
            int valueMatrix2 = matrix2.find(i / matrix2.getNrCols(), i % matrix2.getNrCols());
            result.replace(i / result.getNrCols(), i % result.getNrCols(), valueMatrix1 + valueMatrix2);
        }
    }
}
