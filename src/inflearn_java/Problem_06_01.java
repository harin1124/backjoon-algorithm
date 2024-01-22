package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 1. 선택 정렬
 * @desc N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.<br>
 * 정렬하는 방법은 선택정렬입니다.
 * @input 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.<br>
 * 두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다.<br>
 * 각 자연수는 정수형 범위 안에 있습니다.
 * @output 오름차순으로 정렬된 수열을 출력합니다.
 * @studyStartDate 2024-01-22
 * @studyEndDate 2024-01-22
 */
public class Problem_06_01 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int size = scan.nextInt();
        int[] array = new int[size];
        for(int i=0; i<size; i++){
            array[i] = scan.nextInt();
        }
        
        int tmp = 0;
        int minIdx = 0;
        int max = Integer.MAX_VALUE;
        for(int i=0; i<size; i++){
            max = Integer.MAX_VALUE;
            for(int j=i+1; j<size; j++){
                // max 값보다 작으면 minIdx에 값 할당 (최저값을 찾기 위함)
                if(array[j] < max){
                    max = array[j];
                    minIdx = j;
                }
            }
            // 바꾸려는 값보다 작은지 확인하여 작을 때만, 값을 교환한다
            if(max < array[i]){
                // 원본 값 보관하며, 값을 교체
                tmp = array[i];
                array[i] = array[minIdx];
                array[minIdx] = tmp;
            }
        }

        // 정답 출력
        for(int i : array){
            bw.write(i+" ");
        }
        bw.close();
        scan.close();
    }
}