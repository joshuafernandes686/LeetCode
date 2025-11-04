/*MERGE TWO SORTED LINKED LISTS
 * You are given the heads of two sorted linked lists list1 and list2. 
 * Merge the two lists into one sorted list. 
 * The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
*/
import java.util.Scanner;

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

class Solution21 {
    public ListNode insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        ListNode cur = head;
        if (head == null) {
            head = newNode;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode out = new ListNode();
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                insert(out, cur1.val);
                cur1 = cur1.next;
            } else if (cur1.val > cur2.val) {
                insert(out, cur2.val);
                cur2 = cur2.next;
            } else if (cur1.val == cur2.val) {
                insert(out, cur1.val);
                cur1 = cur1.next;
                insert(out, cur2.val);
                cur2 = cur2.next;
            }
        }
        while (cur1 != null) {
            insert(out, cur1.val);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            insert(out, cur2.val);
            cur2 = cur2.next;
        }
        out = out.next;
        return out;
    }
}

public class P21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution21 sol = new Solution21();

        // Input first list
        System.out.print("Enter number of nodes in first list: ");
        int n1 = sc.nextInt();
        ListNode list1 = null;
        System.out.println("Enter " + n1 + " sorted values for first list:");
        for (int i = 0; i < n1; i++) {
            int val = sc.nextInt();
            list1 = sol.insert(list1, val);
        }

        // Input second list
        System.out.print("Enter number of nodes in second list: ");
        int n2 = sc.nextInt();
        ListNode list2 = null;
        System.out.println("Enter " + n2 + " sorted values for second list:");
        for (int i = 0; i < n2; i++) {
            int val = sc.nextInt();
            list2 = sol.insert(list2, val);
        }

        // Merge the two lists
        ListNode result = sol.mergeTwoLists(list1, list2);

        // Display merged list
        System.out.println("Merged sorted list:");
        printList(result);

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
