package com.leet.code.solution.s2_addtwonumbers;

import com.leet.code.request.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        int remaining = 0;
        while (true) {
            if (l1 == null && l2 == null) {
                break;
            }
            int val1 = 0;
            int val2 = 0;
            if (l1 != null) {
                val1 = l1.getVal();
                l1 = l1.getNext();
            }
            if (l2 != null) {
                val2 = l2.getVal();
                l2 = l2.getNext();
            }
            int sum = val1 + val2 + remaining;
            int intValue = sum % 10;
            remaining = sum / 10;
            if(head == null){
                head = new ListNode(intValue);
                current = head;
            }
            else{
                current.setNext(new ListNode(intValue));
                current = current.getNext();
            }
        }
        if(remaining!=0){
            current.setNext(new ListNode(remaining));
        }

        return head;
    }


    public ListNode getList(int[] array) {
        ListNode head = new ListNode(array[0]);
        ListNode cur = head;
        for (int i = 1; i < array.length; i++) {
            cur.setNext(new ListNode(array[i]));
            cur=cur.getNext();
        }
        return head;
    }
}
