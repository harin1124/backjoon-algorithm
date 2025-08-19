package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * @title 스택
 * @desc 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.<br>
 * 명령은 총 다섯 가지이다.<br>
 * push X: 정수 X를 스택에 넣는 연산이다.<br>
 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.<br>
 * size: 스택에 들어있는 정수의 개수를 출력한다.<br>
 * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.<br>
 * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * @input 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.<br>
 * 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.<br>
 * 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.<br>
 * 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
 * @output 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
 * @studyStartDate 2025-08-19
 * @studyEndDate 2025-08-19
 */
public class Problem10828 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static class CustomStack {
		ArrayList<Integer> stack;

		public CustomStack(int count) {
			this.stack = new ArrayList<>(count);
		}

		public void command(String str) throws Exception {
			String[] arr = str.split(" ");

			switch (arr[0]) {
				case "push" :
					stack.add(Integer.parseInt(arr[1]));
					break;
				case "pop" :
					if(this.isEmpty()){
						this.print("-1");
					} else {
						int lastIndex = getSize() - 1;
						this.print(String.valueOf(stack.get(lastIndex)));
						this.stack.remove(lastIndex);
					}
					break;
				case "size" :
					this.print(String.valueOf(stack.size()));
					break;
				case "empty" :
					this.print(this.isEmpty() ? "1" : "0");
					break;
				case "top" :
					if(this.isEmpty()) {
						this.print("-1");
					} else {
						this.print(String.valueOf(stack.get(this.getSize() - 1)));
					}
					break;
			}
		}

		private boolean isEmpty() {
			return stack.isEmpty();
		}

		private int getSize() {
			return stack.size();
		}

		private void print(String s) throws Exception {
			bw.write(s);
			bw.write('\n');
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int line = Integer.parseInt(br.readLine());
		CustomStack stack = new CustomStack(line);

		for(int i = 0; i < line; i++) {
			stack.command(br.readLine());
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
