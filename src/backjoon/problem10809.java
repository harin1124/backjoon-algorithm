package backjoon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @title 알파벳 찾기
 * @desc 알파벳 소문자로만 이루어진 단어 S가 주어진다.<br>
		 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
 * @input 첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
 * @output 각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.<br>
		   만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다. 단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.
 * @studyStartDate 2022-08-05
 * @studyEndDate 2022-08-05
 */
public class problem10809 {
	public static void main(String[] args) {		
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		scan.close();
		
		
		int[] az = new int[26];
		Arrays.fill(az, -1);
		
		int j;
		for(int i=0, len=s.length(); i<len; i++){
			j = ((int)s.charAt(i))-97;			
			if(az[j] == -1){
				az[j] = i;
			}
		}
		
		for(int i : az){
			System.out.print(i+" ");
		}
	}
}