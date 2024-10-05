package factory;

import interfaces.TreeIterator;
import iterator.InOrderIterator;
import iterator.LevelOrderIterator;
import iterator.PostOrderIterator;
import iterator.PreOrderIterator;
import tree.Node;
import utils.traversalTypeEnum;

public class TreeIteratorFactory {

    // Método estático que devolve o iterador baseado no tipo de travessia
    public static <T extends Comparable<T>> TreeIterator<T> getIterator(traversalTypeEnum type, Node<T> root) {
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
