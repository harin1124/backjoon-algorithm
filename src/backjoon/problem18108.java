package backjoon;

import java.util.Scanner;

/**
 * @title 1998년생인 내가 태국에서는 2541년생?!
 * @desc ICPC Bangkok Regional에 참가하기 위해 수완나품 국제공항에 막 도착한 팀 레드시프트 일행은 눈을 믿을 수 없었다.<br>
 		 공항의 대형 스크린에 올해가 2562년이라고 적혀 있던 것이었다.<br>
 		 불교 국가인 태국은 불멸기원(佛滅紀元), 즉 석가모니가 열반한 해를 기준으로 연도를 세는 불기를 사용한다.<br>
 		 반면, 우리나라는 서기 연도를 사용하고 있다.<br>
 		 불기 연도가 주어질 때 이를 서기 연도로 바꿔 주는 프로그램을 작성하시오.
 * @input 서기 연도를 알아보고 싶은 불기 연도 y가 주어진다. (1000 ≤ y ≤ 3000)
 * @output 불기 연도를 서기 연도로 변환한 결과를 출력한다.
 * @studyStartDate 2022-02-02
 * @studyEndDate 2022-02-02
 */
public class problem18108 {
	/* ====================================
	예제 입력
	2541
	
	예제 출력
	1998
	==================================== */ 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(scan.nextInt() - 543);
		scan.close();
	}
}