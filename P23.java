/*MERGE K LINKED LISTS
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 */

import java.util.*;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}

class Solution23 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode out = new ListNode(0);
        ListNode append = out;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                append.next = cur1;
                cur1 = cur1.next;
                append = append.next;
            } else if (cur1.val > cur2.val) {
                append.next = cur2;
                cur2 = cur2.next;
                append = append.next;
            } else {
                append.next = cur1;
                cur1 = cur1.next;
                append = append.next;
                append.next = cur2;
                cur2 = cur2.next;
                append = append.next;
            }
        }
        while (cur1 != null) {
            append.next = cur1;
            cur1 = cur1.next;
            append = append.next;
        }
        while (cur2 != null) {
            append.next = cur2;
            cur2 = cur2.next;
            append = append.next;
        }
        return out.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode out = lists[0];
        for (int i = 1; i < lists.length; i++) {
            out = mergeTwoLists(out, lists[i]);
        }
        return out;
    }
}

public class P23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter number of linked lists: ");
        int k = sc.nextInt();
        ListNode[] lists = new ListNode[k];

        // Input each list
        for (int i = 0; i < k; i++) {
            System.out.print("Enter number of nodes in list " + (i + 1) + ": ");
            int n = sc.nextInt();
            ListNode head = null, tail = null;
            if (n > 0) System.out.println("Enter " + n + " sorted values:");
            for (int j = 0; j < n; j++) {
                int val = sc.nextInt();
                ListNode newNode = new ListNode(val);
                if (head == null) {
                    head = newNode;
                    tail = head;
                } else {
                    tail.next = newNode;
                    tail = tail.next;
                }
            }
            lists[i] = head;
        }

        // Merge all lists
        ListNode merged = sol.mergeKLists(lists);

        // Display result
        System.out.println("Merged sorted list:");
        printList(merged);

        sc.close();
    }

    public static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
