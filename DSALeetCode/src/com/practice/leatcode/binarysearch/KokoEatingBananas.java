// Koko Eating Bananas

/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 */

package com.practice.leatcode.binarysearch;

import java.util.Arrays;

public class KokoEatingBananas {

	public static void main(String[] args) {
		int hours = 8;
		int piles[] = {3,6,7,11};
		int rateOfEatingBananas = minEatingSpeed(piles, hours);
		System.out.println("Rate Of Eating Bananas : "+rateOfEatingBananas);
	}

	public static int minEatingSpeed(int[] piles, int h) {
		int left = 1;
		int right = Arrays.stream(piles).max().getAsInt();

		while (left <= right) {
			int mid = (left + right) / 2;
			if (canEatAll(piles, mid, h)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}

	private static boolean canEatAll(int[] piles, int speed, int h) {
		int time = 0;
		for (int pile : piles) {
			time += (pile - 1) / speed + 1; // calculate the time required to eat this pile
			if (time > h) {
				return false; // if the total time is greater than h, return false
			}
		}
		return true; // if all piles can be eaten within h hours, return true
	}

}
