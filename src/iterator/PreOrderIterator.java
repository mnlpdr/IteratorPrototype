package iterator;

import java.util.Stack;

import interfaces.TreeIterator;
import tree.Node;

public class PreOrderIterator<T extends Comparable<T>> implements TreeIterator<T> {
    private Stack<Node<T>> stack;

    public PreOrderIterator(Node<T> root) {
        stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException("No more elements in the tree");
        }

        Node<T> currentNode = stack.pop();
        if (currentNode.right != null) {
            stack.push(currentNode.right);
        }
        if (currentNode.left != null) {
            stack.push(currentNode.left);
        }

        return currentNode.value;
    }
}
