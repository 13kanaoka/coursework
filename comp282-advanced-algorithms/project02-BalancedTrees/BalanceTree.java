public interface BalanceTree<E extends Comparable<E>> {
    void insert(E item);
    boolean find(E item);
    void delete(E item);
    int height();
}