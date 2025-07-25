package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 세로읽기
 * @desc 아직 글을 모르는 영석이가 벽에 걸린 칠판에 자석이 붙어있는 글자들을 붙이는 장난감을 가지고 놀고 있다.<br>
 * 이 장난감에 있는 글자들은 영어 대문자 ‘A’부터 ‘Z’, 영어 소문자 ‘a’부터 ‘z’, 숫자 ‘0’부터 ‘9’이다.<br>
 * 영석이는 칠판에 글자들을 수평으로 일렬로 붙여서 단어를 만든다.<br>
 * 다시 그 아래쪽에 글자들을 붙여서 또 다른 단어를 만든다. 이런 식으로 다섯 개의 단어를 만든다.<br>
 * 아래 그림 1은 영석이가 칠판에 붙여 만든 단어들의 예이다.<br>
 * A A B C D D<br>
 * a f z z<br>
 * 0 9 1 2 1<br>
 * a 8 E W g 6<br>
 * P 5 h 3 k x<br>
 * <그림 1><br>
 * 한 줄의 단어는 글자들을 빈칸 없이 연속으로 나열해서 최대 15개의 글자들로 이루어진다.<br>
 * 또한 만들어진 다섯 개의 단어들의 글자 개수는 서로 다를 수 있다.<br>
 * 심심해진 영석이는 칠판에 만들어진 다섯 개의 단어를 세로로 읽으려 한다.<br>
 * 세로로 읽을 때, 각 단어의 첫 번째 글자들을 위에서 아래로 세로로 읽는다. 다음에 두 번째 글자들을 세로로 읽는다.<br>
 * 이런 식으로 왼쪽에서 오른쪽으로 한 자리씩 이동 하면서 동일한 자리의 글자들을 세로로 읽어 나간다.<br>
 * 위의 그림 1의 다섯 번째 자리를 보면 두 번째 줄의 다섯 번째 자리의 글자는 없다.<br>
 * 이런 경우처럼 세로로 읽을 때 해당 자리의 글자가 없으면, 읽지 않고 그 다음 글자를 계속 읽는다.<br>
 * 그림 1의 다섯 번째 자리를 세로로 읽으면 D1gk로 읽는다.
 * 그림 1에서 영석이가 세로로 읽은 순서대로 글자들을 공백 없이 출력하면 다음과 같다:<br>
 * Aa0aPAf985Bz1EhCz2W3D1gkD6x<br>
 * 칠판에 붙여진 단어들이 주어질 때, 영석이가 세로로 읽은 순서대로 글자들을 출력하는 프로그램을 작성하시오.
 * @input 총 다섯줄의 입력이 주어진다. 각 줄에는 최소 1개, 최대 15개의 글자들이 빈칸 없이 연속으로 주어진다.<br>
 * 주어지는 글자는 영어 대문자 ‘A’부터 ‘Z’, 영어 소문자 ‘a’부터 ‘z’, 숫자 ‘0’부터 ‘9’ 중 하나이다.<br>
 * 각 줄의 시작과 마지막에 빈칸은 없다.
 * @output 영석이가 세로로 읽은 순서대로 글자들을 출력한다. 이때, 글자들을 공백 없이 연속해서 출력한다.
 * @studyStartDate 2025-07-21
 * @studyEndDate 2025-07-21
 */
public class Problem10798 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[][] arr = new String[5][15];

		for(int i = 0; i < 5; i++) {
			String[] strArr = br.readLine().split("");
			int size = strArr.length;
			for(int j = 0; j < 15; j++) {
				if(size > j && strArr[j] != null) {
					arr[i][j] = strArr[j];
				}
			}
		}

		for(int j = 0; j < 15; j++) {
			for(int i = 0; i < 5; i++) {
				if(arr[i][j] != null) {
					sb.append(arr[i][j]);
				}
			}
		}

		bw.write(sb.toString());

		br.close();
		bw.flush();
		bw.close();
	}
}
