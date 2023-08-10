package array.dynamicList;

public interface List<E> {

    // 获取数组中元素个数
    int getSize();

    // 数组是否为空
    Boolean isEmpty();

    // 添加元素
    void add(E e);

    // 根据数组下标获取元素
    E get(int index);

    // 修改指定下标的元素
    void set(int index, E e);

    // 判断元素是否存在
    boolean contains(Object e);

    // 根据元素返回数组下标
    int find(E e);

    // 删除元素
    E remove(int index);

    // 转换为字符串
    String toString();

}
