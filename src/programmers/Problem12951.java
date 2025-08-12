package programmers;

/**
 * @title JadenCase 문자열 만들기
 * @desc JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.<br>
 * 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)<br>
 * 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
 * @input s는 길이 1 이상 200 이하인 문자열입니다.<br>
 * s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.<br>
 * 숫자는 단어의 첫 문자로만 나옵니다.<br>
 * 숫자로만 이루어진 단어는 없습니다.<br>
 * 공백문자가 연속해서 나올 수 있습니다.
 * @output example. 3people Unfollowed Me
 * @studyStartDate 2025-08-11
 * @studyEndDate 2024-08-11
 */
public class Problem12951 {
	public static String solution(String s) {
		StringBuilder result = new StringBuilder();
		boolean isStart = true;
		
		for(char c : s.toCharArray()) {
			if(isStart) {
				result.append(Character.toUpperCase(c));
			} else {
				result.append(Character.toLowerCase(c));
			}
			
			isStart = ( c == ' ' );
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(solution("3people unFollowed me"));
	}
}