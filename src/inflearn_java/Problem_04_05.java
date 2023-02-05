package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * @title 5. K번째 큰 수
 * @desc S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.<br>
 * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
 * @input 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.<br>
 * S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
 * @output S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
 * @studyStartDate 2023-02-05
 * @studyEndDate 2023-02-05
 */
public class Problem_04_05 {
	public static void main(String[] args) throws Exception {
		// 강의 보고 푼 풀이
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = scan.nextInt();
		int k = scan.nextInt();
		int[] arr = new int[n];


		int i = 0;
		for(i=0; i<n; i++){
			arr[i] = scan.nextInt();
		}
		// 자동 정렬되도록
		TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
		for(i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
				for(int l=j+1; l<n; l++){
					//System.out.printf("arr[%d] + arr[%d] + arr[%d]\n", i, j, l);
					set.add(arr[i]+arr[j]+arr[l]);
				}
			}
		}

		i=0;
		int result = -1;
		for(int x : set){
			i++;
			if(i == k){
				result = x;
				break;
			}
		}
		bw.write(result+"");
		bw.close();
		scan.close();
	}
}