package inflearn_java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @title Tree 말단 노드까지의 가장 짧은 경로 (BFS 이용)
 * @desc 아래 그림과 같은 이진트리에서 루트 노드 1에서 말단노드까지의 길이 중<br>
 * 가장 짧은 길이를 구하는 프로그램을 작성하세요.<br>
 * 각 경로의 길이는 루트노드에서 말단노드까지 가는데 이동하는 횟수를<br>
 * 즉 간선(에지)의 개수를 길이로 하겠습니다.
 *       [1]
 *   [2]    [3]
 * [4] [5]
 * @input
 * @output
 * @studyStartDate 2024-03-06
 * @studyEndDate 2024-03-06
 */
class Tree2 {
    int data;
    Tree2 lt;
    Tree2 rt;
    
    public Tree2(int data){
        this.data = data;
        this.lt = null;
        this.rt = null;
    }
}
public class Problem_07_10 {
    static Tree2 root;
    
    static int bfs(Tree2 root){
        Queue<Tree2> q = new LinkedList<>();
        q.offer(root);
        
        int level = 0;
        
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                Tree2 current = q.poll();
                // bfs는 레벨별 순회를 하고
                // 가장 먼저 자식노드(lt, rt)가 없는 노드가 말단노드이자 최단거리 노드이다
                // 즉 발견했으므로, 종료한다
                if(current.lt == null && current.rt == null){
                    return level;
                }
                if(current.lt != null){
                    q.offer(current.lt);
                }
                if(current.rt != null){
                    q.offer(current.rt);
                }
            }
            level++;
        }
        return -1;
    }
    
    public static void main(String[] args) throws Exception {
        root = new Tree2(1);
        root.lt = new Tree2(2);
        root.rt = new Tree2(3);
        root.rt.lt = new Tree2(9);
        root.rt.rt = new Tree2(10);
        root.lt.lt = new Tree2(4);
        root.lt.rt = new Tree2(5);
        root.lt.lt.lt = new Tree2(12);
        root.lt.lt.rt = new Tree2(18);
        
        System.out.println("최단거리 : "+ bfs(root));
    }
}