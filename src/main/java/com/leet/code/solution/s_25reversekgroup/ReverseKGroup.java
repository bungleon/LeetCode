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
                current.next = node;
                current = current.next;
            }
        }
        return reverseKGroup(head, k);
    }

    private ListNode reverseKGroup(ListNode head, int k) {
        ListNode initialHead = head;
        int count = 0;
        while (initialHead != null) {
            count++;
            initialHead = initialHead.next;
        }
        if (count < k) {
            return head;
        }
        int reversedCount = count / k;
        ListNode[] heads = new ListNode[reversedCount];
        ListNode[] tails = new ListNode[reversedCount];
        ListNode current = head;
        for (int i = 0; i < reversedCount; i++) {
            for (int j = 0; j < k; j++) {
                ListNode node = new ListNode(current.val);
                current = current.next;
                head = head.next;
                if (tails[i] == null) {
                    tails[i] = node;
                }
                if (heads[i] == null) {
                    heads[i] = node;
                } else {
                    node.next = heads[i];
                    heads[i] = node;
                }
            }
        }
        for (int i = 0; i < reversedCount - 1; i++) {
            tails[i].next = heads[i + 1];
        }
        tails[reversedCount - 1].next = head;
        return heads[0];
    }
}
