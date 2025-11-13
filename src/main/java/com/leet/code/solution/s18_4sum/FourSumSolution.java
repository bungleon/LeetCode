package com.leet.code.solution.s18_4sum;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FourSumSolution {
    public List<List<Integer>> fourSumBruteForce(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> output = new ArrayList<>();
        if (nums.length < 4) return result.stream().toList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            output.add(nums[i]);
                            output.add(nums[j]);
                            output.add(nums[k]);
                            output.add(nums[l]);
                            result.add(new ArrayList<>(output));
                            output.clear();
                        }
                    }
                }
            }
        }
        return result.stream().toList();
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> output = new ArrayList<>();
        if (nums.length < 4) return result.stream().toList();
        Arrays.sort(nums);
        Map<Integer, Integer> values = new ConcurrentHashMap<>();
        nums = Arrays.stream(nums).filter(i->filterByFour(i,values)).toArray();
        for (int start = 0; start < nums.length - 2; start++) {
            int lo=start+1;
            for (int end = start + 3; end < nums.length; end++) {
                int hi= end-1;
                do {
                    while (lo < hi) {
                        long sum = (long)nums[start] + (long)nums[lo] + (long)nums[hi] + (long)nums[end];
                        if (sum == target) {
                            output.add(nums[start]);
                            output.add(nums[lo]);
                            output.add(nums[hi]);
                            output.add(nums[end]);
                            result.add(new ArrayList<>(output));
                            output.clear();
                        }
                        hi--;
                    }
                    hi = end - 1;
                    lo++;
                } while (lo < hi);
                lo = start + 1;
            }
        }
        return result.stream().toList();
    }

    private boolean filterByFour(Integer i, Map<Integer, Integer> values) {

        if(values.get(i)==null){
            values.put(i,1);
        }
        else {
            values.put(i,values.get(i)+1);
        }
        return values.get(i) <= 4;
    }

}
