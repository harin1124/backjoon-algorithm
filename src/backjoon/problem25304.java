package backjoon;

import java.util.Scanner;

/**
 * @title 영수증
 * @desc 준원이는 저번 주에 살면서 처음으로 코스트코를 가 봤다. 정말 멋졌다.<br>
         그런데, 몇 개 담지도 않았는데 수상하게 높은 금액이 나오는 것이다!<br>
         준원이는 영수증을 보면서 정확하게 계산된 것이 맞는지 확인해보려 한다.<br>
         영수증에 적힌,<br>
         구매한 각 물건의 가격과 개수<br>
         구매한 물건들의 총 금액<br>
         을 보고, 구매한 물건의 가격과 개수로 계산한 총 금액이 영수증에 적힌 총 금액과 일치하는지 검사해보자.
 * @input 첫째 줄에는 영수증에 적힌 총 금액 X가 주어진다.<br>
          둘째 줄에는 영수증에 적힌 구매한 물건의 종류의 수 N이 주어진다.<br>
          이후 N개의 줄에는 각 물건의 가격 a와 개수 b가 공백을 사이에 두고 주어진다.
 * @output 구매한 물건의 가격과 개수로 계산한 총 금액이 영수증에 적힌 총 금액과 일치하면 Yes를 출력한다.<br>
           일치하지 않는다면 No를 출력한다.
 * @studyStartDate 2022-08-17
 * @studyEndDate 2022-08-17
 */
public class problem25304 {
	/*
	입력 예제

	260000
	4
	20000 5
	30000 2
	10000 6
	5000 8
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int totalPrice = scan.nextInt();
		int productCnt = scan.nextInt();

		int tempPrice = 0;
		for(int i=0; i<productCnt; i++){
			tempPrice += (scan.nextInt() * scan.nextInt());
		}
		scan.close();
		System.out.println((totalPrice == tempPrice) ? "Yes" : "No");
	}
}