package com.leet.code.solution.s21_mergetwosortedlist;

import com.leet.code.request.ListNode;

import java.util.List;

public class MergeTwoSortedList {
    public ListNode prepareNode(List<Integer> value1, List<Integer> value2) {
        ListNode head = null;
        ListNode current = null;
        for (int i = 0; i < value1.size(); i++) {
            ListNode node = new ListNode(value1.get(i));
            if (head == null) {
                head = node;
                current = node;
            } else {
                current.setNext(node);
                current = current.getNext();
            }
        }

        ListNode head2 = null;
        ListNode current2 = null;
        for (int i = 0; i < value2.size(); i++) {
            ListNode node = new ListNode(value2.get(i));
            if (head2 == null) {
                head2 = node;
                current2 = node;
            } else {
                current2.setNext(node);
                current2 = current2.getNext();
            }
        }
        return mergeTwoLists(head, head2);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = null;
        ListNode current = null;
        while (list1 != null && list2 != null) {
            if (list1.getVal() < list2.getVal()) {
                if (head == null) {
                    head = list1;
                    current = head;
                    list1 = list1.getNext();
                } else {
                    current.setNext(list1);
                    current = current.getNext();
                    list1 = list1.getNext();
                }
            } else {
                if (head == null) {
                    head = list2;
                    current = head;
                    list2 = list2.getNext();
                } else {
                    current.setNext(list2);
                    current = current.getNext();
                    list2 = list2.getNext();
                }
            }
            if(list1==null){
                current.setNext(list2);
            }
            if(list2==null){
                current.setNext(list1);
            }
        }
        return head;
    }
}
