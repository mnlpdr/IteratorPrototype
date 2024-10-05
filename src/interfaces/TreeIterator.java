package interfaces;

public interface TreeIterator<T extends Comparable<T>> {
    boolean hasNext();
    T next();
}
