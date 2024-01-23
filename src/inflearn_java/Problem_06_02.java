package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 2. 버블 정렬
 * @desc N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.<br>
 * 정렬하는 방법은 버블정렬입니다.
 * @input 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.<br>
 * 두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다.<br>
 * 각 자연수는 정수형 범위 안에 있습니다.
 * @output 오름차순으로 정렬된 수열을 출력합니다.
 * @studyStartDate 2024-01-23
 * @studyEndDate 2024-01-23
 */
public class Problem_06_02 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int size = scan.nextInt();
        int[] array = new int[size];
        for(int i=0; i<size; i++){
            array[i] = scan.nextInt();
        }
        
        int tmp = 0;
        // 마지막 것은 정렬이 되어 있으므로, size-1로 한다
        for(int i=0; i<size-1; i++){
            // 마지막 전체 - i 만큼은 이미 정렬의 되어 있으므로, 빼고 정렬
            for(int j=0; j<size-i-1; j++){
                if(array[j] > array[j+1]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
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