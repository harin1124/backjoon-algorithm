package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @title 3. 매출액의 종류
 * @desc 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
 * 각 구간별로 구하라고 했습니다.<br>
 * 만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면<br>
 * 20 12 20 10 23 17 10<br>
 * 각 연속 4일간의 구간의 매출종류는<br>
 * 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.<br>
 * 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.<br>
 * 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.<br>
 * 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.<br>
 * N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별<br>
 * 매출액의 종류를 출력하는 프로그램을 작성하세요.
 * @input 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.<br>
 * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 * 단어의 길이는 100을 넘지 않습니다.
 * @output 첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.
 * @studyStartDate 2023-02-01
 * @studyEndDate 2023-02-
 */
public class Problem_04_03 {
	public static void main(String[] args) throws Exception {
		// n 제곱이 아닌 n만큼만 돌도록 처리
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] arr = new int[scan.nextInt()];
		int range = scan.nextInt();

		int i = 0;
		for(i=0; i<arr.length; i++){
			arr[i] = scan.nextInt();
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		// 초기구간 설정
		for(i=0; i<range; i++){
			map.put(arr[i], map.get(arr[i]) == null ? 1 : map.get(arr[i])+1);
		}
		//System.out.println("map = "+map);
		//System.out.println(map.keySet().size());
		bw.write(map.keySet().size()+" ");
		//System.out.println("=====================");
		// 이후구간 설정
		for(i=0; i<arr.length; i++){
			//System.out.printf("arr[%d] ~ arr[%d]", i+1, range+i);
			//System.out.println();
			if(range+i >= arr.length){
				break;
			}
			//System.out.println("삭제하는 인덱스 = "+i+" 삭제하는 숫자 키 = "+arr[i]);
			//System.out.println("새로 넣어주는 인덱스 = "+(i+range)+" 추가하는 숫자 키 = "+arr[i+range]);

			if(map.get(arr[i]) != null && map.get(arr[i]) > 1){
				map.put(arr[i], map.get(arr[i]-1));
			} else {
				map.remove(arr[i]);
			}
			map.put(arr[i+range], 0);
			//System.out.println("map = "+map);
			bw.write(map.keySet().size()+" ");
			//System.out.println("==========================");
		}
		bw.close();
		scan.close();
	}
}