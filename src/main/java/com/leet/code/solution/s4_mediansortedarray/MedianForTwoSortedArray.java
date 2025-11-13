package com.leet.code.solution.s4_mediansortedarray;

public class MedianForTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int n1 = 0, n2 = 0;
        for(int i=0;i<merged.length;i++){
            int n1value=Integer.MAX_VALUE;
            int n2value=Integer.MAX_VALUE;
            if(n1<nums1.length){
                n1value=nums1[n1];
            }
            if(n2<nums2.length){
                n2value=nums2[n2];
            }
            if(n1value<=n2value){
                merged[i]=n1value;
                n1++;
            }else{
                merged[i]=n2value;
                n2++;
            }
        }
        if (merged.length % 2 == 0) {
            return ((double) merged[(merged.length-1) / 2] + (double) merged[merged.length / 2 ]) / 2.0;
        } else {
            return merged[merged.length / 2];
        }
    }
}
