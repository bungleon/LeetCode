package com.leet.code.request;

import lombok.Data;

import java.util.List;

@Data
public class ThreeSumClosestRequest {
    private List<Integer> nums;
    private Integer target;
}
