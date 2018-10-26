package generic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    static int n, m;

    public static double solve(String filename, int threadPoolSize,
                               int T, boolean debug, MatrixOperaterFactory<Callable<Void>> matrixOperaterFactory)
            throws FileNotFoundException, InterruptedException {
        long start = System.currentTimeMillis();
        Scanner in = new Scanner(new File(filename));
        n = in.nextInt();
        m = in.nextInt();
        int a[][] = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                a[i][j] = in.nextInt();
            }
        }
        int b[][] = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                b[i][j] = in.nextInt();
            }
        }
        int sum[][] = new int[n][m];
        ArrayList threads = new ArrayList();
        for (int i = 0; i < Math.min(n, T); ++i) {
            threads.add(matrixOperaterFactory.newInstance(i, T, a, b, sum, debug));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        List<Future<Void>> futureList = executorService.invokeAll(threads);
        executorService.shutdownNow();
        double time = (System.currentTimeMillis() - start) ;
        if (debug) {
            System.out.println("ThreadPoolSize: " + threadPoolSize);
            System.out.println("Number of threads: " + T);
            System.out.println("Operations took: " + time + " seconds");
        }
        return time;
    }

    public static double solve2(int threadPoolSize, int n, int m,
                                int T, boolean debug, MatrixOperaterFactory<Callable<Void>> matrixOperaterFactory)
            throws FileNotFoundException, InterruptedException {
        Random random = new Random();

        int a[][] = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                a[i][j] = random.nextInt();
            }
        }
        int b[][] = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                b[i][j] = random.nextInt();
            }
        }
        long start = System.currentTimeMillis();
        int sum[][] = new int[n][m];
        ArrayList threads = new ArrayList();
        for (int i = 0; i < Math.min(n, T); ++i) {
            threads.add(matrixOperaterFactory.newInstance(i, T, a, b, sum, debug));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        List<Future<Void>> futureList = executorService.invokeAll(threads);
        executorService.shutdownNow();
        double time = (System.currentTimeMillis() - start);
        if (debug) {
            System.out.println("ThreadPoolSize: " + threadPoolSize);
            System.out.println("Number of threads: " + T);
            System.out.println("Operations took: " + time + " seconds");
        }
        return time;
    }

    static void writeMatrix(String filename, int[][] matrix) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    bw.write(matrix[i][j] + ",");
                }
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Random random = new Random();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter an integer m");
        int m = keyboard.nextInt();

        System.out.println("enter an integer n");
        int n = keyboard.nextInt();
        int i, j;
        int[][] matrix1 = new int[m][n],
                matrix2 = new int[m][n];
        for (i = 0; i < m; i++)
            for (j = 0; j < m; j++) {
                matrix1[i][j] = random.nextInt(200 - 100);
                matrix2[i][j] = random.nextInt(200 - 100);
            }
        writeMatrix("matrix1.txt", matrix1);
        writeMatrix("matrix2.txt", matrix2);
        double time = solve2(2, n, m, 2, true, new AdditionerFactory());
        System.out.println(time);


//        try (Writer fileWriter = new BufferedWriter(new OutputStreamWriter(
////                new FileOutputStream("filename.txt"), "utf-8"))) {
////            for (String add : adds) {
////                for (int aTP : TP) {
////                    for (int aT : T) {
////                        double time = solve("data/" + add, aTP, aT, true, new generic.AdditionerFactory());
////                        fileWriter.write("add ");
////                        fileWriter.write(String.valueOf(n));
////                        fileWriter.write(" ");
////                        fileWriter.write(String.valueOf(aTP));
////                        fileWriter.write(" ");
////                        fileWriter.write(String.valueOf(aT));
////                        fileWriter.write(" ");
////                        fileWriter.write(String.valueOf(time));
////                        fileWriter.write("\n");
////                    }
////                }
////            }
////            for (String mult : mults) {
////                for (int aTP : TP) {
////                    for (int aT : T) {
////                        double time = solve("data/" + mult, aTP, aT, true, new generic.MultiplierFactory());
////                        fileWriter.write("mult ");
////                        fileWriter.write(String.valueOf(n));
////                        fileWriter.write(" ");
////                        fileWriter.write(String.valueOf(aTP));
////                        fileWriter.write(" ");
////                        fileWriter.write(String.valueOf(aT));
////                        fileWriter.write(" ");
////                        fileWriter.write(String.valueOf(time));
////                        fileWriter.write("\n");
////                    }
////                }
////            }
////        }


    }
}