package com.leet.code.solution.s23_mergeksortedlist;

import com.leet.code.request.ListNode;

import java.util.List;

public class MergeKSortedList {
    public ListNode prepareList(List<List<Integer>> lists) {
        ListNode[] nodeList = new ListNode[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            ListNode head = null;
            ListNode current = null;
            for (Integer value : lists.get(i)) {
                ListNode node = new ListNode(value);
                if (head == null) {
                    head = node;
                    current = node;
                } else {
                    current.setNext(node);
                    current = current.next;
                }
            }
            nodeList[i] = head;
        }

        return mergeKLists(nodeList);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode sortedListHead = null;
        ListNode sortedListCurrent = null;
        while (true) {
            int nullCount = 0;
            int minValue = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < minValue) {
                        minValue = lists[i].val;
                        minIndex = i;
                    }
                } else {
                    nullCount++;
                }

            }
            if (nullCount == lists.length) {
                break;
            }
            if (sortedListHead == null) {
                sortedListHead = new ListNode(minValue);
                sortedListCurrent = sortedListHead;

            } else {
                sortedListCurrent.next = new ListNode(minValue);
                sortedListCurrent = sortedListCurrent.next;
            }
            lists[minIndex] = lists[minIndex].next;
        }
        return sortedListHead;
    }
}
