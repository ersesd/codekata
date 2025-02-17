package com.sparta.code.level3;

import java.util.*;

public class Solution64 {
    
    // 노드 정보를 저장할 static inner class
    static class Node {
        int id;
        int x, y;
        Node left;
        Node right;
        
        public Node(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
    }
    
    List<Integer> preList;
    List<Integer> postList;
    
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        Node[] nodes = new Node[n];
        
        // 1번 노드부터 번호를 부여하면서 노드 배열 생성
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        // y 좌표가 큰 순서(높은 레벨 먼저)로, y 좌표가 같다면 x 좌표가 작은 순으로 정렬
        Arrays.sort(nodes, new Comparator<Node>() {
            public int compare(Node a, Node b) {
                if (b.y == a.y) {
                    return a.x - b.x;
                } else {
                    return b.y - a.y;
                }
            }
        });
        
        // 정렬된 첫 번째 노드를 루트로 설정
        Node root = nodes[0];
        
        // 나머지 노드들을 x 좌표 기준으로 트리에 삽입 (왼쪽: 작음, 오른쪽: 큼)
        for (int i = 1; i < n; i++) {
            insert(root, nodes[i]);
        }
        
        // 전위 순회와 후위 순회 결과를 담을 리스트 초기화
        preList = new ArrayList<>();
        postList = new ArrayList<>();
        
        preOrder(root);
        postOrder(root);
        
        // 결과를 2차원 배열에 담아 반환 (첫 행: 전위 순회, 둘째 행: 후위 순회)
        int[][] answer = new int[2][n];
        for (int i = 0; i < n; i++) {
            answer[0][i] = preList.get(i);
            answer[1][i] = postList.get(i);
        }
        return answer;
    }
    
    // 재귀적으로 트리에 새로운 노드를 삽입하는 메서드
    private void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insert(parent.left, child);
            }
        } else { // child.x > parent.x (모든 노드의 x 좌표는 서로 다르므로)
            if (parent.right == null) {
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
    }
    
    // 전위 순회: 현재 노드 -> 왼쪽 서브트리 -> 오른쪽 서브트리
    private void preOrder(Node node) {
        if (node == null) return;
        preList.add(node.id);
        preOrder(node.left);
        preOrder(node.right);
    }
    
    // 후위 순회: 왼쪽 서브트리 -> 오른쪽 서브트리 -> 현재 노드
    private void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        postList.add(node.id);
    }
    
}
