package com.leet.code.request;

import lombok.Data;

import java.util.List;

@Data
public class MergeTwoSortedListRequest {
    private List<Integer> list1;
    private List<Integer> list2;
}
