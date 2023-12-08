package com.company.bitmanipulation;

public class UnsetBit {

    public int unsetKthBit(int n, int k) {
        return (~(1 << k) & n);
    }
}
