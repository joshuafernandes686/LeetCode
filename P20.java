import java.util.*;

class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> brac=new Stack<>();
        Map<Character, Character> bracs = new HashMap<>();
        bracs.put('}','{');
        bracs.put(']','[');
        bracs.put(')','(');

        for(char c: s.toCharArray()){
            if(bracs.containsKey(c)){
                if(brac.isEmpty() || brac.pop()!=bracs.get(c)) return false;
            }
            else{
                brac.push(c);
            }
        }
        return brac.isEmpty();
    }
}

public class P20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution20 sol = new Solution20();

        System.out.print("Enter a string of brackets: ");
        String s = sc.nextLine();

        boolean result = sol.isValid(s);
        System.out.println("Is valid? " + result);

        sc.close();
    }
}
