package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @title 8. 이분검색 (강의보고 풀이)
 * @desc 임의의 N개의 숫자가 입력으로 주어집니다.<br>
 * N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면<br>
 * 이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요.<br>
 * 단 중복값은 존재하지 않습니다.
 * @input 첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.<br>
 * 두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.
 * @output 첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.
 * @studyStartDate 2024-02-03
 * @studyEndDate 2024-02-03
 */
public class Problem_06_08_02 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int size = scan.nextInt();
        int key = scan.nextInt();
        int[] arr = new int[size];
        
        // 값 입력받기
        for(int i=0; i<size; i++){
            arr[i] = scan.nextInt();
        }
        
        // 이분 검색은 정렬이 먼저 적용되어야, 가능한 개념
        Arrays.sort(arr);
        
        int lt = 0;
        int rt = size-1;
        int mid = 0;
        
        // 반복적으로 도는 것
        while(lt <= rt){
            // 중앙값 찾기
            mid = (lt + rt) / 2;
            
            // 중앙값이 key와 같다면, 출력하고 종료
            if(arr[mid] == key){
                bw.write((mid+1)+"");
                break;
            }
            
            // 중앙값이 key보다 크면, 범위를 재조정 한다.
            // => rt가 맨 끝에 있을 필요가 없고, rt에 중앙값을 할당
            if(arr[mid] > key){
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        
        scan.close();
        bw.close();
    }
}