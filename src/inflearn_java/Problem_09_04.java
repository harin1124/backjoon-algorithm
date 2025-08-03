package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @title 최대 수입 스케쥴(PriorityQueue 응용문제)
 * @desc 현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다.<br>
 * 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.<br
 * 각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.<br>
 * 단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
 * @input 첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고,<br>
 * 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.
 * @output 첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.
 * @studyStartDate 2025-08-03
 * @studyEndDate 2025-08-03
 */
public class Problem_09_04 {
	static class Lecture implements Comparable<Lecture> {
		int money;
		int date;
		
		Lecture(int money, int date) {
			this.money = money;
			this.date = date;
		}
		
		@Override
		public int compareTo(Lecture o) {
			return o.date - this.date;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		
		int answer = 0;
		
		ArrayList<Lecture> list = new ArrayList<>(n);
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int money = Integer.parseInt(st.nextToken());
			int date = Integer.parseInt(st.nextToken());
			list.add(new Lecture(money, date));
			if(date > max) {
				max = date;
			}
		}
		
		Collections.sort(list);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int j = 0;
		for(int i = max; i >= 1; i--) {
			for(; j < n; j++) {
				if(list.get(j).date < i) {
					break;
				} else {
					pq.offer(list.get(j).money);
				}
			}
			if(!pq.isEmpty()) {
				answer += pq.poll();
			}
		}
		
		bw.write(String.valueOf(answer));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
