import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> brac = new Stack<>();
        brac.push(s.charAt(0));
        int leng = s.length();
        for (int i = 1; i < leng; i++) {
            if (s.charAt(i) == brac.peek()) brac.pop();
            else brac.push(s.charAt(i));
        }
        System.out.println(brac);
        return brac.empty();
    }
}

public class P20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter a string of brackets: ");
        String s = sc.nextLine();

        boolean result = sol.isValid(s);
        System.out.println("Is valid? " + result);

        sc.close();
    }
}
