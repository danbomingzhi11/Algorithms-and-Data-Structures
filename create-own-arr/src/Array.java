public class Array<E> {
    private E[] data;

    private int size;

    // 构造函数创建数组初始大小
    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        size = 0;
    }

    // 默认数组大小
    public Array() {
        this(10);
    }

    // 获取数组元素个数
    public int getSize() {
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 扩容
    public void resize(int len) {
        E[] newData = (E[]) new Object[len];
        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    // 添加数据
    public void add(int index, E data) {
        // 判断条件
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        // 空间不够扩容
        if (size == this.data.length) {
            resize(2 * size);
        }

        for (int i = size - 1; i >= index; i--)
            this.data[i + 1] = this.data[i];

        this.data[index] = data;

        size++;
    }

    // 在顶部添加元素
    public void addFirst(E data) {
        add(0, data);
    }

    // 在尾部添加元素
    public void addLast(E data) {
        add(size, data);
    }

    // 获取索引对应的数据
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }

        return this.data[index];
    }

    // 修改索引位置的元素为e
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal");
        }
        add(index, e);
    }

    // 查找数组中是否有元素e
    public boolean contains(E data) {
        for (int i = 0; i < size; i++) {
            if (this.data[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (this.data[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        E ret = data[index];
        for (int i = index; i < size; i++) {
            this.data[i] = this.data[i + 1];
        }

        size--;
        // 内存回收
        this.data[size] = null;

        if (size <= this.data.length / 2) {
            resize(this.data.length / 2);
        }
        return ret;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
            res.append("\n");
        }
        res.append(']');
        return res.toString();
    }
}
