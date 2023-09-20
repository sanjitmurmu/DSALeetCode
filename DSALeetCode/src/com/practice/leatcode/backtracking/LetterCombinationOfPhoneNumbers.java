//Letter Combinations of a Phone Number

/**Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]*/
 

package com.practice.leatcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumbers {

	public static void main(String[] args) {
		String digits = "23";
		List<String> result = letterCombinations(digits);
		System.out.println("Combinations are : ");
		System.out.println(result);

	}

	final static char[][] L = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	public static List<String> letterCombinations(String D) {
		int len = D.length();
		List<String> ans = new ArrayList<>();
		if (len == 0)
			return ans;
		backTrack(0, len, new StringBuilder(), ans, D);
		return ans;
	}

	public static void backTrack(int pos, int len, StringBuilder sb, List<String> ans, String D) {
		System.out.println("position : " + pos + " , string formed : " + sb.toString());
		if (pos == len)
			ans.add(sb.toString());
		else {
			char[] letters = L[Character.getNumericValue(D.charAt(pos))];
			for (int i = 0; i < letters.length; i++)
				backTrack(pos + 1, len, new StringBuilder(sb).append(letters[i]), ans, D);
		}
	}

}
