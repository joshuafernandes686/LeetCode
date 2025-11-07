import java.util.Scanner;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution5 {
    public ListNode swapPairs(ListNode head) {
        ListNode out = new ListNode();
        out.next = head;
        ListNode cur = out;

        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;

            first.next = second.next;
            second.next = first;
            cur.next = second;

            cur = cur.next.next;
        }
        return out.next;
    }
}

public class P5 {

    // Utility to insert node at end
    public static ListNode insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) return newNode;

        ListNode temp = head;
        while (temp.next != null) temp = temp.next;

        temp.next = newNode;
        return head;
    }

    // Utility to print list
    public static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        ListNode head = null;
        System.out.println("Enter " + n + " values:");
        for (int i = 0; i < n; i++) {
            head = insert(head, sc.nextInt());
        }

        Solution5 sol = new Solution5();
        ListNode result = sol.swapPairs(head);

        System.out.println("List after swapping nodes in pairs:");
        printList(result);
    }
}
