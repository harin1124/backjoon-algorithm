package atcoder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
public class ProblemA_Jogging_solve2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] number = br.readLine().split(" ");
		int num = 0;

		int _seconds = 0;
		int _meter = 0;
		int _rest = 0;

		int seconds = Integer.parseInt(number[6]); // X 10

		int[] total_run_meter = new int[2];
		int routine_count = 0;
		int remainder_seconds = 0;

		for(int i=0; i<=1; i++){
			routine_count = 0;
			remainder_seconds = 0;
			_seconds = Integer.parseInt(number[num++]);
			_meter = Integer.parseInt(number[num++]);
			_rest = Integer.parseInt(number[num++]);

			if(seconds < (_seconds + _rest)){
				if(seconds <= _seconds){
					total_run_meter[i] = seconds * _meter;
				} else {
					total_run_meter[i] = _meter * _seconds;
				}
			} else {
				routine_count = seconds / (_seconds + _rest);
				total_run_meter[i] = routine_count * (_meter * _seconds);
				remainder_seconds = seconds % (_seconds + _rest);
				if(remainder_seconds <= _seconds){
					total_run_meter[i] += (remainder_seconds * _meter);
				} else {
					total_run_meter[i] += (_seconds * _meter);
				}
			}
		}


		if(total_run_meter[0] == total_run_meter[1]){
			bw.write("Draw");
		} else {
			bw.write((total_run_meter[0] > total_run_meter[1] ? "Takahashi" : "Aoki"));
		}
		br.close();
		bw.close();
	}
}