package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 직사각형에서 탈출
 * @desc 한수는 지금 (x, y)에 있다.<br>
 * 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다.<br>
 * 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
 * @input 첫째 줄에 x, y, w, h가 주어진다.
 * @output 첫째 줄에 문제의 정답을 출력한다.
 * @studyStartDate 2025-10-26
 * @studyEndDate 2025-10-26
 */
public class Problem1085 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);
		int w = Integer.parseInt(input[2]);
		int h = Integer.parseInt(input[3]);
		
		int min = Math.min(Math.abs(w - x), Math.abs(y - h));
		
		if(x < min || y < min) {
			min = Math.min(x, y);
		}
		
		bw.write(String.valueOf(min));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
