package tree;

/**
 * Classe Node com o parametro generito T, que estende Comparable<T>. Isso significa que
 * o tipo T deve ser comparável a si mesmo, permitindo que os nós sejam organizados de acordo
 * com seus valores.
 * @author Alex Sandro
 *
 * @param <T>
 */
public class Node<T extends Comparable<T>> {
    T value;
    Node<T> left;
    Node<T> right;

    Node(T value) {
        this.value = value;
        right = null;
        left = null;
    }
    
    public String toString() {
    	return value.toString();
    }
    
    public int compareTo(Node<T> otherNode) {
        //provide implementation here
        //See effective java for appropriate implementation conditions
    	return this.value.compareTo(otherNode.value);
    }
}


