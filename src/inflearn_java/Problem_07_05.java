package inflearn_java;

/**
 * @title 이진트리 순회(깊이우선탐색)
 * @desc 그림과 같은 이진트리를 전위순회와 후위순회를 연습해보세요.
 *        [1]
 *   [2]      [3]
 * [4] [5]  [6] [7]
 * @input
 * @output
 * @studyStartDate 2024-02-25
 * @studyEndDate 2024-02-25
 */
class Node {
    int data;
    Node lt;
    Node rt;
    
    public Node(int value){
        data = value;
        lt = null;
        rt = null;
    }
}

public class Problem_07_05 {
    Node root;
    public void dfs(Node root){
        if(root != null){
            // 여기서 출력하면 전위순회
            System.out.printf("%s ", root.data);
            dfs(root.lt);
            // 여기서 출력하면 중위순회
            dfs(root.rt);
            // 여기서 출력하면 후위순회
        }
    }
    
    public static void main(String[] args) throws Exception {
        // 샘플 트리 생성
        Problem_07_05 tree = new Problem_07_05();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.dfs(tree.root);
    }
}