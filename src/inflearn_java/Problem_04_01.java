package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

/**
 * @title 1. 학급 회장(해쉬)
 * @desc 학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.<br>
 * 투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.<br>
 * 선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.<br>
 * 반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.
 * @input 첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.<br>
 * 두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.
 * @output 학급 회장으로 선택된 기호를 출력합니다.
 * @studyStartDate 2023-01-30
 * @studyEndDate 2023-01-30
 */
public class Problem_04_01 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(65, 0); // A
		map.put(66, 0); // B
		map.put(67, 0); // C
		map.put(68, 0); // D
		map.put(69, 0); // E

		int size = Integer.parseInt(br.readLine());
		String vote = br.readLine();

		// 카운팅
		int c = 0;
		for(int i=0; i<size; i++){
			c = vote.charAt(i);
			map.put(c, map.get(c)+1);
		}

		// 회장 선출
		int max = 0;
		int idx = 0;
		for (Integer i : map.keySet()) {
			if(max < map.get(i)){
				max = map.get(i);
				idx = i;
			}
		}

		bw.write(((char)idx)+"");
		bw.close();
		br.close();
	}
}