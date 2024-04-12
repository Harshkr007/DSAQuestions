//Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

import java.util.*;
import java.io.*;

public class RemoveKdigits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = 0;
        String num = "";

        System.out.println("Enter the number:");
        num = br.readLine();
        System.out.println("Enter the no.of digits to be removed:");

        k = Integer.parseInt(br.readLine());
        System.out.println("The value is:" + new Solution2().removeKdigits(num, k));
    }
}

class Solution2 {
    public String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";

        Stack<Character> stk = new Stack<>();

        StringBuilder ans = new StringBuilder("");

        for (int i = 0; i < num.length(); i++) {
            char val = num.charAt(i);
            while (!stk.isEmpty() && (k != 0) && stk.peek() > val) {
                stk.pop();
                k--;
            }
            stk.push(val);
        }
        while (k > 0) {
            stk.pop();
            k--;
        }
        while (!stk.isEmpty()) {
            ans.append(stk.pop());
        }
        ans.reverse();

        while (ans.length() > 1 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }

        return ans.toString();

    }
}
