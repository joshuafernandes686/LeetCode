/*REMOVE NTH NODE FROM END OF LIST
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */


import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution19 {
    public int len(ListNode head){
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int target = len(head) - n + 1;
        int count = 1;

        // remove head case
        if(target == 1){
            head = head.next;
            return head;
        }

        ListNode prev = head;
        ListNode cur = head.next;

        while(cur != null){
            count++;
            if(count == target){
                prev.next = cur.next;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }
}

public class P19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution19 sol = new Solution19();

        // Input list
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        ListNode head = null, tail = null;
        System.out.println("Enter " + n + " node values:");
        for(int i = 0; i < n; i++){
            int val = sc.nextInt();
            ListNode newNode = new ListNode(val);
            if(head == null){
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Input n to remove
        System.out.print("Enter n (node to remove from end): ");
        int rem = sc.nextInt();

        // Compute
        head = sol.removeNthFromEnd(head, rem);

        // Display
        System.out.println("Updated linked list:");
        ListNode cur = head;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();

        sc.close();
    }
}
