package inflearn_java;

import java.util.Scanner;

/**
 * @title 경로 탐색(인접행렬)(DFS)
 * @desc 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는<br>
 * 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.<br>
 * 아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는 총 6가지입니다.
 * @input 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다.<br>
 * 그 다음부터 M줄에 걸쳐 연결정보가 주어진다
 * @output 총 가지수를 출력한다.
 * @studyStartDate 2024-03-08
 * @studyEndDate 2024-03-08
 */
public class Problem_07_12 {
    static int n = 0; // 정점 수
    static int m = 0; // 간선 수
    static int answer = 0;
    static int[][] graph; // 인접 행렬
    static int[] chkList;
    
    public static void dfs(int v){
        if(v == n){
            answer++;
        } else {
            for(int i=1; i<=n; i++){
                // v 정점에서 i정점으로 갈 수 있는지 확인
                // 한번도 방문하지 않은 경로인지 확인
                if(graph[v][i] == 1 && chkList[i] == 0){
                    // 방문 확인 표시
                    chkList[i] = 1;
                    dfs(i);
                    // 재귀를 마치고 돌아왔을 때 => 백트래킹 하고
                    // 0으로 풀어준다
                    chkList[i] = 0;
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        
        // 1번 인덱스부터 처리하므로 +1처리
        graph = new int[n+1][m+1];
        chkList = new int[n+1];
        
        for(int i=0; i<m; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph[a][b] = 1;
        }
        
        // 무조건 1부터 출발하므로, 기본 체크 처리
        chkList[1] = 1;
        
        dfs(1);
        
        System.out.println(answer);
    }
}