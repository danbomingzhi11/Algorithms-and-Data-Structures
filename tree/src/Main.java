public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 6, 7, 8};
        for (int num: nums) {
            bst.add(num);
        }

        System.out.println(bst.root);
        System.out.println(bst.contains(7));
        System.out.println(bst.removeMax());
        System.out.println(bst.root);
    }
}
