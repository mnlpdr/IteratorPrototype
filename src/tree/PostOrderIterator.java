package tree;

import java.util.Stack;

public class PostOrderIterator<T extends Comparable<T>> implements TreeIterator<T> {
    private Stack<Node<T>> stack;
    private Node<T> previousNode;

    public PostOrderIterator(Node<T> root) {
        stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        previousNode = null;
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        while (!stack.isEmpty()) {
            Node<T> currentNode = stack.peek();

            if (previousNode == null || previousNode.left == currentNode || previousNode.right == currentNode) {
                if (currentNode.left != null) {
                    stack.push(currentNode.left);
                } else if (currentNode.right != null) {
                    stack.push(currentNode.right);
                }
            } else if (currentNode.left == previousNode) {
                if (currentNode.right != null) {
                    stack.push(currentNode.right);
                }
            } else {
                stack.pop();
                previousNode = currentNode;
                return currentNode.value;
            }
            previousNode = currentNode;
        }
        throw new java.util.NoSuchElementException("No more elements in the tree");
    }
}
