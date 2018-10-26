package Complex;

import java.util.Random;

public class RealNumberGenerator<T> extends MatrixNumberGenerator {
    @Override
    public T generateRandomNumber() {
        Random random= new Random();
        Real number = new Real();
        number.setNumber(random.nextDouble());

        return (T)number;
    }
}
