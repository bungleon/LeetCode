package com.leet.code.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {
    }
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
