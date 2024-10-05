package tree;

import factory.TreeIteratorFactory;
import interfaces.BstPrototype;
import interfaces.TreeIterator;
import utils.traversalTypeEnum;

public class BinarySearchTree<T extends Comparable<T>> implements BstPrototype {
	private Node<T> root;

	public BinarySearchTree() {
		this.root = null;
	}

	public BinarySearchTree(T value) {
		this.root = new Node<>(value);
	}

	// Clonagem

	public BinarySearchTree(BinarySearchTree<T> target) { // Construtor de cópia
		if (target != null && target.root != null) {
			this.root = cloneRecursive(target.root); // Clona os nós da árvore existente
		} else {
			this.root = null;
		}
	}

	@Override
	public BinarySearchTree<T> getClone() { // Metodo de clonagem 
		BinarySearchTree<T> clonedTree = new BinarySearchTree<>(this);
		return clonedTree;
	}

	
	private Node<T> cloneRecursive(Node<T> current) { // Método recursivo para clonar cada nó da árvore
		if (current == null) {
			return null;
		}

		// Cria um novo nó copiando o valor do nó atual
		Node<T> newNode = new Node<>(current.value);
		// Clona o subárvore à esquerda e à direita
		newNode.left = cloneRecursive(current.left);
		newNode.right = cloneRecursive(current.right);

		return newNode;
	}

	// Iterator

	public TreeIterator<T> getIterator(traversalTypeEnum type) {
		return TreeIteratorFactory.getIterator(type, root);
	}


	public T search(T value) {
		if (!isEmpty()) {
			Node<T> node = search(root, value);
			return node != null ? node.value : null;
		} else
			return null;
	}

	private Node<T> search(Node<T> root, T key) {
		if (root == null) {
			return null;
		} else if (key.compareTo(root.value) < 0) {
			return search(root.left, key);
		} else if (key.compareTo(root.value) > 0) {
			return search(root.right, key);
		} else
			return root;
	}

	public boolean contains(T key) {
		return contains(root, key);
	}

	private boolean contains(Node<T> root, T key) {
		if (root == null)
			return false;
		else if (key.compareTo(root.value) < 0)
			return contains(root.left, key);
		else if (key.compareTo(root.value) > 0)
			return contains(root.right, key);
		else
			return true;
	}

	public void add(T value) {
		this.root = addRecursive(this.root, value);
	}

	private Node<T> addRecursive(Node<T> root, T value) {
		if (root == null) {
			return new Node<T>(value);
		} else if (value.compareTo(root.value) < 0) {
			root.left = addRecursive(root.left, value);
		} else if (value.compareTo(root.value) > 0) {
			root.right = addRecursive(root.right, value);
		} else {
			return root;
		}
		return root;
	}

	public T delete(T key) {
		T node = search(key);
		if (node != null) {
			this.root = delete(root, key);
			return node;
		} else
			return null;
	}

	private Node<T> delete(Node<T> root, T data) {
		if (root == null)
			return null;
		else if (data.compareTo(root.value) < 0) {
			root.left = delete(root.left, data);
		} else if (data.compareTo(root.value) > 0) {
			root.right = delete(root.right, data);
		} else {
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.right == null) {
				return root.left;
			} else if (root.left == null) {
				return root.right;
			} else {
				root.value = findMax(root.left);
				root.left = delete(root.left, root.value);
			}
		}
		return root;
	}

	private T findMax(Node<T> root) {
		while (root.right != null) {
			root = root.right;
		}
		return root.value;
	}


	public int size() {
		return size(root);
	}

	public int size(Node<T> root) {
		if (root == null)
			return 0;
		else
			return 1 + size(root.left) + size(root.right);
	}

	public T getRoot() {
		return (T) (root != null ? root.value : null);
	}

	public boolean isEmpty() {
		return root == null;
	}


}
