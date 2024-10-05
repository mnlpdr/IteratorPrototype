package tree;

public class TreeIteratorFactory {

    // Método estático que devolve o iterador baseado no tipo de travessia
    public static <T extends Comparable<T>> TreeIterator<T> getIterator(TraversalType type, Node<T> root) {
        switch (type) {
            case PRE_ORDER:
                return new PreOrderIterator<>(root);
            case IN_ORDER:
                return new InOrderIterator<>(root);
            case POST_ORDER:
                return new PostOrderIterator<>(root);
            case LEVEL_ORDER:
                return new LevelOrderIterator<>(root);
            default:
                throw new IllegalArgumentException("Invalid traversal type");
        }
    }
}
