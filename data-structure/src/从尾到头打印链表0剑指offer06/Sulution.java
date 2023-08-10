package 从尾到头打印链表0剑指offer06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /* 第一版： 此题主要考察递归思想 空间占比太大
    public int[] reversePrint(ListNode head) {
        // 考虑链表为空的情况
        if (head == null) return new int[0];
        int len = -1;
        ListNode newHead = head;
        while (newHead != null) {
            len++;
            newHead = newHead.next;
        }

        int[] arr = new int[len + 1];
        recursion(head, arr, len);
        return arr;
    }

    private static int[] recursion(ListNode head, int[] arr, int i) {
        if (head.next == null) {
            arr[i] = head.val;
            return arr;
        }

        recursion(head.next, arr, i - 1);
        arr[i] = head.val;
        return arr;
    }
*/
    /* 第二版: 使用ArrayList
    public int[] reversePrint(ListNode head) {
        // 考虑链表为空的情况
        if (head == null) return new int[0];
        ArrayList<Integer> arr = new ArrayList();
        int len = -1;
        ListNode newHead = head;
        recursion(head, arr);
        int[] ints = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++)
            ints[i] = arr.get(i);
        return ints;
    }

    private static void recursion(ListNode head, ArrayList arr) {
        if (head == null) {
            return;
        }
        recursion(head.next, arr);
        arr.add(head.val);
    }
     */
    // 第三版： 使用Stack
    public int[] reversePrint(ListNode head) {
        // 考虑链表为空的情况
        if (head == null) return new int[0];
        // 使用LinkedList作为stack
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++)
            // 自动拆箱装箱
            res[i] = stack.removeLast();
        return res;
    }

    // 第二版: 使用栈
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ;

        Solution solution = new Solution();
        int[] arr = solution.reversePrint(listNode1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
