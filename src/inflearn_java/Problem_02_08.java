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
 * @studyEndDate 2023-01-
 */
public class Problem_02_08 {

	public static void printScores(int[] s, String name){
		System.out.print(name+"[] = ");
		for(int x : s){
			System.out.print(x+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] scores = new int[Integer.parseInt(scan.nextLine())];
		int[] result = new int[scores.length];
		int i=0;
		for(i=0; i<scores.length; i++){
			scores[i] = scan.nextInt();
		}

		int bestScore = 0;
		int highScoreIdx = 0;
		int highScore = 0;
		int rank = 1;
		int cnt = 1;

		while(true){
			printScores(scores, "최고값 제거 전 : scores");

			highScoreIdx = 0;
			highScore = 0;
			for(i=0; i<scores.length; i++){
				if(scores[i] > highScore){
					highScore = scores[i];
					highScoreIdx = i;
				}
			}
			scores[highScoreIdx] = -1;

			printScores(scores, "최고값 제거 후 : scores");
			if(highScore > bestScore){
				bestScore = highScore;
			}
			System.out.println("최고 베스트 값 : "+bestScore);
			System.out.println("현재 최고 값 : "+highScore);

			System.out.println("cnt : "+cnt);
			if(bestScore != highScore){
				if(cnt > 1){
					rank = cnt;
				} else {
					rank++;

				}
				cnt = 1;
			} else {
				cnt++;
			}
			result[highScoreIdx] = rank;
			printScores(result, "result");

			if(rank == scores.length){
				break;
			}
			System.out.println("==========================");
		}

		for(int x : result){
			bw.write(x+" ");
		}

		bw.close();
		scan.close();
	}
}