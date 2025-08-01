package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @title 회의실 배정
 * @desc 한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.<br>
 * 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.<br>
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.<br>
 * @input 첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다.<br>
 * 둘째 줄부터 n+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.<br>
 * 회의 시간은 0시부터 시작된다.<br>
 * 회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.
 * @output 첫째 줄에 씨름 선수로 뽑히는 최대 인원을 출력하세요.
 * @studyStartDate 2025-08-01
 * @studyEndDate 2025-08-01
 */
public class Problem_09_02 {
	static class MeetingRoom implements Comparable<MeetingRoom> {
		private final int startTime;
		private final int endTime;
		
		public MeetingRoom(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
		@Override
		public int compareTo(MeetingRoom o) {
			if(this.endTime == o.endTime){
				return this.startTime - o.startTime;
			}
			return this.endTime - o.endTime;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<MeetingRoom> list = new ArrayList<>(n);
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new MeetingRoom(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list);
		
		int result = 0;
		int lastTime = 0;
		MeetingRoom now;
		for(int i = 0; i < n; i++) {
			now = list.get(i);
			if(i == 0){
				lastTime = now.endTime;
				result++;
			} else {
				if(now.startTime >= lastTime) {
					lastTime = now.endTime;
					result++;
				}
			}
		}
		
		bw.write(Integer.toString(result));
		
		br.close();
		bw.flush();
		bw.close();
	}
}