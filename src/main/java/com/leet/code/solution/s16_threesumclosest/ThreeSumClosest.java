package com.leet.code.solution.s16_threesumclosest;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) {
                        return sum;
                    }
                    else if (sum < target) {
                        int diff = target - sum;
                        if(diff < Math.abs(target - result)) {
                            result = sum;
                        }
                    }
                    else {
                        int diff=sum - target;
                        if(diff < Math.abs(target - result)) {
                            result = sum;
                        }
                    }
                }
            }
        }
        return result;
    }
}
