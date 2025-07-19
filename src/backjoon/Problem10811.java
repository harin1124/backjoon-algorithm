package backjoon;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 바구니 뒤집기
 * @desc 도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 순서대로 적혀져 있다.<br>
 * 바구니는 일렬로 놓여져 있고, 가장 왼쪽 바구니를 1번째 바구니, 그 다음 바구니를 2번째 바구니, ..., 가장 오른쪽 바구니를 N번째 바구니라고 부른다.<br>
 * 도현이는 앞으로 M번 바구니의 순서를 역순으로 만들려고 한다.<br>
 * 도현이는 한 번 순서를 역순으로 바꿀 때, 순서를 역순으로 만들 범위를 정하고, 그 범위에 들어있는 바구니의 순서를 역순으로 만든다.<br>
 * 바구니의 순서를 어떻게 바꿀지 주어졌을 때, M번 바구니의 순서를 역순으로 만든 다음, 바구니에 적혀있는 번호를 가장 왼쪽 바구니부터 출력하는 프로그램을 작성하시오.
 * @input 첫째 줄에 N (1 ≤ N ≤ 100)과 M (1 ≤ M ≤ 100)이 주어진다.<br>
 * 둘째 줄부터 M개의 줄에는 바구니의 순서를 역순으로 만드는 방법이 주어진다.<br>
 * 방법은 i j로 나타내고, 왼쪽으로부터 i번째 바구니부터 j번째 바구니의 순서를 역순으로 만든다는 뜻이다. (1 ≤ i ≤ j ≤ N)<br>
 * 도현이는 입력으로 주어진 순서대로 바구니의 순서를 바꾼다.
 * @output 모든 순서를 바꾼 다음에, 가장 왼쪽에 있는 바구니부터 바구니에 적혀있는 순서를 공백으로 구분해 출력한다.
 * @studyStartDate 2025-07-19
 * @studyEndDate 2025-07-19
 */
public class Problem10811 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int arrSize = scan.nextInt();
		int changeCount = scan.nextInt();
		Integer[] arr = new Integer[arrSize];
		
		for(int i = 0; i < arrSize; i++) {
			arr[i] = i + 1;
		}
		
		for (int i = 0; i < changeCount; i++) {
			int startIdx = scan.nextInt() - 1;
			int endIdx = scan.nextInt() - 1;
			if (startIdx != endIdx) {
				for(int s = startIdx, e = endIdx; s <= endIdx; s++, e--) {
					if(s >= e) {
						break;
					}
					int a = arr[s];
					int b = arr[e];
					arr[s] = b;
					arr[e] = a;
				}
			}
		}
		
		for (int i : arr) {
			bw.write(i + " ");
		}
		
		
		scan.close();
		bw.flush();
		bw.close();
	}
}
