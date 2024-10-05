package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderIterator<T extends Comparable<T>> implements TreeIterator<T> {
    private Queue<Node<T>> queue;

    public LevelOrderIterator(Node<T> root) {
        queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root); // adiciona a raiz fila se não for nula
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException("No more elements in the tree");
        }

        Node<T> currentNode = queue.poll();
        if (currentNode.left != null) {
            queue.offer(currentNode.left);
        }
        if (currentNode.right != null) {
            queue.offer(currentNode.right);
        }

        return currentNode.value;
    }
}
