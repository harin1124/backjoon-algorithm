package backjoon;

import java.util.Scanner;

/**
 * @title 손익분기점
 * @desc 월드전자는 노트북을 제조하고 판매하는 회사이다.<br>
         노트북 판매 대수에 상관없이 매년 임대료, 재산세, 보험료, 급여 등 A만원의 고정 비용이 들며,<br>
         한 대의 노트북을 생산하는 데에는 재료비와 인건비 등 총 B만원의 가변 비용이 든다고 한다.<br>
         예를 들어 A=1,000, B=70이라고 하자.<br>
         이 경우 노트북을 한 대 생산하는 데는 총 1,070만원이 들며, 열 대 생산하는 데는 총 1,700만원이 든다.<br>
         노트북 가격이 C만원으로 책정되었다고 한다.<br>
         일반적으로 생산 대수를 늘려 가다 보면 어느 순간 총 수입(판매비용)이 총 비용(=고정비용+가변비용)보다 많아지게 된다.<br>
         최초로 총 수입이 총 비용보다 많아져 이익이 발생하는 지점을 손익분기점(BREAK-EVEN POINT)이라고 한다.
         A, B, C가 주어졌을 때, 손익분기점을 구하는 프로그램을 작성하시오.
 * @input 첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 21억 이하의 자연수이다.
 * @output 첫 번째 줄에 손익분기점 즉 최초로 이익이 발생하는 판매량을 출력한다. 손익분기점이 존재하지 않으면 -1을 출력한다.
 * @studyStartDate 2022-08-17
 * @studyEndDate 2022-08-
 */
public class problem1712 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt(); // 1000
		int b = scan.nextInt(); // 70
		int c = scan.nextInt(); // 170 만원
		scan.close();

		long result = 0;
		long price = 0;

		long i = 1;
		if(b > c){
			i = -1;
		}else{
			i = (a+b)/c;
			while(true){
				result = a + (b*i);
				price = (c * i);
				//System.out.println("판매대수 = "+i+"\t총 생산비용 = "+result+"\t총 판매비용 = "+(c * i));
				if(result < price){
					break;
				}
				i++;
			}
		}
		System.out.println(i);
	}
}
