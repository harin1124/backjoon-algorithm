package inflearn_java;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @title 경로 탐색(인접리스트, ArrayList)
 * @desc 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는<br>
 * 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.<br>
 * 아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는 총 6가지입니다.
 * @input 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다.<br>
 * 그 다음부터 M줄에 걸쳐 연결정보가 주어진다
 * @output 총 가지수를 출력한다.
 * @studyStartDate 2024-03-08
 * @studyEndDate 2024-03-09
 */
public class Problem_07_13 {
    static int n = 0; // 정점 수
    static int m = 0; // 간선 수
    static int answer = 0;
    static ArrayList<ArrayList<Integer>> graph; // 인접 행렬
    static int[] chkList;
    
    public static void dfs(int v){
        if(v == n){
            answer++;
        } else {
            for(int nextValue : graph.get(v)){
                // 미방문 인지 확인
                if(chkList[nextValue] == 0){
                    chkList[nextValue] = 1;
                    dfs(nextValue);
                    chkList[nextValue] = 0;
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        
        // 1번 인덱스부터 처리하므로 +1처리
        graph = new ArrayList<>();
        chkList = new int[n+1];
        
        // n만큼 리스트에 add 처리
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<m; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph.get(a).add(b);
        }
        
        // 무조건 1부터 출발하므로, 기본 체크 처리
        chkList[1] = 1;
        
        dfs(1);
        
        System.out.println(answer);
        scan.close();
    }
}