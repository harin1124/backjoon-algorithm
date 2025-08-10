package leetcode;

import java.util.Arrays;

/**
 * @title Find the Distance Value Between Two Arrays
 * @desc Given two integer arrays arr1 and arr2, and the integer d, return the distance value between the two arrays.
 * The distance value is defined as the number of elements arr1[i] such that there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d
 * @studyStartDate 2025-08-10
 * @studyEndDate 2025-08-10
 */
public class Problem1385 {
	static class Solution {
		static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
			// 절대값 기준 정렬
			arr2 = Arrays.stream(arr2)
					.boxed()
					.sorted((a, b) -> Integer.compare(Math.abs(b), Math.abs(a)))
					.mapToInt(Integer::intValue)
					.toArray();
			
			int arr1size = arr1.length;
			int arr2size = arr2.length;
			
			int result = 0;
			
			for(int i = 0; i < arr1size; i++) {
				boolean flag = true;
				for(int j = 0; j < arr2size; j++) {
					if(Math.abs(arr1[i] - arr2[j]) <= d) {
						flag = false;
						break;
					}
				}
				if(flag) {
					result++;
				}
			}
			
			return result;
		}
	}
	public static void main(String[] args) {
		// example
		int[] arr1 = {1,4,2,3};
		int[] arr2 = {-4,-3,6,10,20,30};
		int d = 3;
		
		System.out.println(Solution.findTheDistanceValue(arr1, arr2, d));
	}
}
