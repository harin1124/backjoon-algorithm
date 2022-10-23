package atcoder;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @title A - Jogging
 * @desc 타카하시와 아오키는 조깅을 하기로 결정했다.<br>
          다카하시는 다음을 반복한다: "초속 B미터로 A초간 걷고 C초간 휴식한다."<br>
          아오키는 다음을 반복한다: "초속 E미터로 D초 동안 걷고 F초 동안 휴식한다."<br>
          동시에 조깅을 시작한 지 X초가 지났을 때, 다카하시와 아오키 중 누가 앞서고 있는가?
 * @input A B C D E F X
 * @output 동시에 조깅을 시작한 지 X초가 지났을 때,<br>
            다카하시가 아오키보다 앞서면 다카하시를 프린트하고,<br>
            아오키가 다카하시보다 앞서면 아오키를 프린트하고,<br>
            같은 거리를 전진하면 드로우를 프린트한다.
 * @studyStartDate 2022-10-23
 * @studyEndDate 2022-10-23
 */
public class ProblemA_Jogging {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer numbers = new StringTokenizer(br.readLine());

		// ex) 타카하시가 초속 3미터로 4초간 걷고 3초간 휴식한다.
		int taka_seconds = Integer.parseInt(numbers.nextToken()); // A 4
		int taka_meter = Integer.parseInt(numbers.nextToken()); // B 3
		int taka_rest = Integer.parseInt(numbers.nextToken()); // C 3

		// ex) 아오키가 초속 2미터로 6초 동안 걷고 5초 동안 휴식한다.
		int aoki_seconds = Integer.parseInt(numbers.nextToken()); // D 6
		int aoki_meter = Integer.parseInt(numbers.nextToken()); // E 2
		int aoki_rest = Integer.parseInt(numbers.nextToken()); // F 5

		int seconds = Integer.parseInt(numbers.nextToken()); // X 10

		int taka_total_run_meter = 0;   // 타카하시가 총 달린 거리
		int taka_routine_count = 0;     // 타카하시가 달리고 쉬는 루틴이 몇 번 도는지
		int taka_remainder_seconds = 0; // 타카하시가 달리고 쉬는 루틴을 제외하고 나머지의 초

		if(seconds < (taka_seconds + taka_rest)){
			System.out.println("1");
			if(seconds <= taka_seconds){
				taka_total_run_meter = seconds * taka_meter;
			} else {
				taka_total_run_meter = taka_meter * taka_seconds;
			}
		} else {
			System.out.println("2");
			taka_routine_count = seconds / (taka_seconds + taka_rest);
			//System.out.println("taka_routine_count : "+taka_routine_count);
			taka_total_run_meter = taka_routine_count * (taka_meter * taka_seconds); // 총 달린 거리
			//System.out.println("taka_total_run_meter : "+taka_total_run_meter);
			taka_remainder_seconds = seconds % (taka_seconds + taka_rest); // 루틴을 제외한 남은 초 (달리는 초수만 있을수도, 달리고 쉬는 초수까지 있을 수 있음)
			//System.out.println("taka_remainder_seconds : "+taka_remainder_seconds);
			if(taka_remainder_seconds <= taka_seconds){
				//System.out.println("3");
				taka_total_run_meter += (taka_remainder_seconds * taka_meter);
			} else {
				//System.out.println("4");
				taka_total_run_meter += (taka_seconds * taka_meter);
			}
		}
		//System.out.println("taka_total_run_meter : "+taka_total_run_meter);

		int aoki_total_run_meter = 0;
		int aoki_routine_count = 0;
		int aoki_remainder_seconds = 0;

		if(seconds < (aoki_seconds + aoki_rest)){
			System.out.println("1");
			if(seconds <= aoki_seconds){
				aoki_total_run_meter = seconds * aoki_meter;
			} else {
				aoki_total_run_meter = aoki_meter * aoki_seconds;
			}
		} else {
			System.out.println("2");
			aoki_routine_count = seconds / (aoki_seconds + aoki_rest);
			//System.out.println("taka_routine_count : "+taka_routine_count);
			aoki_total_run_meter = aoki_routine_count * (aoki_meter * aoki_seconds); // 총 달린 거리
			//System.out.println("taka_total_run_meter : "+taka_total_run_meter);
			aoki_remainder_seconds = seconds % (aoki_seconds + aoki_rest); // 루틴을 제외한 남은 초 (달리는 초수만 있을수도, 달리고 쉬는 초수까지 있을 수 있음)
			//System.out.println("taka_remainder_seconds : "+taka_remainder_seconds);
			if(aoki_remainder_seconds <= aoki_seconds){
				//System.out.println("3");
				aoki_total_run_meter += (aoki_remainder_seconds * aoki_meter);
			} else {
				//System.out.println("4");
				aoki_total_run_meter += (aoki_seconds * aoki_meter);
			}
		}

		if(aoki_total_run_meter == taka_total_run_meter){
			bw.write("Draw");
		} else {
			bw.write((aoki_total_run_meter > taka_total_run_meter ? "Aoki" : "Takahashi"));
		}
		br.close();
		bw.close();
	}
}