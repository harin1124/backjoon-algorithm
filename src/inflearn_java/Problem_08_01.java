package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 1. 합이 같은 부분집합(DFS : 아마존 인터뷰)
 * @desc N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때<br>
 * 두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.<br>
 * 둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어 합니다.<br>
 * 예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.
 * @input 첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
 * 두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.
 * @output 첫 번째 줄에 “YES" 또는 ”NO"를 출력한다.
 * @studyStartDate 2024-03-11
 * @studyEndDate 2024-03-12
 */
public class Problem_08_01 {
    static String result = "NO";
    static boolean flag = false;
    static int[] arr;
    static int total = 0;

    static void dfs(int level, int sum){
        // 재귀로 복귀했을 때, 아래 부분을 더 이상 진행하지 못하도록
        // 전역으로 설정한 flag 값을 확인하여 처리한다
        if(flag){
            return;
        }
        // 포함, 미포함을 확인하기 전에
        // 이미 sum 값이 total을 2로 나눈 값보다 크면 더 이상 볼 필요가 없으므로 종료
        if(sum > total / 2){
            return;
        }
        
        // 레벨 더 이상 증가 불가
        if(level == arr.length){
            if(total - sum == sum) {
                result = "YES";
                flag = true;
            }
        } else {
            // 사용한다
            dfs(level+1, sum+arr[level]);
            // 사용안한다
            dfs(level+1, sum);
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int size = scan.nextInt();
        arr = new int[size];

        for(int i=0; i<size; i++){
            arr[i] = scan.nextInt();
            total += arr[i];
        }
        
        dfs(0, 0);
        
        bw.write(result);
        
        scan.close();
        bw.close();
    }
}