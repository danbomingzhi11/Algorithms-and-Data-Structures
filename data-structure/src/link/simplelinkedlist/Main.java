package link.simplelinkedlist;

public class Main {
    public static void main(String[] args) {
        SimpleLinkedList<Integer> s = new SimpleLinkedList();
        s.add(1);
        s.add(21);
        s.add(13);
        s.add(6451);
        s.add(1343);
        s.add(13432);

        System.out.println(s.toString());

        System.out.println(String.format("链表第一个元素 {%s} , 链表第二个元素 {%s}",
                s.get(0), s.get(1)));

        s.set(0, 312312);
        System.out.println(s.toString());

        s.remove(0);
        System.out.println(s.toString());

        System.out.println(s.contains(413));
    }
}
