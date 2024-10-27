// Middle of the Linked List

import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class leet876 {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println(middleNode(node1));
        System.out.println(middleNode1(node1));
    }

    public static ListNode middleNode(ListNode head) {
        ArrayList<ListNode> ret = new ArrayList<>();
        int count = 0;
        while (head != null) {
            ret.add(head);
            head = head.next;
            count++;
        }
        return ret.get(count / 2);
    }

    public static ListNode middleNode1(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
// Time complexity is O(n) as we are iterating through that linked list once
// Space complexity is O(n) as we are storing the entire linked list in
// ArrayList of n length