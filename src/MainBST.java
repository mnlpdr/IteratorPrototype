import tree.BinarySearchTree;
import tree.TreeIterator;
import tree.TraversalType;

public class MainBST {
    public static void main(String[] args) {
        // Criação da árvore binária de busca
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(50);
        bst.add(30);
        bst.add(80);
        bst.add(20);
        bst.add(40);
        bst.add(70);
        bst.add(90);

        // Testar o método unificado para obter iteradores

        // Pré-ordem
        System.out.println("Using PreOrderIterator:");
        TreeIterator<Integer> preOrderIterator = bst.getIterator(TraversalType.PRE_ORDER);
        while (preOrderIterator.hasNext()) {
            System.out.print(preOrderIterator.next() + " ");
        }
        System.out.println();

        // Em ordem
        System.out.println("Using InOrderIterator:");
        TreeIterator<Integer> inOrderIterator = bst.getIterator(TraversalType.IN_ORDER);
        while (inOrderIterator.hasNext()) {
            System.out.print(inOrderIterator.next() + " ");
        }
        System.out.println();

        // Pós-ordem
        System.out.println("Using PostOrderIterator:");
        TreeIterator<Integer> postOrderIterator = bst.getIterator(TraversalType.POST_ORDER);
        while (postOrderIterator.hasNext()) {
            System.out.print(postOrderIterator.next() + " ");
        }
        System.out.println();

        // Em nível
        System.out.println("Using LevelOrderIterator:");
        TreeIterator<Integer> levelOrderIterator = bst.getIterator(TraversalType.LEVEL_ORDER);
        while (levelOrderIterator.hasNext()) {
            System.out.print(levelOrderIterator.next() + " ");
        }
        System.out.println();
    }
}
