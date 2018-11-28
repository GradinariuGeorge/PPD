package Complex;

public class OperationThread extends Thread {
    private Matrix firstMatrix;
    private Matrix secondMatrix;
    private Matrix result;
    private Operation operation;
    private int startingPoint, endingPoint;


    public OperationThread(Matrix firstMatrix, Matrix secondMatrix, Matrix result, Operation operation, int startPoit, int endingPoint) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.result = result;
        this.operation = operation;
        this.startingPoint = startPoit;
        this.endingPoint = endingPoint;
    }

    @Override
    public void run() {
        for (int i = startingPoint; i < endingPoint; i++) {
            int rowIndexResult = i / secondMatrix.getNrCols();
            int colIndexResult = i % secondMatrix.getNrCols();


            result.setElement(rowIndexResult, colIndexResult, operation.calculate(rowIndexResult,colIndexResult));
        }
    }
}
