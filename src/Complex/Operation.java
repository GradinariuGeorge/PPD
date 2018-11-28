package Complex;

@FunctionalInterface
public interface Operation<T> {
    T calculate( int startPoint, int endPoint);
}
