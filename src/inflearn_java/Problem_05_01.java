package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

/**
 * @title 1. 올바른 괄호
 * @desc 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.<br>
 * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
 * @input 첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
 * @output 첫 번째 줄에 YES, NO를 출력한다.
 * @studyStartDate 2023-02-09
 * @studyEndDate 2023-02-09
 */
public class Problem_05_01 {
	public static void main(String[] args) throws Exception {
		// 강의 보고 푼 풀이 => 풀이 개념만 보고 품
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = scan.nextLine();
		String result = "YES";

		Stack<Character> stack = new Stack<>();

		// 여는 괄호 만나면, 스택에 넣고, 닫는 괄호 만나면 스택에서 제거
		// 스택에서 제거할 때 스택이 비어있다면 잘못된 괄호이다.
		for(Character c : str.toCharArray()){
			if(c == 40){
				stack.push(c);
			} else {
				if(stack.isEmpty()){
					result = "NO";
					break;
				}
				stack.pop();
			}
		}
		// 강의보고 추가한 부분 => 마지막 예외처리
		// 올바른 괄호들이면 스택에 열림 괄호가 있어서는 안됌
		if(!stack.isEmpty()){
			result = "NO";
		}
		bw.write(result);
		bw.close();
		scan.close();
	}
}