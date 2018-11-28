package Complex;


import java.util.concurrent.ThreadLocalRandom;

public class ComplexNumberGenerator<T> extends MatrixNumberGenerator  {
    @Override
    public T generateRandomNumber() {
        Complex number= new Complex();
        double real = Math.floor(ThreadLocalRandom.current().nextDouble(100, 200) * 100) / 100;
        double imaginary = Math.floor(ThreadLocalRandom.current().nextDouble(100, 200) * 100) / 100;
        number.setReal(real);
        number.setImaginary(imaginary);
        return (T)number;
    }

}
