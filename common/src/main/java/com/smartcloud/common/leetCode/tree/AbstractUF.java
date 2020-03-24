package com.smartcloud.common.leetCode.tree;

import java.util.Random;

/**
 * 并查集 通过树实现
 * 该树比较特殊，孩子指向父亲
 */
public abstract class AbstractUF implements UF {

    protected int parent[];


    public AbstractUF(int size) {
        this.parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }


    protected int find(int p) {
        return parent[p];
    }

    protected double testUF(UF uf, int size) {
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.connectElements(a, b);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
