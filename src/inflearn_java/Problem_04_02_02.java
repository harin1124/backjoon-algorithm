package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

/**
 * @title 2. 아나그램(해쉬)
 * @desc Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.<br>
 * 예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로<br>
 * 알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.<br>
 * 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.
 * @input 첫 줄에 첫 번째 단어가 입력되고, 두 번째 줄에 두 번째 단어가 입력됩니다.<br>
 * 단어의 길이는 100을 넘지 않습니다.
 * @output 두 단어가 아나그램이면 "YES"를 출력하고, 아니면 "NO"를 출력합니다.
 * @studyStartDate 2023-02-04
 * @studyEndDate 2023-02-04
 */
public class Problem_04_02_02 {
	public static void main(String[] args) throws Exception {
		// 강의 보고 강의에서 나온 풀이대로 푼 방법
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		HashMap<Integer, Integer> map = new HashMap<>();
		String str = br.readLine();

		int i = 0;
		int c = 0;
		for(i=0; i<str.length(); i++){
			c = str.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		str = br.readLine();
		String result = "YES";
		for(i=0; i<str.length(); i++){
			c = str.charAt(i);
			// 여기서 판별
			if(!map.containsKey(c) || map.get(c) == 0){
				result = "NO";
				break;
			} else {
				map.put(c, map.get(c)-1);
			}
		}
		bw.write(result);
		bw.close();
		br.close();
	}
}