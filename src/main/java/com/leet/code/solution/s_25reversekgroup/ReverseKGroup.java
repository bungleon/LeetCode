package com.leet.code.solution.s_25reversekgroup;

import com.leet.code.request.ListNode;

import java.util.List;

public class ReverseKGroup {
    public ListNode prepareNode(List<Integer> list, Integer k) {
        ListNode head = null;
        ListNode current = null;
        for (int i = 0; i < list.size(); i++) {
            ListNode node = new ListNode(list.get(i));
            if (head == null) {
                head = node;
                current = node;
            } else {
                current.setNext(node);
                current = current.getNext();
            }
        }
        return reverseKGroup(head, k);
    }

    private ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = null;
        ListNode connect = null;
        int count = 1;
        while (head != null) {
            ListNode current = new ListNode(head.val);
            if (newHead == null) {
                newHead = current;
                connect = current;
            } else {
                current.next = newHead;
                newHead = current;
            }
            head = head.next;
            if (k == count) {
                connect.next = head;
                return newHead;
            }

            count++;
        }
        return newHead;
    }
}
