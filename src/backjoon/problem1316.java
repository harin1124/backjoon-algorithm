package backjoon;

import java.util.Scanner;

/**
 * @title 그룹 단어 체커
 * @desc 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.<br>
         예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,<br>
         aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
 * @input 첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다.<br>
          둘째 줄부터 N개의 줄에 단어가 들어온다.<br>
          단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
 * @output 첫째 줄에 그룹 단어의 개수를 출력한다.
 * @studyStartDate 2022-08-16
 * @studyEndDate 2022-08-17
 */
public class problem1316 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = Integer.parseInt(scan.nextLine());

		String[] list = new String[size];

		String str = "";
		String nextStr = "";
		int result = size;

		for(int i=0; i<size; i++){
			list[i] = scan.nextLine();
			str = String.valueOf(list[i].charAt(0));
			for(int j=1; j<list[i].length(); j++){
				nextStr = String.valueOf(list[i].charAt(j));
				// str에 nextStr(다음문자열)이 포함되어 있지 않을 때 || str에 nextStr이 포함되어 있고, str의 마지막 문자열과 nextStr이 동일할 때 => 같은 문자가 반복되므로 그룹인 것이니까
				if(!str.contains(nextStr) || ( str.contains(nextStr) && String.valueOf(str.charAt(str.length()-1)).equals(nextStr) )){
					str += nextStr;
				}else{
					result--;
					break;
				}
			}
			str = "";
			nextStr = "";
		}
		System.out.println(result);
	}
}
