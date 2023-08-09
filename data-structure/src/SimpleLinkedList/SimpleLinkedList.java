package SimpleLinkedList;

public class SimpleLinkedList<E> implements List<E> {
    // 定义内部链表节点
    private class Node<E> {
        private E e;        // 节点元素
        private Node next;  // 指向下一个节点的引用

        // 构造函数
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    // 头结点（哑节点），不包含实际元素
    private Node dummyHead;
    private Node node;
    private int size;

    // 构造函数
    public SimpleLinkedList() {
        size = 0;
        dummyHead = new Node(0);
        dummyHead.next = null;
    }

    // 获取链表大小
    @Override
    public int getSize() {
        return size;
    }

    // 判断链表是否为空
    @Override
    public Boolean isEmpty() {
        return size == 0;
    }

    // 向链表末尾添加元素
    @Override
    public void add(E e) {
        if (dummyHead.next == null) {
            // 如果链表为空，创建第一个节点并赋值给头结点
            dummyHead.next = new Node(e);
            node = dummyHead.next;
        } else {
            Node newNode = new Node(e);
            node.next = newNode;
            node = newNode;
        }

        size++;
    }

    // 获取指定索引的元素值
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node pred = dummyHead.next;
        for (int i = 0; i < index; i++) {
            if (pred == null) throw new NullPointerException("Null Pointer");
            pred = pred.next;
        }
        return (E) pred.e;
    }

    // 修改指定索引的元素值
    @Override
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }

        Node pred = dummyHead.next;
        for (int i = 0; i < index; i++) {
            if (pred == null) throw new NullPointerException("Null Pointer");
            pred = pred.next;
        }

        pred.e = e;
    }

    // 判断链表是否包含某个元素
    @Override
    public boolean contains(E e) {
        Node node = dummyHead;

        while (node != null) {
            if (e.equals(node.e)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    // 移除指定索引的元素，并返回被移除的元素值
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node res = prev.next;
        prev.next = prev.next.next;
        size--;

        return null;
    }

    // 重写toString方法，将链表元素转为字符串表示
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }

}
