package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @title 씨름 선수
 * @desc 현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.<br>
 * 현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.<br>
 * 현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.<br>
 * “A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은 (크고, 무겁다) 지원자가 존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”<br>
 * N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요.
 * @input 첫째 줄에 지원자의 수 N(5<=N<=100,000)이 주어집니다.<br>
 * 두 번째 줄부터 N명의 키와 몸무게 정보가 차례로 주어집니다.<br>
 * 각 선수의 키와 몸무게는 모두 다릅니다.
 * @output 첫째 줄에 씨름 선수로 뽑히는 최대 인원을 출력하세요.
 * @studyStartDate 2025-07-29
 * @studyEndDate 2025-07-29
 */
public class Problem_09_01 {
	static class Person implements Comparable<Person> {
		int height;
		int weight;
		
		Person(int height, int weight) {
			this.height = height;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Person o) {
			return o.height - this.height;
		}
	}
	
	public static int solution(ArrayList<Person> list, int n) {
		int count = 0;
		
		Collections.sort(list);
		int max = Integer.MIN_VALUE;
		
		for(Person p : list) {
			if(p.weight > max) {
				max = p.weight;
				count++;
			}
		
		}
		
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int count = 0;
		int n = Integer.parseInt(br.readLine());
		ArrayList<Person> personList = new ArrayList<>(n);
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			personList.add(new Person(height, weight));
		}
		
		bw.write(String.valueOf(solution(personList, n)));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
