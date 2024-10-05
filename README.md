# Projeto: Árvore Binária com Padrões de Projeto

## Descrição
Este projeto implementa uma **Árvore Binária de Busca** (Binary Search Tree - BST) com o uso de vários padrões de projeto, garantindo a flexibilidade e manutenibilidade do código. A árvore é capaz de realizar as operações clássicas de busca, inserção, remoção e travessia, além de contar com suporte para clonagem (usando o padrão Prototype).

---

## Padrões de Projeto Utilizados

### 1. **Prototype**
   - **Classe Implementada**: `BinarySearchTree<T extends Comparable<T>>`
   - **Objetivo**: O padrão **Prototype** é utilizado para permitir a clonagem de objetos, neste caso, a árvore binária. Em vez de recriar a árvore do zero, a clonagem permite criar uma cópia profunda da árvore, com todos os nós replicados. 
   - **Implementação**: A interface `BstPrototype` define o método `getClone()`, que foi implementado na classe `BinarySearchTree` para retornar uma nova árvore com os mesmos elementos da original.
   - **Métodos principais**:
     - `BinarySearchTree<T> getClone()`: Realiza a clonagem da árvore.
     - `BinarySearchTree(BinarySearchTree<T> target)`: Construtor que recebe uma árvore alvo e cria uma cópia profunda de seus nós.

### 2. **Iterator**
   - **Classes Implementadas**: `PreOrderIterator`, `InOrderIterator`, `PostOrderIterator`, `LevelOrderIterator`
   - **Objetivo**: O padrão **Iterator** permite que uma coleção seja percorrida sem expor sua estrutura interna. Para a árvore binária, diferentes tipos de travessia foram implementados (pré-ordem, em ordem, pós-ordem e em nível).
   - **Implementação**: A interface `TreeIterator` define os métodos necessários para os iteradores, como `hasNext()` e `next()`. Cada classe de iterador implementa uma travessia diferente da árvore binária.
   - **Métodos principais**:
     - `boolean hasNext()`: Verifica se ainda existem elementos a serem iterados.
     - `T next()`: Retorna o próximo elemento na travessia da árvore.
   - **Tipos de Travessia**:
     - **Pré-ordem (PreOrder)**: Visita o nó raiz primeiro, seguido pela subárvore esquerda e depois a direita.
     - **Em ordem (InOrder)**: Visita a subárvore esquerda primeiro, depois o nó raiz, e por último a subárvore direita.
     - **Pós-ordem (PostOrder)**: Visita as subárvores esquerda e direita primeiro e, por último, o nó raiz.
     - **Em nível (LevelOrder)**: Visita os nós nível a nível, da esquerda para a direita.

### 3. **Factory Method**
   - **Classe Implementada**: `TreeIteratorFactory`
   - **Objetivo**: O padrão **Factory Method** permite que o código de criação de objetos seja encapsulado em uma classe de fábrica. Neste projeto, a classe `TreeIteratorFactory` é usada para criar os iteradores corretos baseados no tipo de travessia desejada.
   - **Implementação**: A classe `TreeIteratorFactory` possui um método estático `getIterator()`, que retorna o iterador apropriado baseado no tipo de travessia fornecido como argumento.
   - **Método principal**:
     - `static <T> TreeIterator<T> getIterator(traversalTypeEnum type, Node<T> root)`: Retorna o iterador correto para o tipo de travessia especificado.

---

