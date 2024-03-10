package inflearn_java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @title 그래프 최단거리(BFS)
 * @desc 다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선 수를 출력하세요.
 * @input 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다.<br>
 * 그 다음부터 M줄에 걸쳐 연결정보가 주어진다.
 * @output 1번 정점에서 각 정점으로 가는 최소 간선 수를 2번 정점부터 차례대로 출력하세요.
 * @studyStartDate 2024-03-10
 * @studyEndDate 2024-03-10
 */
public class Problem_07_14 {
    static int n = 0; // 정점 수
    static int m = 0; // 간선 수
    static ArrayList<ArrayList<Integer>> graph; // 인접 행렬
    static int[] chkList;
    static int[] dis;
    
    public static void bfs(int v){
        // bfs 를 돌리려면 Queue 를 만들어야 한다.
        Queue<Integer> q = new LinkedList<>();
        
        // 1에서 출발하므로 기본값 지정
        chkList[v] = 1;
        dis[v] = 0;
        
        // 값 추가
        q.offer(v);
        
        // 비어있으면 멈추도록
        while(!q.isEmpty()){
            int currentVertex = q.poll(); // 현재 지점에서 꺼내기
            // 이미 graph.get(current) 에서 나온 값은
            // v 정점에서 갈 수 있는 정점들만 담겨 있다
            for(int nextVertex : graph.get(currentVertex)){
                // 이 중에서 아직 방문하지 않은 정점을 찾는다
                if(chkList[nextVertex] == 0){
                    // 방문 확인 체크
                    chkList[nextVertex] = 1;
                    // 큐에 추가
                    q.offer(nextVertex);
                    // 제일 중요한 부분
                    // 현재 정점(currentVertext)에서 다음 정점(nextVertex)으로 가는 간선 수를 수정한다.
                    // 다음 정점으로 가는 간선 수는 현재 정점에서 + 1을 한다.
                    // => 현재 정점 기준으로 꺼낸 리스트를 통해 나온 다음 정점은 바로 한 번에 갈 수 있으므로 +1이다.
                    dis[nextVertex] = dis[currentVertex] + 1;
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
        dis = new int[n+1];
        
        // n만큼 리스트에 add 처리
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<m; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph.get(a).add(b);
        }
        
        bfs(1);
        
        for(int i=2; i<=n; i++){
            System.out.printf("%s : %s\r\n", i, dis[i]);
        }
        
        scan.close();
    }
}