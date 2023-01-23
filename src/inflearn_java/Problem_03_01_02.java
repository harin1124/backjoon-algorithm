package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @title 1. 두 배열 합치기
 * @desc 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 * @input 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.<br>
 *        두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.<br>
 *        세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.<br>
 *        네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.<br>
 *        각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
 * @output 오름차순으로 정렬된 배열을 출력합니다.
 * @studyStartDate 2023-01-23
 * @studyEndDate 2023-01-23
 */
public class Problem_03_01_02 {
	// 강의 풀이대로 푼 방법
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int i = 0;

		// 두 배열에 값 담기
		int[] arr1 = new int[scan.nextInt()];
		for(i=0; i<arr1.length; i++){
			arr1[i] = scan.nextInt();
		}
		int[] arr2 = new int[scan.nextInt()];
		for(i=0; i<arr2.length; i++){
			arr2[i] = scan.nextInt();
		}

		// 정렬 수행
		ArrayList<Integer> result = new ArrayList<>();
		int p1 = 0;
		int p2 = 0;
		int n = arr1.length;
		int m = arr2.length;
		while(p1<n && p2<m){
			if(arr1[p1] < arr2[p2]){
				result.add(arr1[p1++]);
			} else {
				result.add(arr2[p2++]);
			}
		}
		// 어느 하나 배열이 포인터가, 배열의 갯수보다 작다면, 아직 다 조회하지 못한 것이므로 조건부로 조회하여 result에 add
		while(p1<n){
			result.add(arr1[p1++]);
		}
		while(p2<m){
			result.add(arr2[p2++]);
		}

		// 정답 출력
		for(int x : result){
			bw.write(x+" ");
		}
		bw.close();
		scan.close();
	}
}