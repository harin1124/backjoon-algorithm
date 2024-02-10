package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @title 10. 마구간 정하기(결정알고리즘)
 * @desc N개의 마구간이 수직선상에 있습니다.<br>
 * 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.<br>
 * 현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다.<br>
 * 각 마구간에는 한 마리의 말만 넣을 수 있고,<br>
 * 가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.<br>
 * C마리의 말을 N개의 마구간에 배치했을 때<br>
 * 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.
 * @input 첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N)이 공백을 사이에 두고 주어집니다.<br>
 * 둘째 줄에 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 차례로 주어집니다.
 * @output 첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.
 * @studyStartDate 2024-02-11
 * @studyEndDate 2024-02-11
 */
public class Problem_06_10 {
    // 유효한지 판별하는 함수
    public static int count(int[] arr, int dist){
        // 말의 수
        int cnt = 1;
        int ep = arr[0];
        for(int i=1; i<arr.length; i++){
            // 현재의 좌표에서 가장 마지막 좌표값을 빼었을 때 나온 값이 거리이고
            // 거리가 같거나 크면, 말의 배치가 가능
            if(arr[i] - ep >= dist){
                // 말의 수를 증가
                cnt++;
                // 마지막 말의 배치 좌표를 갱신
                ep = arr[i];
            }
        }
        return cnt;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = scan.nextInt();
        int c = scan.nextInt();
        int[] arr = new int[n];
        
        // 값 입력받기
        for(int i=0; i<n; i++){
            arr[i] = scan.nextInt();
        }
        
        // 정렬
        Arrays.sort(arr);
        
        int lt = 1;
        int rt = arr[n-1];
        int result = 0;
        // 이분검색 시작 (결정 알고리즘의 핵심)
        while(lt <= rt){
            int mid = (lt + rt) / 2;
            // c 마리 수 이상이면, 우선 답이 유효함
            if(count(arr, mid) >= c){
                result = mid;
                lt = mid + 1;
                
            } else {
                // 거리가 유효하지 않은 경우 => 더 작아져야 함
                rt = mid - 1;
            }
        }
        
        bw.write(result+"");
        
        scan.close();
        bw.close();
    }
}