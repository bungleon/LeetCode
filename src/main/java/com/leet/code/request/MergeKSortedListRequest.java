package com.leet.code.request;

import lombok.Data;

import java.util.List;

@Data
public class MergeKSortedListRequest {
    List<List<Integer>> lists;
}
