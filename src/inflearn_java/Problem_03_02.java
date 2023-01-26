package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @title 2. 공통원소 구하기
 * @desc A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
 * @input 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.<br>
           두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.<br>
           세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.<br>
           네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.<br>
           각 집합의 원소는 1,000,000,000이하의 자연수입니다.
 * @output 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
 * @studyStartDate 2023-01-26
 * @studyEndDate 2023-01-26
 */
public class Problem_03_02 {
	public static void main(String[] args) throws Exception {
		// 시간 초과로 제대로 풀지 못해 강의 보며 푼 풀이
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int i = 0;
		int j = 0;
		int temp = 0;

		// 두 배열에 값 담기
		int[] arr1 = new int[scan.nextInt()];
		int arr1Size = arr1.length;
		for(i=0; i<arr1Size; i++){
			arr1[i] = scan.nextInt();
		}
		Arrays.sort(arr1);

		int[] arr2 = new int[scan.nextInt()];
		int arr2Size = arr2.length;
		for(i=0; i<arr2.length; i++){
			arr2[i] = scan.nextInt();
		}
		Arrays.sort(arr2);

		// 중복원소 찾기
		int p1 = 0;
		int p2 = 0;
		while(p1 < arr1Size && p2 < arr2Size){
			if(arr1[p1] == arr2[p2]){
				bw.write(arr1[p1]+" ");
				p1++;
				p2++;
			} else if(arr1[p1] > arr2[p2]) {
				p2++;
			} else {
				p1++;
			}
		}
		bw.close();
		scan.close();
	}
}