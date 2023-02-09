package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

/**
 * @title 2. 괄호문자제거
 * @desc 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
 * @input 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 * @output 남은 문자만 출력한다.
 * @studyStartDate 2023-02-09
 * @studyEndDate 2023-02-09
 */
public class Problem_05_02 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = scan.nextLine();

		Stack<Character> stack = new Stack<>();

		for(Character c : str.toCharArray()){
			if(c == 41){
				while(true){
					if(stack.isEmpty() || stack.pop() == 40){
						break;
					}
				}
			} else {
				stack.push(c);
			}
		}

		for(Character c: stack){
			bw.write(c+"");
		}

		bw.close();
		scan.close();
	}
}