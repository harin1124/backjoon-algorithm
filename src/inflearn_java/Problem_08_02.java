package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @title 바둑이 승차(DFS)
 * @desc 철수는 그의 바둑이들을 데리고 시장에 가려고 한다.<br>
 * 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.<br>
 * 철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.<br>
 * N마리의 바둑이와 각 바둑이의 무게 W가 주어지면,<br>
 * 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.
 * @input 첫 번째 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어집니다.<br>
 * 둘째 줄부터 N마리 바둑이의 무게가 주어진다.
 * @output 첫 번째 줄에 가장 무거운 무게를 출력한다.
 * @studyStartDate 2025-07-16
 * @studyEndDate 2025-07-16
 */
public class Problem_08_02 {
	static int[] arr;
	static int max = 0;
	static int maxWeight;
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		maxWeight = scan.nextInt();
		int size = scan.nextInt();
		arr = new int[size];
		
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}
		
		Arrays.sort(arr);
		
		dfs(0, 0);
		
		bw.write(max + "");
		
		scan.close();
		bw.close();
	}
	
	static void dfs(int level, int sum) {
		if(sum > maxWeight) {
			return;
		}
		
		if(level == arr.length){
			max = Math.max(max, sum);
		} else {
			dfs(level + 1, sum + arr[level]);
			dfs(level + 1, sum);
		}
	}
}