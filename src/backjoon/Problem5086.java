package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @title 배수와 약수
 * @desc 4 × 3 = 12이다.<br>
 * 이 식을 통해 다음과 같은 사실을 알 수 있다.<br>
 * 3은 12의 약수이고, 12는 3의 배수이다.<br>
 * 4도 12의 약수이고, 12는 4의 배수이다.<br>
 * 두 수가 주어졌을 때, 다음 3가지 중 어떤 관계인지 구하는 프로그램을 작성하시오.<br>
 * 1. 첫 번째 숫자가 두 번째 숫자의 약수이다.<br>
 * 2. 첫 번째 숫자가 두 번째 숫자의 배수이다.<br>
 * 3. 첫 번째 숫자가 두 번째 숫자의 약수와 배수 모두 아니다.
 * @input 입력은 여러 테스트 케이스로 이루어져 있다.<br>
 * 각 테스트 케이스는 10,000이 넘지않는 두 자연수로 이루어져 있다.<br>
 * 마지막 줄에는 0이 2개 주어진다. 두 수가 같은 경우는 없다.
 * @output 각 테스트 케이스마다 첫 번째 숫자가 두 번째 숫자의 약수라면 factor를, 배수라면 multiple을, 둘 다 아니라면 neither를 출력한다.
 * @studyStartDate 2025-07-27
 * @studyEndDate 2025-07-27
 */
public class Problem5086 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		boolean flag = true;
		
		int a;
		int b;
		int result;
		
		String factor = "factor";
		String multiple = "multiple";
		String neither = "neither";
		
		while(flag) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(a == 0 && b == 0) {
				flag = false;
			} else {
				if (a < b) {
					result = b % a;
					bw.write(result == 0 ? factor : neither);
				} else {
					result = a % b;
					bw.write(result == 0 ? multiple : neither);
				}
				bw.write("\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}