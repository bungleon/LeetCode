package com.leet.code.controller;

import com.leet.code.request.*;
import com.leet.code.solution.s10_regularexpression.RegularExpression;
import com.leet.code.solution.s11_containerwithmostwater.ContainerWithMostWater;
import com.leet.code.solution.s12_integertoroman.IntegerToRoman;
import com.leet.code.solution.s13_romantointeger.RomanToInteger;
import com.leet.code.solution.s14_longestcommonprefix.LongestCommonPrefix;
import com.leet.code.solution.s15_threesum.ThreeSum;
import com.leet.code.solution.s16_threesumclosest.ThreeSumClosest;
import com.leet.code.solution.s17_lettercombinationofaphonenumber.PhoneNumberCombination;
import com.leet.code.solution.s18_4sum.FourSumSolution;
import com.leet.code.solution.s19_removenthnodefromendoflist.RemoveNthNodeFromEndOfList;
import com.leet.code.solution.s1_twosum.TwoSum;
import com.leet.code.solution.s20_validparentheses.ValidParentheses;
import com.leet.code.solution.s21_mergetwosortedlist.MergeTwoSortedList;
import com.leet.code.solution.s22_generateparentheses.GenerateParentheses;
import com.leet.code.solution.s23_mergeksortedlist.MergeKSortedList;
import com.leet.code.solution.s24_swapnodesinpairs.SwapNodesInPairs;
import com.leet.code.solution.s25_reversekgroup.ReverseKGroup;
import com.leet.code.solution.s26_removeduplicate.RemoveDuplicate;
import com.leet.code.solution.s27_removeelement.RemoveElement;
import com.leet.code.solution.s2_addtwonumbers.AddTwoNumbers;
import com.leet.code.solution.s3_longestsubstring.LongestSubstring;
import com.leet.code.solution.s4_mediansortedarray.MedianForTwoSortedArray;
import com.leet.code.solution.s5_longestpalindromicstring.LongestPalindromicString;
import com.leet.code.solution.s6_zigzagconversion.ZigzagConversion;
import com.leet.code.solution.s7_reverseinteger.ReverseInteger;
import com.leet.code.solution.s8_stringtointeger.StringToInteger;
import com.leet.code.solution.s9_palindromenumber.PalindromeNumber;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/solution")
@AllArgsConstructor
public class SolutionController {
    @PostMapping("/two-sum")
    public Object twoSum(@RequestBody TwoSumRequest request) {
        TwoSum twoSum = new TwoSum();
        return twoSum.twoSum(request.getNums(), request.getTarget());
    }

