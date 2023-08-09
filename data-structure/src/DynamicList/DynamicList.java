package DynamicList;

import java.util.Arrays;

public class DynamicList<E> implements List<E> {
    // 核心数组
    private E[] data;
    // 元素数
    private int size;
    // 负载因子
    private float loadFactor = 0.75f;

    // 默认负载因子
    private final static float DEFAULT_LOAD_FACTOR = 0.75F;

    // 默认元素数
    private final static int DEFAULT_CAPACITY = 10;

    /**
     * 构造一个具有默认初始容量的空动态列表。
     * 如果未显式指定容量，则将使用默认容量。
     * Constructs an empty DynamicList with the default initial capacity.
     * The default capacity will be used if not specified explicitly.
     */
    public DynamicList() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * 构造一个具有指定初始容量的空动态列表。
     * 容量必须大于零；否则将抛出 IllegalArgumentException 异常。
     *
     * @param capacity 动态列表的初始容量
     * @param capacity the initial capacity of the DynamicList
     * @throws IllegalArgumentException 如果指定的容量小于等于零
     *                                  Constructs an empty DynamicList with the specified initial capacity.
     *                                  The capacity must be greater than zero; otherwise, an IllegalArgumentException will be thrown.
     * @throws IllegalArgumentException if the specified capacity is less than or equal to zero
     */
    public DynamicList(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Creat failed. Require >= 0");
        data = (E[]) new Object[capacity];
    }

    /**
     * 获取集合的容量（数组的长度）。
     * Get the capacity (length of the underlying array) of the collection.
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取集合中元素的数量。
     * Get the number of elements in the collection.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判断集合是否为空。
     * Check if the collection is empty.
     *
     * @return 如果集合为空，则返回 true；否则返回 false。
     * Returns true if the collection is empty, otherwise false.
     */
    @Override
    public Boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向集合中添加元素。
     * Add an element to the collection.
     *
     * @param o 要添加的元素。
     *          The element to be added.
     */
    @Override
    public void add(E o) {
        checkAndResize();
        data[size] = o;
        size++;
    }

    /**
     * 获取指定索引位置的元素。
     * Get the element at the specified index.
     *
     * @param index 索引位置。
     *              The index position.
     * @return 指定索引位置的元素。
     * The element at the specified index.
     */
    @Override
    public E get(int index) {
        return data[index];
    }

    /**
     * 设置指定索引位置的元素。
     * Set the element at the specified index.
     *
     * @param index 索引位置。
     *              The index position.
     * @param o     要设置的元素。
     *              The element to be set.
     */
    @Override
    public void set(int index, E o) {
        data[index] = o;
    }

    /**
     * 判断集合是否包含指定元素。
     * Check if the collection contains the specified element.
     *
     * @param o 要判断是否包含的元素。
     *          The element to be checked for containment.
     * @return 如果集合包含指定元素，则返回 true；否则返回 false。
     * Returns true if the collection contains the specified element, otherwise false.
     */
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == o) return true;
        }
        return false;
    }

    /**
     * 查找指定元素在集合中的索引位置。
     * Find the index of the specified element in the collection.
     *
     * @param o 要查找的元素。
     *          The element to be searched for.
     * @return 如果元素在集合中找到，则返回其索引位置；否则返回 -1。
     * Returns the index of the element if found in the collection, otherwise -1.
     */
    @Override
    public int find(E o) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == o) return i;
        }
        return -1;
    }

    /**
     * 移除指定索引位置的元素，并返回被移除的元素。
     * Remove the element at the specified index and return the removed element.
     *
     * @param index 要移除的元素的索引位置。
     *              The index position of the element to be removed.
     * @return 被移除的元素。
     * The element that was removed.
     */
    @Override
    public E remove(int index) {
        E oldValue = data[index];

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(data, index + 1, data, index,
                    numMoved);
        data[--size] = null; // clear to let GC do its work

        checkAndResize();
        return oldValue;
    }

    /**
     * 调整集合的容量（数组大小）为新的容量。
     * Resize the capacity of the collection (array size) to the new capacity.
     *
     * @param newCapacity 新的容量。
     *                    The new capacity.
     */
    public void resize(int newCapacity) {
        data = Arrays.copyOf(data, newCapacity);
    }

    /**
     * 判断是否需要扩容或缩容，并执行相应的操作。
     * Check if resizing (expansion or shrinkage) is necessary, and perform the appropriate action.
     */
    private void checkAndResize() {
        loadFactor = size / data.length;

        int newCapacity = 0;
        if (loadFactor > DEFAULT_LOAD_FACTOR)
            newCapacity = data.length * 2;
        else if (loadFactor < DEFAULT_LOAD_FACTOR / 2)
            newCapacity = data.length / 2;

        resize(newCapacity);
    }

    /**
     * 将集合转换为字符串表示形式。
     * Convert the collection to its string representation.
     *
     * @return 集合的字符串表示形式。
     * The string representation of the collection.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[ \n");
        for (int i = 0; i < size; i++) {
            str.append("\t" + data[i].toString());
            if (i != size - 1) {
                str.append(", \n");
            }
        }
        str.append("\n]");
        return str.toString();
    }
}
