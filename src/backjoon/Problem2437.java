package backjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @title 저울
 * @desc 하나의 양팔 저울을 이용하여 물건의 무게를 측정하려고 한다.<br>
 * 이 저울의 양 팔의 끝에는 물건이나 추를 올려놓는 접시가 달려 있고, 양팔의 길이는 같다.<br>
 * 또한, 저울의 한쪽에는 저울추들만 놓을 수 있고, 다른 쪽에는 무게를 측정하려는 물건만 올려놓을 수 있다.<br>
 * 무게가 양의 정수인 N개의 저울추가 주어질 때, 이 추들을 사용하여 측정할 수 없는 양의 정수 무게 중 최솟값을 구하는 프로그램을 작성하시오.<br>
 * 예를 들어, 무게가 각각 3, 1, 6, 2, 7, 30, 1인 7개의 저울추가 주어졌을 때,<br>
 * 이 추들로 측정할 수 없는 양의 정수 무게 중 최솟값은 21이다.
 * @input 첫 째 줄에는 저울추의 개수를 나타내는 양의 정수 N이 주어진다. N은 1 이상 1,000 이하이다.<br>
 * 둘째 줄에는 저울추의 무게를 나타내는 N개의 양의 정수가 빈칸을 사이에 두고 주어진다.<br>
 * 각 추의 무게는 1이상 1,000,000 이하이다.
 * @output 첫째 줄에 주어진 추들로 측정할 수 없는 양의 정수 무게 중 최솟값을 출력한다.
 * @studyStartDate 2025-08-06
 * @studyEndDate 2025-08-06
 */
public class Problem2437 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int target = 1; // 측정할 수 없는 최소 무게 후보
		for (int i = 0; i < n; i++) {
			if (arr[i] > target) {
				break; // 이 순간 target을 만들 수 없음
			}
			target += arr[i];
		}
		
		bw.write(String.valueOf(target));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
