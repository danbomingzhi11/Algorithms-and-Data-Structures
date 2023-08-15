package stack.linkedstack;

import link.simplelinkedlist.SimpleLinkedList;

/**
 * This class implements a stack using a simple linked list.
 * 该类使用简单链表实现了一个栈。
 *
 * @param <E> the type of elements held in this stack
 *            此栈中包含的元素的类型
 */
public class LinkedStack<E> implements Stack<E> {
    private SimpleLinkedList<E> simpleLinkedList;

    public LinkedStack() {
        // 创建一个简单链表作为栈的基础
        this.simpleLinkedList = new SimpleLinkedList<E>();
    }

    @Override
    public void push(E o) {
        // 将元素添加到链表的末尾
        simpleLinkedList.add(o);
    }

    @Override
    public E pop() {
        // 获取链表的大小
        int size = simpleLinkedList.getSize();
        // 移除链表中的栈顶元素并返回
        return simpleLinkedList.remove(size - 1);
    }

    @Override
    public E peek() {
        // 获取链表中的栈顶元素但不移除
        return (E) simpleLinkedList.get(simpleLinkedList.getSize());
    }

    @Override
    public int getSize() {
        // 返回栈中元素的个数
        return simpleLinkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        // 判断栈是否为空
        return simpleLinkedList.getSize() == 0;
    }
}

