package com.leet.code.request;

import lombok.Data;

import java.util.List;

@Data
public class ReverseKGroupRequest {
    private List<Integer> list;
    private Integer k;
}
