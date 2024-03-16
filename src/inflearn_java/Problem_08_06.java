package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @title 순열 구하기
 * @desc 10이하의 N개의 자연수가 주어지면<br>
 * 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
 * @input 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.<br.
 * 두 번째 줄에 N개의 자연수가 오름차순으로 주어집니다.
 * @output 첫 번째 줄에 결과를 출력합니다.<br>
 * 출력순서는 사전순으로 오름차순으로 출력합니다
 * @studyStartDate 2024-03-16
 * @studyEndDate 2024-03-16
 */
public class Problem_08_06 {
    static int[] arr;
    static int[] arrChk;
    static int[] resultArr;
    static int n;
    static int m;
    
    static void dfs(int level){
        if(level == m){
            for(int i : resultArr){
                System.out.printf("%s ", i);
            }
            System.out.println();
        } else {
            for(int i=0; i<n; i++){
                // 중복은 나오지 않도록 체크
                if(arrChk[i] == 0){
                    resultArr[level] = arr[i];
                    arrChk[i] = 1;
                    dfs(level+1);
                    arrChk[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[n];
        arrChk = new int[n];
        resultArr = new int[m];
        
        for(int i=0; i<n; i++){
            arr[i] = scan.nextInt();
        }
        
        dfs(0);
        
        scan.close();
        bw.close();
    }
}