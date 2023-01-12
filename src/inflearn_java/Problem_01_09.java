package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 9. 숫자만 추출
 * @desc 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.<br>
 *       만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.<br>
 *       추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
 * @input 첫 줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.
 * @output 첫 줄에 자연수를 출력합니다.
 * @studyStartDate 2023-01-12
 * @studyEndDate 2023-01-12
 */
public class Problem_01_09 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 정규식으로 숫자가 아닌 것들은 제외
		String str = br.readLine().replaceAll("[\\D]", "");
		// Integer.valueOf 로 변환 시 자동적으로 앞에 있는 0은 제거
		bw.write(Integer.valueOf(str)+"");
		bw.close();
		br.close();
	}
}