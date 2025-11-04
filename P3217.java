/*PROBLEM STATEMENT
 * DELETE NODES FROM LINKED LIST PRESENT IN ARRAY
 * You are given an array of integers nums and the head of a linked list. 
 * Return the head of the modified linked list after removing all nodes from the linked list 
 * that have a value that exists in nums.
 */
import java.util.*;
import java.util.stream.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution3217 {
    public ListNode modifiedList(int[] nums, ListNode head) {
        if (head == null) return null;

        Set<Integer> num = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        while (head != null && num.contains(head.val)) {
            head = head.next;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (num.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}

public class P3217 {
    public static void main(String[] args) {
        int[] nums = {2, 4, 6};
        ListNode head = new ListNode(1,
                        new ListNode(2,
                        new ListNode(3,
                        new ListNode(4,
                        new ListNode(5,
                        new ListNode(6))))));
        Solution3217 sol = new Solution3217();
        ListNode modified = sol.modifiedList(nums, head);
        System.out.print("Modified list: ");
        printList(modified);
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print("->");
            head = head.next;
        }
        System.out.println();
    }
}    
