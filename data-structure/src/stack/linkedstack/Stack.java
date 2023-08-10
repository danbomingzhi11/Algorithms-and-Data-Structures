package stack.linkedstack;

/**
 * This interface represents a basic stack data structure.
 * 该接口表示基本的栈数据结构。
 * @param <E> the type of elements held in this stack
 *            此栈中包含的元素的类型
 */
public interface Stack<E> {
    /**
     * Pushes an element onto the top of the stack.
     * 将元素压入栈顶。
     * @param e the element to be pushed
     *          要压入的元素
     */
    void push(E e);

    /**
     * Removes and returns the element at the top of the stack.
     * 弹出栈顶元素并返回。
     * @return the element at the top of the stack
     *         栈顶的元素
     */
    E pop();

    /**
     * Returns the element at the top of the stack without removing it.
     * 返回栈顶元素但不弹出。
     * @return the element at the top of the stack
     *         栈顶的元素
     */
    E peek();

    /**
     * Returns the number of elements in the stack.
     * 返回栈中元素的个数。
     * @return the number of elements in the stack
     *         栈中元素的个数
     */
    int getSize();

    /**
     * Checks if the stack is empty.
     * 判断栈是否为空。
     * @return true if the stack is empty, false otherwise
     *         如果栈为空，则返回 true，否则返回 false
     */
    boolean isEmpty();
}
