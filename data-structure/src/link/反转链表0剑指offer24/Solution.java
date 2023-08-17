package link.反转链表0剑指offer24;

import java.util.ArrayList;
import java.util.Stack;

class Solution {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        // 太慢
//        if (head == null) {
//            return head;
//        }
//        Stack<ListNode> stack = new Stack<>();
//        ListNode head1 = head;
//        while (head != null) {
//            stack.push(head);
//            System.out.println(head.val);
//            head1 = head;
//            head = head.next;
//            head1.next = null;
//        }
//        head = stack.pop();
//        ListNode newHead = head;
//        while (!stack.isEmpty()) {
//            head.next = stack.pop();
//            head = head.next;
//        }
//        return newHead;
        // 第二版 不够优雅
//        if (head == null)
//            return head;
//        ArrayList<ListNode> arrayList = new ArrayList<>();
//        ListNode head1 = head;
//        while (head != null) {
//            arrayList.add(head);
//            head1 = head;
//            head = head.next;
//            head1.next = null;
//        }
//        int len = arrayList.size();
//        head = arrayList.get(--len);
//        ListNode newHead = head;
//        for (int i = len - 1; i >=0 ; i--) {
//            head.next = arrayList.get(i);
//            head = head.next;
//        }
//        return newHead;
        // 有趣
//        ListNode prev = null;
//        ListNode curr = head;
//
//        while (curr != null) {
//            ListNode newHead = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = newHead;
//        }

        // 递归
//        if (head == null) {
//            return head;
//        }
//        return re(head, null);

        // 递归改良
        if (head == null) {
            return head;
        }
        return re1(null, head);
    }

    private static ListNode re(ListNode node, ListNode prev) {
        if (node.next == null){
            node.next = prev;
            return node;
        }
        ListNode newNode = re(node.next, node);
        node.next = prev;
        return newNode;
    }

    private static ListNode re1(ListNode prev, ListNode curr) {
        if (curr.next == null){
            curr.next = prev;
            return curr;
        }
        ListNode newCurr = curr.next;
        curr.next = prev;
        return re1(curr, newCurr);
    }
    private static ListNode re2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = re2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(solution.reverseList(listNode1).val);
        ListNode listNode = solution.reverseList(null);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }
}