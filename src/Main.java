import interfaces.TreeIterator;
import tree.BinarySearchTree;
import utils.traversalTypeEnum;

public class Main {
    public static void main(String[] args) {
        // Criação da árvore binária de busca
        BinarySearchTree<Integer> bst1 = new BinarySearchTree<>(50);
        bst1.add(30);
        bst1.add(80);
        bst1.add(20);
        bst1.add(40);
        bst1.add(70);
        bst1.add(90);

        // Clonagem
        BinarySearchTree<Integer> bst2 = bst1.getClone();

        // Testar o método unificado para obter iteradores

        // Pré-ordem (bst1)
        System.out.println("Using PreOrderIterator bst1:");
        TreeIterator<Integer> preOrderIterator1 = bst1.getIterator(traversalTypeEnum.PRE_ORDER);
        while (preOrderIterator1.hasNext()) {
            System.out.print(preOrderIterator1.next() + " ");
        }
        System.out.println();

        // Pré-ordem (bst2)
        System.out.println("Using PreOrderIterator bst2:");
        TreeIterator<Integer> preOrderIterator2 = bst2.getIterator(traversalTypeEnum.PRE_ORDER);
        while (preOrderIterator2.hasNext()) {
            System.out.print(preOrderIterator2.next() + " ");
        }
        System.out.println();

        // Em ordem (bst1)
        System.out.println("Using InOrderIterator bst1:");
        TreeIterator<Integer> inOrderIterator1 = bst1.getIterator(traversalTypeEnum.IN_ORDER);
        while (inOrderIterator1.hasNext()) {
            System.out.print(inOrderIterator1.next() + " ");
        }
        System.out.println();

        // Em ordem (bst2)
        System.out.println("Using InOrderIterator bst2:");
        TreeIterator<Integer> inOrderIterator2 = bst2.getIterator(traversalTypeEnum.IN_ORDER);
        while (inOrderIterator2.hasNext()) {
            System.out.print(inOrderIterator2.next() + " ");
        }
        System.out.println();

        // Pós-ordem (bst1)
        System.out.println("Using PostOrderIterator bst1:");
        TreeIterator<Integer> postOrderIterator1 = bst1.getIterator(traversalTypeEnum.POST_ORDER);
        while (postOrderIterator1.hasNext()) {
            System.out.print(postOrderIterator1.next() + " ");
        }
        System.out.println();

        // Pós-ordem (bst2)
        System.out.println("Using PostOrderIterator bst2:");
        TreeIterator<Integer> postOrderIterator2 = bst2.getIterator(traversalTypeEnum.POST_ORDER);
        while (postOrderIterator2.hasNext()) {
            System.out.print(postOrderIterator2.next() + " ");
        }
        System.out.println();

        // Em nível (bst1)
        System.out.println("Using LevelOrderIterator bst1:");
        TreeIterator<Integer> levelOrderIterator1 = bst1.getIterator(traversalTypeEnum.LEVEL_ORDER);
        while (levelOrderIterator1.hasNext()) {
            System.out.print(levelOrderIterator1.next() + " ");
        }
        System.out.println();

        // Em nível (bst2)
        System.out.println("Using LevelOrderIterator bst2:");
        TreeIterator<Integer> levelOrderIterator2 = bst2.getIterator(traversalTypeEnum.LEVEL_ORDER);
        while (levelOrderIterator2.hasNext()) {
            System.out.print(levelOrderIterator2.next() + " ");
        }
        System.out.println();
    }
}
