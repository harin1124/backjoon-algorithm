package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @title 평균
 * @desc 세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다.<br>
		 일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다.<br>
		 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.<br>
		 예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.<br>
		 세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.
 * @input 첫째 줄에 시험 본 과목의 개수 N이 주어진다. 이 값은 1000보다 작거나 같다. 둘째 줄에 세준이의 현재 성적이 주어진다.<br>
		  이 값은 100보다 작거나 같은 음이 아닌 정수이고, 적어도 하나의 값은 0보다 크다.<br>
		  이 숫자는 1,000보다 작거나 같고, 음이 아닌 정수이다.
 * @output 첫째 줄에 새로운 평균을 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10-2 이하이면 정답이다.
 * @studyStartDate 2022-07-27
 * @studyEndDate 2022-07-27
 */
public class Problem1546 {
	/* ====================================
	예제 입력
	3
	40 80 60
	
	예제 출력
	75.0
	==================================== */
	public static void main(String[] args) throws Exception {
		// Garbage Collection으로 메모리 초기화
		Runtime.getRuntime().gc();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double[] score = new double[Integer.valueOf(br.readLine())];
		
		// 1. 배열로 만들기 + M 구하기
		String[] s = br.readLine().split(" ");
		double m = 0;
		double n = 0;
		for(int i=0; i<score.length; i++){
			n = Integer.valueOf(s[i]);
			if(m <= n){
				m = n;
			}
			score[i] = n;
		}
		
		// 2. 새로운 평균 구하기 (n을 활용하기)
		n = 0;
		for(int i=0; i<score.length; i++){
			n += (score[i]/m*100);
		}
		
		System.out.println(n/score.length);
		br.close();
		
		
		
		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("used memory is " + used + " bytes");

		//used memory is 651312 bytes
	}
}