package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Problem_08_05_practice {
	static Integer[] coinArr;
	static int n;
	static int m;
	static int count;
	
	static void dfs(int useIndex, int sum) {
		if (sum > m) {
			return;
		}
		if (sum == m) {
			count++;
		} else {
			for(int i = useIndex; i < n; i++) {
				dfs(i, sum + coinArr[i]);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = scan.nextInt();
		coinArr = new Integer[n];
		
		for (int i = 0; i < n; i++) {
			coinArr[i] = scan.nextInt();
		}
		
		m = scan.nextInt();
		
		dfs(0, 0);
		bw.write(count + "");
		bw.flush();
		bw.close();
		scan.close();
	}
}
