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
        ListNode cur1=l1;
        ListNode cur2=l2;
        ListNode out= new ListNode();
        int sum=0;
        int carry=0;
        while(cur1!=null && cur2!=null){
            sum=cur1.val+cur2.val+carry;
            insert(out,sum%10);
            carry=sum/10;
            cur1=cur1.next;
            cur2=cur2.next;
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
