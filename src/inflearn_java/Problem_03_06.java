package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 6. 최대 길이 연속부분수열
 * @desc 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.<br>
 *        여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.<br>
 *        만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면<br>
 *        1 1 0 0 1 1 0 1 1 0 1 1 0 1<br>
 *        1 1 0 0 [1 1 1 1 1 1 1 1] 0 1<br>
 *        이며 그 길이는 8입니다.
 * @input 첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.<br>
 *         두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
 * @output 첫 줄에 최대 길이를 출력하세요.
 * @studyStartDate 2023-01-29
 * @studyEndDate 2023-01-29
 */
public class Problem_03_06 {
	public static void main(String[] args) throws Exception {
		// 개념은 맞았으나, 로직을 짜는데 어려워 풀이보고 작성
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] arr = new int[scan.nextInt()];
		int zero = scan.nextInt();
		for(int i=0; i<arr.length; i++){
			arr[i] = scan.nextInt();
		}

		// 연속부분수열 찾기
		int lt = 0;
		int rt = 0;
		int max = 0;
		int zeroCnt = 0;

		for(rt=0; rt<arr.length; rt++){
			if(arr[rt] == 0){
				zeroCnt++;
			}
			while(zeroCnt > zero){
				if(arr[lt] == 0){
					zeroCnt--;
				}
				lt++;
			}
			if(max < rt-lt+1){
				max = rt-lt+1;
			}
		}
		bw.write(max+"");
		bw.close();
		scan.close();
	}
}