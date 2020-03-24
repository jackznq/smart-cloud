package com.smartcloud.common.utils.leetCode.tree;

/**
 * 并查集
 */
public interface UF {

    boolean isConnected(int p, int q);

    void connectElements(int p, int q);
}
