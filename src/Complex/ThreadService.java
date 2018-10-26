package Complex;

public class ThreadService {
    private Matrix m1;
    private Matrix m2;
    private int nrOfThreads;
    private Operation operation;
    private int startingPoint, endingPoint;

    public ThreadService(Matrix m1, Matrix m2, int nrOfThreads, Operation operation, int startingPoint, int endingPoint) {
        this.m1 = m1;
        this.m2 = m2;
        this.nrOfThreads = nrOfThreads;
        this.operation = operation;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
    }




}
