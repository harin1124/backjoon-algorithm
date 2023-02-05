package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @title 4. 모든 아나그램 찾기
 * @desc S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.<br>
 * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
 * @input 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.<br>
 * S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
 * @output S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
 * @studyStartDate 2023-02-04
 * @studyEndDate 2023-02-05
 */
public class Problem_04_04 {
	public static void main(String[] args) throws Exception {
		// 강의 보고 푼 풀이
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String a = scan.nextLine();
		String b = scan.nextLine();

		HashMap<Character, Integer> am = new HashMap<>();
		HashMap<Character, Integer> bm = new HashMap<>();

		for(char x : b.toCharArray()){
			bm.put(x, bm.getOrDefault(x, 0)+1);
		}

		int result = 0;

		// 기본 한 바퀴
		int L = b.length()-1;
		for(int i=0; i<L; i++){
			am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0)+1);
		}
		// 나머지
		int lt = 0;
		for(int rt=L; rt<a.length(); rt++){
			am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0)+1);
			if(am.equals(bm)){
				result++;
			}
			am.put(a.charAt(lt), am.get(a.charAt(lt))-1);
			if(am.get(a.charAt(lt)) == 0){
				am.remove(a.charAt(lt));
			}
			lt++;
		}
		bw.write(result+"");
		bw.close();
		scan.close();
	}
}