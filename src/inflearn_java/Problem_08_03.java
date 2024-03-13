package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 3. 최대점수 구하기(DFS)
 * @desc 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.<br>
 * 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.<br>
 * 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.<br>
 * (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
 * @input 첫 번째 줄에 문제의 개수N(1<=N<=20)과 제한 시간 M(10<=M<=300)이 주어집니다.<br>
 * 두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.
 * @output 첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.
 * @studyStartDate 2024-03-13
 * @studyEndDate 2024-03-13
 */
public class Problem_08_03 {
    static int[] scoreList; // 문제의 점수 리스트
    static int[] timeList;  // 문제의 푸는 시간 리스트
    static int maxTime;     // 제한 시간
    static int result;      // 최종 출력할 최대 점수

    static void dfs(int level, int score, int time){
        // 시간 내로 해야되므로, time이 최대 시간(maxTime)보다 길어지면 더 볼 필요가 없다
        if(maxTime < time){
            return;
        }

        if(level == scoreList.length){
            result = Math.max(result, score);
        } else {
            dfs(level+1, score, time);
            dfs(level+1, score+scoreList[level], time+timeList[level]);
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int size = scan.nextInt();
        maxTime = scan.nextInt();
        scoreList = new int[size];
        timeList = new int[size];

        for(int i=0; i<size; i++){
            scoreList[i] = scan.nextInt();
            timeList[i] = scan.nextInt();
        }
        
        dfs(0, 0, 0);

        bw.write(result+"");
        
        scan.close();
        bw.close();
    }
}