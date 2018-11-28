package Complex;

public class Real {
    double number;

    public Real(double number) {
        this.number = number;
    }

    public Real() {
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return  String.valueOf(number);
    }
}
