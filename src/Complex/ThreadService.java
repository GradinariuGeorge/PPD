package Complex;

public class ThreadService {

    public static void  runThreads(Matrix matrix1,Matrix matrix2,Matrix result,int numberOfThreads,Operation operation){
        Thread Threads[]=new Thread[numberOfThreads];
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
            OperationThread thread = new OperationThread(matrix1, matrix2, result,operation, start, end);
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
//        result.print();
        System.out.println("Time on threads: "+numberOfThreads +"    :" + (timeEnd - startTime));

    }

}
