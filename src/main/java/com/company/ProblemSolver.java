package com.company;

import java.util.HashMap;
import java.util.Map;

public class ProblemSolver {
    // String test = 'ab#dfs%23@'
    // Output: 32#sfd%ba@

    private static String reverseStringExceptSpecialCharacters(String input) {
        char[] charArr = input.toCharArray();

        Map<Character, Integer> positions = new HashMap<>();
        String result = "";

        for (int i = 0; i < charArr.length; i++) {
            if('#' == charArr[i] || '%' == charArr[i] || '@' == charArr[i]) {
                positions.put(charArr[i], i);
            }
        }


        for (int i = 0; i < charArr.length; i++) {
            if('#' == charArr[i] || '%' == charArr[i] || '@' == charArr[i]) {

            } else {
                result = charArr[i] + result;
            }
        }



        System.out.println(positions);

        System.out.println(result);
        return "";


    }

    public static void main(String[] args) {
        System.out.println(reverseStringExceptSpecialCharacters("ab#dfs%23@"));
    }

    /*
        orders table

        ID  Custid  orderAMt
        1      A           400
        2      B           200
        3      A           100
        4      C           500
        5       A           300
     */

    // Select cust_id, sum(orderAmt) from Orders group by cust_id order by sum(orderAmt) desc limit 5;


}
