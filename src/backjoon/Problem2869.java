package backjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @title 달팽이는 올라가고 싶다
 * @desc 땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다.
또, 정상에 올라간 후에는 미끄러지지 않는다.
달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
 * @input 첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)
 * @output 첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.
 * @studyStartDate 2022-08-25
 * @studyEndDate 2022-10-04
 */
public class Problem2869 {
	public static void main(String[] args) throws IOException {
		// 메모리 절약을 위해 BufferedReader와 StringTokenizer 사용
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		// 무조건 오전의 반나절 올라가는 것으로 끝나기 때문에
		// 올라가는 것은 전체 높이에서 올라가는 것을 뺀 높이 기준으로 계산하고 + 1 을 해준다.
		// v-a = 전체 높이에서 올라가는 것을 뺀 높이로, 마지막에 올라갈 A를 남겨두는 것
		// a-b = 하루에 올라갈 수 있는 높이
		// => v-a / a-b 는 v-a를 제외한 높이를 올라가는 데 걸리는 일 수 이며,
		// => 해당 일 수가 예를 들어 7.2일이면 7.2일은 내림이 불가능하고 무조건 하루로 쳐서
		// => (double) 형변환 후, Math.ceil로 숫자를 올림 처리를 하고 다시 int 자료형으로 바꾼다.
		// 그리고 마지막에 올라갈 A를 남겨두었으므로 해당 결과에 +1을 한다.
		int res = (int)Math.ceil((double)(v-a)/(a-b));
		System.out.println(res+1);
	}
}
