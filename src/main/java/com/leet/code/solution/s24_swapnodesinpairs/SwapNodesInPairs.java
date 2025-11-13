package com.leet.code.solution.s24_swapnodesinpairs;

import com.leet.code.request.ListNode;

import java.util.List;

public class SwapNodesInPairs {
    public ListNode prepareNode(List<Integer> values) {
        ListNode head = null;
        ListNode current = null;
        for (int i = 0; i < values.size(); i++) {
            ListNode node = new ListNode(values.get(i));
            if (head == null) {
                head = node;
                current = node;
            } else {
                current.next = node;
                current = current.next;
            }
        }
        return swapPairs(head);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode third = second.next;
        ListNode connect = first;
        second.next = first;
        first.next = third;
        head=second;
        do {
            first = third;
            if (first == null) {
                return head;
            }
            second = first.next;
            if (second == null) {
                return head;
            }
            third = second.next;
            second.next = first;
            first.next = third;
            connect.next = second;
            connect = first;
        }
        while (third!=null && third.next!=null);
        return head;
    }
}
