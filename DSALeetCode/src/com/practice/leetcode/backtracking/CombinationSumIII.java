//Combination Sum III

/*Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, 
and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.*/

package com.practice.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

	public static void main(String[] args) {
		int k = 2, n = 7;
		List<List<Integer>> ans = combinationSum3(k, n);
		System.out.println(ans);
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<Integer>(), k, n, 1);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int k, int remain, int start) {
		System.out.println("start = "+start+" k = "+k+" & n = "+remain);
		if (tempList.size() > k)
			return; /** no solution */
		else if (tempList.size() == k && remain == 0)
			list.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i <= 9; i++) {
				System.out.println("in loop , current val : "+tempList);
				tempList.add(i);
				System.out.println("after adding : "+tempList);
				backtrack(list, tempList, k, remain - i, i + 1);
				System.out.println("backtrack completed : "+ tempList);
				tempList.remove(tempList.size() - 1);
				System.out.println("after removal : "+tempList);
			}
		}
	}

}
