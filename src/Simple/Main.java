package Simple;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter number of rows");
        int m = keyboard.nextInt();
        System.out.println("enter number of columns");
        int n = keyboard.nextInt();
        System.out.println("Number of threads:");
        int threads = keyboard.nextInt();
        System.out.println("Operation");
        String operation = keyboard.next();
        System.out.println("Generate new Matrix:");
        String generate = keyboard.next();
        Matrix matrix1 = new Matrix(m, n);
        Matrix matrix2 = new Matrix(m, n);
        Matrix matrix3 = new Matrix(m, n);
        Matrix matrix4 = new Matrix(m, n);
        matrix1.populateWithRandomValues();
        matrix2.populateWithRandomValues();
        FileRepo fileRepo = new FileRepo();
        if(generate.equals("true")) {
            fileRepo.writeMatrix("matrix1.txt", matrix1.getElems(), matrix1.getNrRows(), matrix1.getNrCols());
            fileRepo.writeMatrix("matrix2.txt", matrix2.getElems(), matrix1.getNrRows(), matrix1.getNrCols());
        }
        fileRepo.readMatrix(matrix3, "matrix1.txt");
        fileRepo.readMatrix(matrix4, "matrix2.txt");


        Matrix result = new Matrix(m, n);

        System.out.println("Number of threads " + threads);
        Controller controller = new Controller(matrix3, matrix4, result, threads, OperationType.valueOf(operation), false);
        controller.controlActivity();

    }
}
