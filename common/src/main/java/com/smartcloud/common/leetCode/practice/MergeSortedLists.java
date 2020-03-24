package com.smartcloud.common.leetCode.practice;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Date 18/10/25 下午3:06
 * @Auther znq
 * @ClassName MergeSortedLists
 **/
public class MergeSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = null;
        List<Integer> list = new ArrayList();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            list.add(lists[i].val);
        }
        Collections.sort(list);
        for (int i : list) {
            if (null == listNode) {
                listNode = new ListNode(i);
            }
            ListNode next = new ListNode(i);
            listNode.setNext(next);
        }
        if (lists.length == 0) {
            return listNode;
        }
        return mergeKLists(lists);
    }

    @Data
    class ListNode {
        public int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }


    }
}
