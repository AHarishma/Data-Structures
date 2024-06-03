package com.company.binarysearch;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SquareRoot {
    public double sqrt(int n) {
        double left = 1;
        double right = n;
        while ((right - left) >= 0.000001) {
            double mid = left + (right - left) / 2;
            double square = mid * mid;
            if (square <= n) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return new BigDecimal((left + right) / 2).setScale(5, RoundingMode.HALF_UP).doubleValue();
    }
}

/**
 * Given a number, find the square root of it.
 * If the number is not a perfect square, then return the answer with 5 digits after decimal at max.
 * <p>
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 */
