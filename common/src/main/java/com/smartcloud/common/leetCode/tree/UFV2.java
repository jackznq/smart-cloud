package com.smartcloud.common.leetCode.tree;

/**
 * 并查集 通过树实现
 * 该树比较特殊，孩子指向父亲
 */
class UFV2 extends AbstractUF {


    private int[] sz;

    public UFV2(int size) {
        super(size);
        sz = new int[size];
        for (int i = 0; i < size; i++) {
            sz[i] = 1;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void connectElements(int p, int q) {
        int pv = find(p);
        int qv = find(q);
        if (pv == qv)
            return;
        if (sz[pv] < sz[qv]) {
            parent[pv] = qv;
            sz[qv] += sz[pv];
        } else {
            parent[qv] = pv;
            sz[pv] += sz[qv];
        }
    }


    @Override
    public int find(int p) {
        if (p < 0 || p > parent.length) {
            throw new IllegalArgumentException("illegal args");
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }


}
