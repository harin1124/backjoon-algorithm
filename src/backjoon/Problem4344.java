package backjoon;

import java.util.Scanner;

/**
 * @title 평균은 넘겠지
 * @desc 대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다.
		 당신은 그들에게 슬픈 진실을 알려줘야 한다.
 * @input 첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
		  둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다.
		  점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
 * @output 각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
 * @studyStartDate 2022-07-29
 * @studyEndDate 2022-08-01
 */
public class Problem4344 {
	/* ====================================
	예제 입력
	5
	5 50 50 70 80 100
	7 100 95 90 80 70 60 50
	3 70 90 80
	3 70 90 81
	9 100 99 98 97 96 95 94 93 91
	
	예제 출력
	40.000%
	57.143%
	33.333%
	66.667%
	55.556%
	==================================== */
	public static void main(String[] args)throws Exception{
		// Garbage Collection으로 메모리 초기화
		Runtime.getRuntime().gc();
		
		Scanner scan = new Scanner(System.in);
		
		// 개선사항 해당 for문 변수에 그대로 넣어도 됨. 변수 굳이 필요 없음
		double[] classMiddleScorePer = new double[(int)Integer.valueOf(scan.nextLine())]; // 결과 출력
		
		double classMemberSize = 0;
		double[] classMemberScore = null;
		double middleScore = 0;
		double middleScoreCnt = 0;
		for(int i=0; i<classMiddleScorePer.length; i++){
			classMemberSize = scan.nextInt();
			
			// 점수 입력
			classMemberScore = new double[(int)classMemberSize];
			for(int j=0; j<classMemberSize; j++){
				classMemberScore[j] = scan.nextInt();
			}
			// 점수 기반으로 평균 점수 구하기
			for(double j : classMemberScore){
				middleScore += j;
			}
			middleScore = middleScore / classMemberSize;
			System.out.println("평균 점수 : "+middleScore);
			
			// 평균보다 큰 점수 찾아서 갯수 카운트
			for(double j : classMemberScore){
				//System.out.print("\t점수 : "+j);
				if(j > middleScore) {
					//System.out.print("\t평균보다 높은 점수");
					middleScoreCnt++;
				}
				//System.out.println();
			}
			classMiddleScorePer[i] = Double.valueOf(String.format("%.03f", (middleScoreCnt / classMemberSize * 100)));
			//System.out.println("\t평균이상"+classMiddleScorePer[i]+"%");
			
			middleScore = 0;
			middleScoreCnt = 0;
		}
		scan.close();
		
		for(double i : classMiddleScorePer){
			System.out.printf("%.3f",i);
			System.out.print("%");
			System.out.println();
		}
		
		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("used memory is " + used + " bytes");
	}
}
