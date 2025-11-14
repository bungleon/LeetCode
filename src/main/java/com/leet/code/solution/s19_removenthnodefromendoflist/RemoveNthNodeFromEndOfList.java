package com.leet.code.solution.s19_removenthnodefromendoflist;

import com.leet.code.request.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode prepareListNode(int[] values, int n) {
        ListNode head = null;
        ListNode current = null;
        for (int i = 0; i < values.length; i++) {
            ListNode node = new ListNode(values[i]);
            if (head == null) {
                head = node;
                current = node;
            } else {
                current.next = node;
                current = node;
            }


        }
        return removeNthFromEnd(head, n);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode previous = null;
        ListNode previousPrevious = null;
        int count = 0;
        if (n == 1) {
            previous = head;
            while (current != null) {
                if (current.next == null) {
                    if (previous == head) {
                        if(count==0){
                            return null;
                        }

                    }
                    previous.next = null;
                    return head;
                }
                previous=current;
                current = current.next;
                count++;
            }

        }
        while (current != null) {
            if (count >= n) {
                if (previous == null) {
                    previous = head;
                }
                previousPrevious = previous;
                previous = previous.next;
            }
            current = current.next;
            count++;
        }
        if (previousPrevious != null) {
            previousPrevious.next = previousPrevious.next.next;
        }
        if(n==count){
            if(head!=null) {
                head = head.next;
            }
        }
        return head;
    }
}
