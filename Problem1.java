package problems;

import java.util.*;

public class Problem1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int n = s.length();
        String doubled = s + s;

        Set<Character> set = new HashSet<>();

        int left = 0, right = 0;
        int maxSum = 0, currSum = 0;

        while (right < doubled.length()) {
            char ch = doubled.charAt(right);

            // Removing duplicates OR limit window size to n
            while (set.contains(ch) || (right - left) >= n) {
                char remove = doubled.charAt(left);
                set.remove(remove);
                currSum -= (remove - 'a' + 1);
                left++;
            }

            // Adding current character
            set.add(ch);
            currSum += (ch - 'a' + 1);

            maxSum = Math.max(maxSum, currSum);
            right++;
        }
        System.out.println(maxSum);
    }

}
