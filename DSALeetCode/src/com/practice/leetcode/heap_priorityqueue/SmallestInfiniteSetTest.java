package com.practice.leetcode.heap_priorityqueue;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Consumer;
import java.util.function.Function;

//Smallest Number in Infinite Set

//You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
//
//Implement the SmallestInfiniteSet class:
//
//SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
//int popSmallest() Removes and returns the smallest integer contained in the infinite set.
//void addBack(int num) Adds a positive integer num back into the infinite set,
//if it is not already in the infinite set.



//Explanation
//SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
//smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
//smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
//smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
//smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
//smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
//smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
//                                   // is the smallest number, and remove it from the set.
//smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
//smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.

class SmallestInfiniteSet {

    private Integer minNum;
    private PriorityQueue<Integer> heap;

    public SmallestInfiniteSet() {
        minNum = 1;
        heap = new PriorityQueue<>();
    }
    
   public Integer popSmallest() {
       System.out.println("Currentques has "+ heap);
        if (!heap.isEmpty()) {
            return heap.poll();
        }
        minNum++;
        return minNum - 1;
    }

    public void addBack(int num) {
        if (minNum > num && !heap.contains(num)) {
            heap.offer(num);
            System.out.println("Adding element "+ num);
        }
    }
}

class SmallestInfiniteSetTest{
	
	public static void main(String args[]) {
		SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
		smallestInfiniteSet.addBack(2);
		smallestInfiniteSet.addBack(2);
		smallestInfiniteSet.popSmallest();
		smallestInfiniteSet.popSmallest();
		smallestInfiniteSet.popSmallest();
		smallestInfiniteSet.addBack(1); 
		smallestInfiniteSet.popSmallest();
		smallestInfiniteSet.popSmallest();
	}
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
