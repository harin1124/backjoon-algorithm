package backjoon;

import java.util.Scanner;

/**
 * @title 상수
 * @desc 상근이의 동생 상수는 수학을 정말 못한다. 상수는 숫자를 읽는데 문제가 있다.<br>
         이렇게 수학을 못하는 상수를 위해서 상근이는 수의 크기를 비교하는 문제를 내주었다.<br>
         상근이는 세 자리 수 두 개를 칠판에 써주었다.<br>
         그 다음에 크기가 큰 수를 말해보라고 했다.<br>
         상수는 수를 다른 사람과 다르게 거꾸로 읽는다.<br>
         예를 들어, 734와 893을 칠판에 적었다면, 상수는 이 수를 437과 398로 읽는다.<br>
         따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다.
 * @input 첫째 줄에 상근이가 칠판에 적은 두 수 A와 B가 주어진다.<br>
          두 수는 같지 않은 세 자리 수이며, 0이 포함되어 있지 않다.
 * @output 첫째 줄에 상수의 대답을 출력한다.
 * @studyStartDate 2022-08-11
 * @studyEndDate 2022-08-11
 */
public class Problem2908 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] s = scan.nextLine().split(" ");
		scan.close();

		// 48 ~ 57
		int winner = -1;
		for(int i=2; i>=0; i--){
			if(winner == -1){
				if(s[0].charAt(i) > s[1].charAt(i)){
					winner = 0;
				}else if(s[0].charAt(i) < s[1].charAt(i)){
					winner = 1;
				}
			}else{
				break;
			}
		}
		for(int i=2; i>=0; i--){
			System.out.print(s[winner].charAt(i));
		}
	}
}
