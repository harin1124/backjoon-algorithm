package backjoon;

import java.util.Scanner;

/**
 * @title 더하기 사이클
 * @desc 0보다 크거나 같고, 99보다 작거나 같은 정수가 주어질 때 다음과 같은 연산을 할 수 있다.<br>
		 먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고, 각 자리의 숫자를 더한다.<br>
		 그 다음, 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를<br>
		 이어 붙이면 새로운 수를 만들 수 있다. 다음 예를 보자.<br>
		 26부터 시작한다. 2+6 = 8이다. 새로운 수는 68이다. 6+8 = 14이다.<br>
		 새로운 수는 84이다. 8+4 = 12이다. 새로운 수는 42이다. 4+2 = 6이다. 새로운 수는 26이다.
		 위의 예는 4번만에 원래 수로 돌아올 수 있다. 따라서 26의 사이클의 길이는 4이다.
		 N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램을 작성하시오.
 * @input 첫째 줄에 N이 주어진다. N은 0보다 크거나 같고, 99보다 작거나 같은 정수이다.
 * @output 첫째 줄에 N의 사이클 길이를 출력한다.
 * @studyStartDate 2022-02-03
 * @studyEndDate 2022-07-10
 */
public class problem1110 {
	/* ====================================
	예제 입력
	26
	
	예제 출력
	4
	==================================== */ 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Integer num = 26; //scan.nextInt();
		scan.close();
		
		String origin = String.valueOf(num);
		
		String num01 = origin;
		String num02 = "";
		
		int cycle = 0;
		Integer firstNum = 0;
		Integer secondNum = 0;
		int hap = 0;
		while(true) {
			if(num01.length() > 1){
				firstNum = Integer.valueOf(num01.substring(0, 1));
				secondNum = Integer.valueOf(num01.substring(1, 2));
			}else{
				firstNum = 0;
				secondNum = Integer.valueOf(num01.substring(0, 1));
			}
			hap = firstNum + secondNum;
			
			// 뒷자리는 한자리수면 그냥 하고 아니면 숫자 자르기 필요
			num02 = (hap >= 10) ? String.valueOf(hap).substring(1, 2) : String.valueOf(hap);
			
			num01 = (secondNum == 0) ? num02 : secondNum + num02;
			System.out.println("new num = "+num01);
			
			++cycle;
			
			if(num01.equals(origin)){
				break;
			}
		}
		System.out.println(cycle);
	}
}