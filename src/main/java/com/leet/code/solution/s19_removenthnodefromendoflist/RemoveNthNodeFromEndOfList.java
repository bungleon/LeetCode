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
                current.setNext(node);
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
                if (current.getNext() == null) {
                    if (previous == head) {
                        if(count==0){
                            return null;
                        }

                    }
                    previous.setNext(null);
                    return head;
                }
                previous=current;
                current = current.getNext();
                count++;
            }

        }
        while (current != null) {
            if (count >= n) {
                if (previous == null) {
                    previous = head;
                }
                previousPrevious = previous;
                previous = previous.getNext();
            }
            current = current.getNext();
            count++;
        }
        if (previousPrevious != null) {
            previousPrevious.setNext(previousPrevious.getNext().getNext());
        }
        if(n==count){
            if(head!=null) {
                head = head.getNext();
            }
        }
        return head;
    }
}
