package backjoon;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @title 단어 공부
 * @desc 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.<br>
		 단, 대문자와 소문자를 구분하지 않는다.
 * @input 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
 * @output 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다.<br>
		   단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 * @studyStartDate 2022-08-09
 * @studyEndDate 2022-08-09
 */
public class problem1157 {
	/* ===================================
	예제 입력                  예제 출력
	Mississipi                 ?
	zZa	                       Z
	z                          Z
	baaa                       A
	=================================== */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] str = scan.nextLine().toUpperCase().split("");
		scan.close();

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for(String s : str){
			if(map.get(s) == null){
				map.put(s, 1);
			}else{
				map.put(s, map.get(s)+1);
			}
		}

		//map.keySet().forEach(i->System.out.println(i + " = "+ map.get(i)));

		// max 값 찾기
		String maxKey = "";
		int maxValue = 0;
		for(String k : map.keySet()){
			if(maxValue < map.get(k)){
				maxValue = map.get(k);
				maxKey = k;
			}
		}

		//System.out.println("maxKey = "+maxKey);
		//System.out.println("maxValue = "+maxValue);

		for(String k : map.keySet()){
			if(!k.equals(maxKey) && maxValue == map.get(k)){
				maxKey = "?";
				break;
			}
		}

		System.out.println(maxKey);
	}
}
