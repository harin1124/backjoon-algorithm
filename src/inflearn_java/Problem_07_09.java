package inflearn_java;

/**
 * @title Tree 말단 노드까지의 가장 짧은 경로 (DFS 이용)
 * @desc 아래 그림과 같은 이진트리에서 루트 노드 1에서 말단노드까지의 길이 중<br>
 * 가장 짧은 길이를 구하는 프로그램을 작성하세요.<br>
 * 각 경로의 길이는 루트노드에서 말단노드까지 가는데 이동하는 횟수를<br>
 * 즉 간선(에지)의 개수를 길이로 하겠습니다.
 *       [1]
 *   [2]    [3]
 * [4] [5]
 * @input
 * @output
 * @studyStartDate 2024-03-05
 * @studyEndDate 2024-03-05
 */
class Tree {
    int data;
    Tree lt;
    Tree rt;
    
    public Tree(int data){
        this.data = data;
        this.lt = null;
        this.rt = null;
    }
}
public class Problem_07_09 {
    static Tree root;
    
    static int dfs(int level, Tree root){
        // 말단 노드는 자식노드(왼쪽 노드, 오른쪽 노드)가 모두 없다
        if(root.lt == null && root.rt == null){
            return level;
        } else {
            // 재귀를 사용했으며, 이진트리이므로, 한쪽 노드만 있는 경우는 없다.
            // 왼쪽 노드와 오른쪽 노드의 뎁스 중 더 작은 레벨을 반환한다.
            // => 가장 짧은 경로이므로
            return Math.min(dfs(level+1, root.lt), dfs(level+1, root.rt));
        }
    }
    
    public static void main(String[] args) throws Exception {
        root = new Tree(1);
        root.lt = new Tree(2);
        root.rt = new Tree(3);
        root.lt.lt = new Tree(4);
        root.lt.rt = new Tree(5);
        
        System.out.println(dfs(0, root));
    }
}