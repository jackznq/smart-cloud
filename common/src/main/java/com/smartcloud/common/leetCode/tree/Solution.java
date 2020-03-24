package com.smartcloud.common.leetCode.tree;


class Solution {

    public static void main(String[] args) {

        //并查集测试
        int size =10000000;
        int m =10000000;

        UFV2 uf2 =new UFV2(size);
        System.out.println(uf2.testUF(uf2,m));
        UFV3 ufv3 =new UFV3(size);
        System.out.println(ufv3.testUF(ufv3,m));
        UFV4 ufv4 =new UFV4(size);
        System.out.println(ufv4.testUF(ufv4,m));
    }


}
