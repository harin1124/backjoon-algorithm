package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @title 동전교환
 * @desc 다음과 같이 여러 단위의 동전들이 주어져 있을때<br>
 * 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?<br>
 * 각 단위의 동전은 무한정 쓸 수 있다.
 * @input 첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다.<br>
 * 두 번째 줄에는 N개의 동전의 종류가 주어지고,<br>
 * 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.<br>
 * 각 동전의 종류는 100원을 넘지 않는다.
 * @output 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
 * @studyStartDate 2024-03-16
 * @studyEndDate 2024-03-16
 */
public class Problem_08_05 {
    static Integer[] coinArr; // 코인 배열
    static int total;
    static int result = Integer.MAX_VALUE;
    
    /**
     * 
     * @param level coin의 사용 갯수
     * @param sum 사용된 코인의 총합
     */
    static void dfs(int level, int sum){
        // total을 넘은 경우는 더 가지를 뻗을 이유가 없음
        if(sum > total || level >= result){
            return;
        }
        
        if(sum == total){
            // 최솟값을 구해야 하므로, min 메소드를 이용
            result = Math.min(result, level);
        } else {
            for(int i : coinArr){
                dfs(level+1, sum+i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int coinSize = scan.nextInt();
        coinArr = new Integer[coinSize];
        
        for(int i=0; i<coinSize; i++){
            coinArr[i] = scan.nextInt();
        }
        
        // 시간초과로 인해, 코인배열의 순서를 정리해서 성능 개선
        // 큰 것부터 먼저 조회해야 답을 빨리 찾을 수 있다
        Arrays.sort(coinArr, Collections.reverseOrder());
        
        total = scan.nextInt();
        
        dfs(0, 0);
        bw.write(result+"");
        
        scan.close();
        bw.close();
    }
}