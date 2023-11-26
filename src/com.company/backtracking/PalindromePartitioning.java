package backtracking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PalindromePartitioning {

    private void palindromeParitioning(String string, int index, List<String> currentList, List<List<String>> result) {
        if (index >= string.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = index; i < string.length(); i++) {
            if (isPalindrome(string.substring(index, i + 1))) {
                currentList.add(string.substring(index, i + 1));
                palindromeParitioning(string, index + 1, currentList, result);
                currentList.remove(currentList.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String string) {
        StringBuilder builder = new StringBuilder(string).reverse();
        return string.equals(builder.toString());
    }

    public static void main(String[] args) {
        List<List<String>> result = new ArrayList<>();
        new PalindromePartitioning().palindromeParitioning("aabbc", 0, new ArrayList<>(), result);
        result.sort(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int minSize = Math.min(o1.size(), o2.size());
                for (int i = 0; i < minSize; i++) {
                    int result = o1.get(i).length() - o2.get(i).length();
                    if (result != 0) {
                        return result;
                    }
                }
                return o1.size() - o2.size();
            }
        });
        System.out.println(result);
    }
}

/**
 * Problem Description
 * Given a string A, partition A such that every string of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of A.
 * <p>
 * Ordering the results in the answer : Entry i will come before Entry j if :
 * len(Entryi[0]) < len(Entryj[0]) OR
 * (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR * * *
 * (len(Entryi[0]) == len(Entryj[0]) AND ... len(Entryi[k] < len(Entryj[k]))
 * <p>
 * Problem Constraints
 * 1 <= len(A) <= 15
 * <p>
 * Input Format
 * First argument is a string A of lowercase characters.
 * <p>
 * Output Format
 * Return a list of all possible palindrome partitioning of s.
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "aab"
 * Input 2:
 * <p>
 * A = "a"
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [
 * ["a","a","b"]
 * ["aa","b"],
 * ]
 * Output 2:
 * <p>
 * [
 * ["a"]
 * ]
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * In the given example, ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa").
 * Explanation 2:
 * <p>
 * In the given example, only partition possible is "a" .
 */
