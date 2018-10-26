package Simple;

public class Controller {
    private Matrix matrix1, matrix2, result;
    private int numberOfThreads;
    private OperationType operationType;
    private ThreadService Threads[];
    private boolean debug;
    private  SecventialService secventialService;

    public Controller(Matrix matrix1, Matrix matrix2, Matrix result, int numberOfThreads, OperationType operationType, boolean debug) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.numberOfThreads = numberOfThreads;
        this.operationType = operationType;
        this.Threads= new ThreadService[numberOfThreads];
        this.secventialService = new SecventialService(matrix1, matrix2, result, debug);

    }



    private void operateMatrices() {
        long startTime = System.currentTimeMillis();
        int start = 0;
        int totalElements = matrix1.getNrRows() * matrix2.getNrCols();
        int chuck = totalElements / numberOfThreads;
        int rest = totalElements % numberOfThreads;
        for (int i = 0; i < numberOfThreads; i++) {
            int end = start + chuck;
            if (rest > 0) {
                rest--;
                end++;
            }
            ThreadService thread = new ThreadService(matrix1, matrix2, result, start, end, operationType);
            start = end;
            Threads[i] = thread;
            thread.start();
        }
        for (int i = 0; i < numberOfThreads; i++) {
            try {
                Threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("Time on threads: " + (timeEnd - startTime));
        if (debug) {
            result.print();
        }
    }

    public void controlActivity() {
        if (operationType.equals("SUM")) {
            secventialService.addMatricesSecv();
            operateMatrices();
        }
        switch (operationType) {
            case SUM:
                secventialService.addMatricesSecv();
                operateMatrices();
                break;
            case MULTIPLY:
                secventialService.multiplyMatricesSecv();
                operateMatrices();
                break;
        }

    }
}