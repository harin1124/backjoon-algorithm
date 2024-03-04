package inflearn_java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @title 이진트리 순회(넓이우선탐색:레벨탐색(BFS:Breadth-First Search))
 * @desc 아래 그림과 같은 이진 트리를 레벨탐색 연습하세요.
 * @input
 * @output
 * @studyStartDate 2024-03-04
 * @studyEndDate 2024-03-04
 */
class Node2 {
    int data;
    Node2 lt;
    Node2 rt;
    
    public Node2(int val){
        data = val;
        lt = null;
        rt = null;
    }
}

public class Problem_07_07 {
    static Node2 root;
    static public void BFS(Node2 root){
        Queue<Node2> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        
        // 비어있는 경우에 while문이 멈춘다
        while(!q.isEmpty()){
            int len = q.size(); // 위에서 한 번만 offer 하였으므로 1일 것
            System.out.print(level + " : ");
            for(int i=0; i<len; i++){
                Node2 current = q.poll();
                System.out.print(current.data + " ");
                if(current.lt != null){
                    q.offer(current.lt);
                }
                if(current.rt != null){
                    q.offer(current.rt);
                }
            }
            level++;
            System.out.println();
        }
    }
    
    public static void main(String[] args) throws Exception {
        root = new Node2(1);
        root.lt = new Node2(2);
        root.rt = new Node2(3);
        root.lt.lt = new Node2(4);
        root.lt.rt = new Node2(5);
        root.rt.lt = new Node2(6);
        root.rt.rt = new Node2(7);
        BFS(root);
    }
}