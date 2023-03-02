package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

/**
 * @title 4. 후위식 연산(postfix)
 * @desc 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.<br>
 *       만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
 * @input 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.<br>
 *        식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
 * @output 연산한 결과를 출력합니다.
 * @studyStartDate 2023-03-02
 * @studyEndDate 2023-03-02
 */
public class Problem_05_04 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Integer> stack = new Stack<>();
		int lt;
		int rt;

		for(Character s : scan.nextLine().toCharArray()){
			// 숫자면 stack에 넣기
			if(49 <= s && s <= 58){
				stack.push(Integer.parseInt(s.toString()));
			} else {
				rt = stack.pop();
				lt = stack.pop();
				switch(s.toString()){
					case "+":
						stack.push(lt+rt);
						break;
					case "-":
						stack.push(lt-rt);
						break;
					case "*":
						stack.push(lt*rt);
						break;
					case "/":
						stack.push(lt/rt);
						break;
				}
			}
		}
		bw.write(stack.get(0)+"");
		bw.close();
		scan.close();
	}
}