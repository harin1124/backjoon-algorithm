package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 4. 연속 부분수열
 * @desc N개의 수로 이루어진 수열이 주어집니다.<br>
 *        이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.<br>
 *        만약 N=8, M=6이고 수열이 다음과 같다면<br>
 *        1 2 1 3 1 1 1 2<br>
 *        합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
 * @input 첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.<br>
 *         수열의 원소값은 1,000을 넘지 않는 자연수이다.
 * @output 첫째 줄에 경우의 수를 출력한다.
 * @studyStartDate 2023-01-28
 * @studyEndDate 2023-01-
 */
public class Problem_03_04 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] arr = new int[scan.nextInt()];
		int arrSize = arr.length;
		int correct = scan.nextInt();
		int cnt = 0;


		// 값 넣기
		int i = 0;
		for(i=0; i<arrSize; i++){
			arr[i] = scan.nextInt();
		}
		
		// 수열 찾기
		int j = 0;
		int temp = 0;

		for(i=0; i<arrSize; i++){
			System.out.printf("arr[%d] = %d", i, arr[i]);
			System.out.println();
			temp = 0;
			for(j=i; j<arrSize; j++){
				System.out.printf("\tarr[%d] = %d", j, arr[j]);
				System.out.println();
				temp += arr[j];
				System.out.println("\t\ttemp = "+temp);
				if(temp == correct){
					cnt++;
					break;
				} else if(temp > correct) {
					break;
				}
			}
		}
		


		bw.write("=======================\n");
		bw.write(cnt+"");
		bw.close();
		scan.close();
	}
}