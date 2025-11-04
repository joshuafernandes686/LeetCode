import java.util.Scanner;
import java.math.BigInteger;

/**
 * Definition for singly-linked list.
 */
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

class Solution {
    public ListNode insert(ListNode head, int val){
        ListNode newNode = new ListNode(val);
        ListNode cur = head;
        if(head == null){
            head = newNode;
        }
        else{
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = newNode;
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger n1 = BigInteger.ZERO;
        BigInteger n2 = BigInteger.ZERO;

        ListNode cur1 = l1, cur2 = l2;
        int k = 0;
        while(cur1 != null){
            BigInteger term = BigInteger.valueOf(cur1.val)
                                 .multiply(BigInteger.TEN.pow(k));
            n1 = n1.add(term);
            k++;
            cur1 = cur1.next;
        }

        // Convert second linked list to BigInteger
        k = 0;
        while(cur2 != null){
            BigInteger term = BigInteger.valueOf(cur2.val)
                                 .multiply(BigInteger.TEN.pow(k));
            n2 = n2.add(term);
            k++;
            cur2 = cur2.next;
        }

        // Add both numbers
        BigInteger sum = n1.add(n2);
        System.out.println("Sum as BigInteger: " + sum);

        // Convert BigInteger back to linked list
        if(sum.equals(BigInteger.ZERO)) 
            return new ListNode(0);

        ListNode out = null;
        while(sum.compareTo(BigInteger.ZERO) > 0){
            int digit = sum.mod(BigInteger.TEN).intValue();
            out = insert(out, digit);
            sum = sum.divide(BigInteger.TEN);
        }

        return out;
    }
}

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        // Input first linked list
        System.out.print("Enter number of nodes in first linked list: ");
        int n1 = sc.nextInt();
        ListNode l1 = null;
        System.out.println("Enter " + n1 + " values for first linked list:");
        for(int i = 0; i < n1; i++){
            int val = sc.nextInt();
            l1 = sol.insert(l1, val);
        }

        // Input second linked list
        System.out.print("Enter number of nodes in second linked list: ");
        int n2 = sc.nextInt();
        ListNode l2 = null;
        System.out.println("Enter " + n2 + " values for second linked list:");
        for(int i = 0; i < n2; i++){
            int val = sc.nextInt();
            l2 = sol.insert(l2, val);
        }

        // Compute the result
        ListNode result = sol.addTwoNumbers(l1, l2);

        // Display the resulting linked list
        System.out.println("Result linked list:");
        printList(result);

        sc.close();
    }

    // Helper to print the list
    public static void printList(ListNode head) {
        ListNode cur = head;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
