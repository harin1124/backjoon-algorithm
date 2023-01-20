package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 8. 등수구하기
 * @desc N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.<br>
 *       같은 점수가 입력될 경우 높은 등수로 동일 처리한다.<br>
 *       즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
 * @input 첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.
 * @output 입력된 순서대로 등수를 출력한다.
 * @studyStartDate 2023-01-19
 * @studyEndDate 2023-01-20
 */
public class Problem_02_08 {
	// 쉽게 배열 값 확인하기 위한 디버깅 메소드
	public static void printScores(int[] s, String name){
		System.out.print(name+"[] = ");
		for(int x : s){
			System.out.printf("%3d", x);
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력 값이 담기는 배열
		int[] scores = new int[Integer.parseInt(scan.nextLine())];
		// 등수가 담기는 배열
		int[] result = new int[scores.length];
		
		int i=0;
		// 입력 값 scores에 넣기
		for(i=0; i<scores.length; i++){
			scores[i] = scan.nextInt();
		}
		
		int prevScore = 0;     // 이전값
		int highScoreIdx = 0;  // 배열 중의 최고 값의 인덱스
		int highScore = 0;     // 배열 중의 최고 값
		int rank = 0;          // 등수
		int cnt = 1;           // 동일 등수 카운터

		int loop = 0;
		while(loop < scores.length){
			//printScores(scores, "scores");
			highScoreIdx = 0;
			highScore = 0;
			for(i=0; i<scores.length; i++){
				// scores의 값 하나하나 보면서, 가장 큰 수 찾아서
				// 큰 수의 값과 인덱스 기록
				if(scores[i] > highScore){
					highScore = scores[i];
					highScoreIdx = i;
				}
			}
			// scores에 더 이상, 최고값으로 찾지 못하도록 -1 넣기
			scores[highScoreIdx] = -1;
			//printScores(scores, "scores");

			// 이전에 뽑은 최고값과 동일하다면
			if(prevScore == highScore){
				// 기존 등수를 유지하면서, 다른 점수가 들어오면 그만큼 등수(rank)를 증가시켜야되므로 cnt 증가
				cnt++;
			} else {
				// cnt가 누적되었다면 => 이전에 뽑은 최고값과 동일하지 않고, 누적된 cnt가 있다면
				if(cnt > 1){
					// 등수 반영할 때, 반영해야하는 rank에 cnt를 더함
					rank = rank+cnt;
					// cnt는 반영되었으므로 다시 1로 초기화
					cnt = 1;
				} else {
					// 단순 등수 증가
					rank++;
				}
			}

			// 결과 배열의 최고점의 인덱스에 등수 넣기
			result[highScoreIdx] = rank;
			// 이전값을 지금 뽑은 최고값으로 할당
			prevScore = highScore;
			//printScores(result, "result");
			loop++;
		}

		// 답 출력
		for(int x : result){
			bw.write(x+" ");
		}

		bw.close();
		scan.close();
	}
}