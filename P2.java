import java.util.Scanner;

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
        long n1, n2;
        n1 = 0;
        n2 = 0;
        ListNode cur1, cur2;
        long k = 0;
        cur1 = l1;
        while(cur1 != null){
            n1 += cur1.val * Math.pow(10, k);
            k++;
            cur1 = cur1.next;
        }
        k = 0;
        cur2 = l2;
        while(cur2 != null){
            n2 += cur2.val * Math.pow(10, k);
            k++;
            cur2 = cur2.next;
        }
        long sum = n1 + n2;
        System.out.println(sum);
        ListNode out = new ListNode();
        if(sum==0) return out;
        long digit;
        while(sum > 0){
            digit=sum%10;
            insert(out, (int)digit);
            sum /= 10;
        }
        out=out.next;

        return out;
    }
}

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        // Input first linked list
        System.out.print("Enter number of nodes in first linked list: ");
        long n1 = sc.nextInt();
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
