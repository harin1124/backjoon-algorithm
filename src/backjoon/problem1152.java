package backjoon;

import java.util.Scanner;

/**
 * @title 단어의 개수
 * @desc 영어 대소문자와 공백으로 이루어진 문자열이 주어진다.<br>
		 이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오.<br>
		 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.
 * @input 첫 줄에 영어 대소문자와 공백으로 이루어진 문자열이 주어진다.<br>
		  이 문자열의 길이는 1,000,000을 넘지 않는다.<br>
		  단어는 공백 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다.<br>
		  또한 문자열은 공백으로 시작하거나 끝날 수 있다.
 * @output 첫째 줄에 단어의 개수를 출력한다.
 * @studyStartDate 2022-08-10
 * @studyEndDate 2022-08-
 */
public class problem1152 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		//String s = scan.nextLine();
		String s = " The last character is a blank ";
		String[] list = s.split(" ");
		int x = list.length;

		for(String d : list){
			System.out.println(d);
		}

		if(list[0].equals("")){
			x--;
		}
		if(list[list.length-1].equals("")){
			x--;
		}


		System.out.println(x);
	}
}