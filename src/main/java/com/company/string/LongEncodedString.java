package com.company.string;

import java.util.ArrayList;
import java.util.List;

public class LongEncodedString {
    public List<Integer> frequency(String s) {
        int[] frequency = new int[26];
        int i = 0;
        while(i < s.length()) {
            int index;
            if(i + 2 < s.length() && s.charAt(i + 2) == '#') {
                index = Integer.parseInt(s.substring(i,  i + 2));
                i += 3;
            } else {
                index = s.charAt(i) - '0';
                i++;
            }
            int count = 1;
            if(i < s.length() && s.charAt(i) == '(') {
                i++;
                int start = i;
                while(s.charAt(i) != ')') {
                    i++;
                }
                count =  Integer.parseInt(s.substring(start, i));
                i++;
            }
            frequency[index - 1] += count;
        }

        List<Integer> result = new ArrayList<>();
        for(int freq: frequency) {
            result.add(freq);
        }
        return result;
    }
}

/**
 * Consider a string that consists of lowercase English letters (i.e., [a-z]) only. The following rules are used to encode all of its characters into the string s.
 *
 * • a is encoded as 1, b is encoded as 2, c is encoded as 3, and i is encoded as 9.
 *
 * • j is encoded as 10#, k is encoded as 11#, l is encoded as 12#,..., and z is encoded as 26#.
 *
 * • If any character occurs two or more consecutively, its count immediately follows the encoded character in parentheses, e.g. 'aa' is encoded as '1(2)'.
 *
 * Examples
 *
 * • String "abzx" is encoded as s = "1226#24#".
 *
 * • String "aabccc" is encoded as s = "1(2)23(3)".
 *
 * • String "bajj" is encoded as s = "2110#(2)".
 *
 * • String "wwxyzwww" is encoded as s = "23# (2)24#25#26#23#(3)".
 *
 * Given an encoded string s, determine the character counts for each letter of the original, decoded string. Return array of 26 integers where index O contains the number of 'a' characters, index 1 contains the number of 'b' characters, and so on.
 * Function Description
 *
 * Complete the frequency function in the editor below.
 *
 * frequency has the following parameter:
 *
 * string s: an encoded string
 *
 * Return
 *
 * int[26]: the character frequencies as described
 *
 * Constraints
 *
 * • String s consists of decimal integers from 0 to 9, #s, and ()'s only.
 *
 * • 1≤length of s ≤ 105
 *
 * • It is guaranteed that string s is a valid encoded string.
 *
 * • 2≤c≤104, where cis a parenthetical count of consecutive occurrences of an encoded character.
 *
 * ▼Input Format For Custom Testing
 *
 * Input from stdin will be processed as follows and passed to the function.
 *
 * The only line contains the string s, the encoded string.
 *
 * ▼Sample Case 0
 *
 * Sample Input For Custom Testing
 *
 * 1226#24#
 * Sample Output 0
 * 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 1 0 1
 *
 * ▼Sample Case 1
 *
 * Sample Input 1
 *
 * 1(2)23(3)
 *
 * Sample Output 1
 * 2 1 3 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0
 */
