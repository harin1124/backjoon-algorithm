package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 1. 선택 정렬 (강의 풀이)
 * @desc N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.<br>
 * 정렬하는 방법은 선택정렬입니다.
 * @input 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.<br>
 * 두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다.<br>
 * 각 자연수는 정수형 범위 안에 있습니다.
 * @output 오름차순으로 정렬된 수열을 출력합니다.
 * @studyStartDate 2024-01-22
 * @studyEndDate 2024-01-22
 */
public class Problem_06_01_02 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int size = scan.nextInt();
        int[] array = new int[size];
        for(int i=0; i<size; i++){
            array[i] = scan.nextInt();
        }
        
        int minIdx = 0;
        int tmp = 0;
        for(int i=0; i<size-1; i++){
            minIdx = i;
            for(int j=i+1; j<size; j++){
                // 현재 바라보는 값보다 작은 경우 모두 minIdx 로 계속 대입
                if(array[j] < array[minIdx]){
                    minIdx = j;
                }
            }
            // 만약 큰 값이 없었을 경우에, minIdx 가 본인이므로
            // 값을 대체를 해도 큰 문제가 발생하지 않음
            // 기존 작성 답안은, 큰 값을 찾았는지 못찾았는지에 대한 조건이 있어 비효율적
            tmp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = tmp;
        }

        // 정답 출력
        for(int i : array){
            bw.write(i+" ");
        }
        bw.close();
        scan.close();
    }
}