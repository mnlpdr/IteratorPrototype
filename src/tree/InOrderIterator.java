package tree;

import java.util.Stack;

public class InOrderIterator<T extends Comparable<T>> implements TreeIterator<T> {
	private Stack<Node<T>> stack;
	private Node<T> currentNode;

	
	public InOrderIterator(Node<T> root) {
		stack = new Stack<>();
		currentNode = root;
	}
	
	@Override
	public boolean hasNext() {
		return !stack.isEmpty() || currentNode != null;
	}
	
	@Override
	public T next() {
		while (currentNode != null) {
			stack.push(currentNode);
			currentNode = currentNode.left;
		}
		
		Node<T> nextNode = stack.pop();
		currentNode = nextNode.right;
		
		return nextNode.value;
				
	}
}