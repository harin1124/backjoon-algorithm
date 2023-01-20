package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 7. 점수계산
 * @desc OX 문제는 맞거나 틀린 두 경우의 답을 가지는 문제를 말한다.<br>
 *       여러 개의 OX 문제로 만들어진 시험에서 연속적으로 답을 맞히는 경우에는<br>
 *       가산점을 주기 위해서 다음과 같이 점수 계산을 하기로 하였다.<br>
 *       1번 문제가 맞는 경우에는 1점으로 계산한다.<br>
 *       앞의 문제에 대해서는 답을 틀리다가 답이 맞는 처음 문제는 1점으로 계산한다.
 * @input 첫째 줄에 문제의 개수 N (1 ≤ N ≤ 100)이 주어진다.<br>
 *        둘째 줄에는 N개 문제의 채점 결과를 나타내는 0 혹은 1이 빈 칸을 사이에 두고 주어진다.
 *        0은 문제의 답이 틀린 경우이고, 1은 문제의 답이 맞는 경우이다.
 * @output 첫째 줄에 입력에서 주어진 채점 결과에 대하여 가산점을 고려한 총 점수를 출력한다.
 * @studyStartDate 2023-01-19
 * @studyEndDate 2023-01-19
 */
public class Problem_02_07 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(scan.nextLine());
		int score = 0;
		int accrue = 0;
		int temp = 0;
		for(int i=0; i<size; i++){
			if(scan.nextInt() == 1){
				accrue++;
				score += accrue;
			} else {
				accrue = 0;
			}
		}

		bw.write(score+"");
		scan.close();
		bw.close();
	}
}