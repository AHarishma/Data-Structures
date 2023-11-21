package backtracking;

import java.util.ArrayList;
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
        for (int i = 0; i < result.size(); i++) {
            List<String> cur = result.get(i);
            for (int j = 0; j < cur.size(); j++) {
                System.out.print(cur.get(j) + " ");
            }
            System.out.println();
        }
    }
}
