//  Daily Temperatures

//Given an array of integers temperatures represents the daily temperatures,
//return an array answer such that answer[i] is the number of days you have to wait
//after the ith day to get a warmer temperature. If there is no future day for which this is possible,
//keep answer[i] == 0 instead.
// 
//
//Example 1:
//
//Input: temperatures = [73,74,75,71,69,72,76,73]
//Output: [1,1,4,2,1,1,0,0]
//Example 2:
//
//Input: temperatures = [30,40,50,60]
//Output: [1,1,1,0]
//Example 3:
//
//Input: temperatures = [30,60,90]
//Output: [1,1,0]
// 
//
//Constraints:
//
//1 <= temperatures.length <= 105
//30 <= temperatures[i] <= 100

package com.practice.leetcode.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

	public static int[] dailyTemperatures(int[] T) {
		int[] result = new int[T.length];
		for (int day = T.length - 1; day >= 0; day--) {
			for (int i = day - 1; i >= 0 && T[i] < T[day]; i--) {
				result[i] = day - i;
			}
			System.out.println("printing !!");
			Arrays.stream(result).forEach(System.out::println);
		}
		return result;
	}
	
    public static int[] dailyTemperaturesUsingStack(int[] temperatures) {
        int n = temperatures.length;
        int res[] = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++)
        {
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()])
            {
                res[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }
        return res;
    }

	public static void main(String[] args) {
		int []temperatures = {73,74,75,71,69,72,76,73};
		int []result = dailyTemperatures(temperatures);
		//int []result = dailyTemperaturesUsingStack(temperatures);
		
		System.out.println("result array !!");
		Arrays.stream(result).forEach(System.out::println);

	}

}
