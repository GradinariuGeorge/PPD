package Complex;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter number of rows");
        int nrOfRows = keyboard.nextInt();
        System.out.println("enter number of columns");
        int nrOfColumns = keyboard.nextInt();
        System.out.println("Number of threads:");
        int numberOfThreads = keyboard.nextInt();
        Matrix<Real> matrixReal1= new Matrix<Real>(nrOfColumns,nrOfRows, new RealNumberGenerator<Real>());
        Matrix<Real> matrixReal2= new Matrix<Real>(nrOfColumns,nrOfRows, new RealNumberGenerator<Real>());
        Matrix<Real> matrixReal3= new Matrix<Real>(nrOfColumns,nrOfRows, new RealNumberGenerator<Real>());
        matrixReal1.init();
        matrixReal2.init();
        Matrix<Complex> matrixComplex1= new Matrix<Complex>(nrOfColumns,nrOfRows, new ComplexNumberGenerator<Complex>());
        Matrix<Complex> matrixComplex2= new Matrix<Complex>(nrOfColumns,nrOfRows, new ComplexNumberGenerator<Complex>());
        Matrix<Complex> matrixComplex3= new Matrix<Complex>(nrOfColumns,nrOfRows, new ComplexNumberGenerator<Complex>());
        matrixComplex1.init();
        matrixComplex2.init();
        List<Integer> integers= new ArrayList<>();
        integers.add(2);
        integers.add(4);
        integers.add(6);
        integers.add(8);

        for (Integer nrOfThreads: integers
             )
        {
            numberOfThreads=nrOfThreads;
            System.out.println("=======================================================================================================================================================");
            System.out.println("Multiply operation on real number :");
            Operation<Real> multiplyReal = (int rowIndexResult, int colIndexResult) -> {
                float resultValue = 0;
                for (int j = 0; j < nrOfColumns; j++) {
                    resultValue += matrixReal1.getElement(rowIndexResult, j).getNumber() * matrixReal2.getElement(j, colIndexResult).getNumber();
                }
                return new Real(resultValue);
            };

            ThreadService.runThreads(matrixReal1, matrixReal2, matrixReal3, numberOfThreads, multiplyReal);
            System.out.println("=======================================================================================================================================================");


            System.out.println("Multiply operation on complex number :");
            ;
            System.out.println();
            Operation<Complex> multiplyComplex = (int rowIndexResult, int colIndexResult) -> {
                Complex complex = new Complex();
                double resultValueReal = 0;
                double resultValueImaginari = 0;
                for (int j = 0; j < nrOfColumns; j++) {
                    resultValueReal += matrixComplex1.getElement(rowIndexResult, j).getReal() * matrixComplex2.getElement(j, colIndexResult).getReal() - matrixComplex1.getElement(rowIndexResult, j).getImaginary() * matrixComplex2.getElement(j, colIndexResult).getImaginary();
                    resultValueImaginari += matrixComplex1.getElement(rowIndexResult, j).getImaginary() * matrixComplex2.getElement(j, colIndexResult).getReal() + matrixComplex1.getElement(rowIndexResult, j).getReal() * matrixComplex2.getElement(j, colIndexResult).getImaginary();

                }
                return new Complex(resultValueReal, resultValueImaginari);
            };

            ThreadService.runThreads(matrixComplex1, matrixComplex2, matrixComplex3, numberOfThreads, multiplyComplex);
            System.out.println("=======================================================================================================================================================");

            System.out.println("Binary operation on real number :");
            System.out.println();

            Operation<Real> binaryOperatorReal = (int rowIndexResult, int colIndexResult) -> {

                double resultValue = 1 / (1 / (matrixReal1.getElement(rowIndexResult, colIndexResult).getNumber()) + 1 / (matrixReal2.getElement(rowIndexResult, colIndexResult).getNumber()));
                return new Real(resultValue);
            };

            ThreadService.runThreads(matrixReal1, matrixReal2, matrixReal3, numberOfThreads, binaryOperatorReal);
            System.out.println("=======================================================================================================================================================");

            System.out.println("Binary operation on complex numbers :");
            System.out.println();
            Operation<Complex> binaryOperatorComplex = (int rowIndexResult, int colIndexResult) -> {
                double resultValueReal = 0;
                double resultValueImaginary = 0;
                resultValueImaginary = matrixComplex1.getElement(rowIndexResult, colIndexResult).getImaginary() + matrixComplex2.getElement(rowIndexResult, colIndexResult).getImaginary();
                resultValueReal = matrixComplex1.getElement(rowIndexResult, colIndexResult).getReal() + matrixComplex2.getElement(rowIndexResult, colIndexResult).getReal();

                return new Complex(resultValueReal, resultValueImaginary);
            };

            ThreadService.runThreads(matrixComplex1, matrixComplex2, matrixComplex3, numberOfThreads, binaryOperatorComplex);
            System.out.println("=======================================================================================================================================================");

        }
    }
}