    @PostMapping("/add-two-numbers")
    public Object addTwoNumbers(@RequestBody AddTwoNumbersRequest request) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = addTwoNumbers.getList(request.getL1());
        ListNode l2 = addTwoNumbers.getList(request.getL2());
        ListNode result = addTwoNumbers.addTwoNumbers1(l1, l2);
        List<Integer> retvalue = new ArrayList<>();
        while (result != null) {
            retvalue.add(result.val);
            result = result.next;
        }
        return retvalue;
    }

    @PostMapping("/longest-substring")
    public Object longestSubstring(@RequestBody LongestSubstringRequest request) {
        LongestSubstring longestSubstring = new LongestSubstring();
        return longestSubstring.longestSubstring(request.getS());
    }

    @PostMapping("/median-sorted-array")
    public Object longestSubstring(@RequestBody MedianSortedArrayRequest request) {
        MedianForTwoSortedArray medianForTwoSortedArray = new MedianForTwoSortedArray();
        return medianForTwoSortedArray.findMedianSortedArrays(request.getNums1(), request.getNums2());
    }

    @PostMapping("/longest-palindromic-string")
    public Object longestPalindromicString(@RequestBody LongestSubstringRequest request) {
        LongestPalindromicString longestSubstring = new LongestPalindromicString();
        return longestSubstring.longestPalindrome(request.getS());
    }

    @PostMapping("/zigzag-conversion")
    public Object zigzagConversion(@RequestBody ZigzagConversionRequest request) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        return zigzagConversion.convert(request.getS(), request.getNumRows());
    }

    @PostMapping("/reverse-integer")
    public Object reverseInteger(@RequestBody ReverseIntegerRequest request) {
        ReverseInteger reverseInteger = new ReverseInteger();
        return reverseInteger.reverse(request.getX());
    }

    @PostMapping("/string-to-integer")
    public Object stringToInteger(@RequestBody StringToIntegerRequest request) {
        StringToInteger stringToInteger = new StringToInteger();
        return stringToInteger.myAtoi(request.getS());
    }

    @PostMapping("/palindrone-number")
    public Object palindromeNumber(@RequestBody PalindromeNumberRequest request) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        return palindromeNumber.isPalindrome(request.getX());
    }

    @PostMapping("/regular-expression")
    public Object regularExpression(@RequestBody RegularExpressionRequest request) {
        RegularExpression regularExpression = new RegularExpression();
        return regularExpression.isMatch(request.getS(), request.getP());
    }

    @PostMapping("/container-with-most-water")
    public Object containerWithMostWater(@RequestBody ContainerWithMostWaterRequest request) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        return containerWithMostWater.maxArea(request.getHeight().stream().mapToInt(i -> i).toArray());
    }

    @PostMapping("/integer-to-roman")
    public Object integerToRoman(@RequestBody IntegerToRomanRequest request) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        return integerToRoman.intToRoman(request.getNum());
    }

    @PostMapping("/roman-to-integer")
    public Object romanToInteger(@RequestBody RomanToIntegerRequest request) {
        RomanToInteger romanToInteger = new RomanToInteger();
        return romanToInteger.romanToInt(request.getS());
    }

    @PostMapping("/longest-common-prefix")
    public Object longestCommonPrefix(@RequestBody LongestCommonPrefixRequest request) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        return longestCommonPrefix.longestCommonPrefix(request.getStrs().toArray(new String[0]));
    }

    @PostMapping("/three-sum")
    public Object threeSum(@RequestBody ThreeSumRequest request) {
        ThreeSum threeSum = new ThreeSum();
        return threeSum.threeSum(request.getNums().stream().mapToInt(i -> i).toArray());
    }

    @PostMapping("/three-sum-closest")
    public Object threeSumClosest(@RequestBody ThreeSumClosestRequest request) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        return threeSumClosest.threeSumClosest(request.getNums().stream().mapToInt(i -> i).toArray(), request.getTarget());
    }

    @PostMapping("/phone-number-combination")
    public Object phoneNumberCombination(@RequestBody PhoneNumberCombinationRequest request) {
        PhoneNumberCombination phoneNumberCombination = new PhoneNumberCombination();
        return phoneNumberCombination.letterCombinations(request.getDigits());
    }

    @PostMapping("/four-Sum")
    public Object fourSum(@RequestBody FourSumRequest request) {
        FourSumSolution solution = new FourSumSolution();
        return solution.fourSum(Arrays.stream(request.getInput()).mapToInt(i -> i).toArray(), request.getTarget());
    }

    @PostMapping("/remove-nth-node-from-end-of-list")
    public Object removeNthNodeFromEndOfList(@RequestBody FourSumRequest request) {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        return removeNthNodeFromEndOfList.prepareListNode(Arrays.stream(request.getInput()).mapToInt(i -> i).toArray(), request.getTarget());
    }

    @PostMapping("/valid-parentheses")
    public Object validParentheses(@RequestBody StringToIntegerRequest request) {
        ValidParentheses validParentheses = new ValidParentheses();
        return validParentheses.isValid(request.getS());
    }

    @PostMapping("/merge-two-sorted-list")
    public Object mergeTwoSortedList(@RequestBody MergeTwoSortedListRequest request) {
        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        return mergeTwoSortedList.prepareNode(request.getList1(), request.getList2());
    }

    @PostMapping("/generate-parentheses")
    public Object generateParentheses(@RequestBody GenerateParenthesesRequest request) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        return generateParentheses.generateParenthesis(request.getN());
    }

    @PostMapping("/merge-k-sorted-list")
    public Object mergeKSortedList(@RequestBody MergeKSortedListRequest request) {
        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        return mergeKSortedList.prepareList(request.getLists());
    }

    @PostMapping("/swap-nodes-in-pairs")
    public Object swapNodesInPairs(@RequestBody SwapNodesInPairsRequest request) {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        return swapNodesInPairs.prepareNode(request.getValues());
    }

    @PostMapping("/reverse-k-group")
    public Object reverseKGroup(@RequestBody ReverseKGroupRequest request) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        return reverseKGroup.prepareNode(request.getList(), request.getK());
    }

    @PostMapping("/remove-duplicate")
    public Object removeDuplicate(@RequestBody RemoveDuplicateRequest request) {
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        return removeDuplicate.removeDuplicates(Arrays.stream(request.getNums()).mapToInt(i -> i).toArray());
    }

    @PostMapping("/remove-element")
    public Object removeElement(@RequestBody RemoveElementRequest request) {
        RemoveElement removeElement = new RemoveElement();
        return removeElement.removeElement(Arrays.stream(request.getNums()).mapToInt(i -> i).toArray(), request.getVal());
    }

}
