public interface Stack<E> {
    void push(E e);
    // 出栈
    E pop();
    // 获取栈顶元素
    E peek();
    int getSize();
    boolean isEmpty();
}
