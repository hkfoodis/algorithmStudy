package Tree;

public class TreePractice {

    public static class Node{
        Node left;
        Node right;
        int value;
        Node(int data){
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class NodeMgmt {
        Node head = null;

        public boolean insertNode(int data){
            if(this.head == null){                  // head에 데이터가 있는지 빈 트리가 아닌지
                this.head = new Node(data);
                return true;
            } else {                                        // head부터 탐색하기
                Node findNode = this.head;

                while(true){
                    if(data < findNode.value){                  // 값이 작을 수록 왼쪽으로 이동
                        if(findNode.left != null){
                            findNode = findNode.left;
                        } else {                                // 트리의 왼쪽이 더이상 없는 경우 트리 추가
                            findNode.left = new Node(data);
                            break;
                        }
                    } else {
                        if(findNode.right != null){             // 값이 클수록 왼쪽으로 이동
                            findNode = findNode.right;
                        } else {                                // 트리의 오른쪽이 더이상 없는 경우 트리 추가
                            findNode.right = new Node(data);
                            break;
                        }
                    }
                }
            }
            return true;
        }

        public Node search(int data){
            if(head == null){
                return null;
            } else {
                Node findNode = this.head;
                while(findNode != null){
                    if(data == findNode.value){
                        return findNode;
                    } else if (data < findNode.value){
                        findNode = findNode.left;
                    } else {
                        findNode = findNode.right;
                    }
                }
                return null;
            }
        }

        public boolean delete(int data) {
            boolean searched = false;

            Node currParentNode = this.head;
            Node currNode = this.head;

            if(this.head == null){
                return false;
            } else {
                if(this.head.value == data && this.head.left == null && this.head.right == null){
                    this.head = null;
                    return true;
                }

                while(currNode != null){                        // 삭제할 데이터가 있는지 없는지 판별하는 구간
                    if(currNode.value == data){
                        searched = true;
                        break;
                    } else if(data < currNode.value) {
                        currParentNode = currNode;
                        currNode = currNode.left;
                    } else {
                        currParentNode = currNode;
                        currNode = currNode.right;
                    }
                }

                if(searched == false){
                    return false;
                }
            }

            if(currNode.left == null && currNode.right == null){                // 해당 노드가 자식 노드가 없을 때
                if(data < currParentNode.value){                                // 해당 노드의 상위 노드 값에 따라 어느쪽을 삭제할지 결정
                    currParentNode.left = null;
                    currNode = null;
                } else {
                    currParentNode.right = null;
                    currNode = null;
                }
                return true;
            } else if (currNode.left != null && currNode.right == null){        // 해당 노드의 왼쪽에 자식 노드가 존재할 때
                if(data < currParentNode.value){                                // 부모노드의 값보다 작을 땐 부모노드의 왼쪽에 붙인다
                    currParentNode.left = currNode.left;
                    currNode = null;
                } else {                                                        // 부모노드의 값보다 클 땐 부모노드의 오른쪽에 붙인다
                    currParentNode.right = currNode.left;
                    currNode = null;
                }
                return true;
            } else if (currNode.left == null && currNode.right != null){       // 해당 노드의 오른쪽에 자식 노드가 존재할 때
                if(data < currParentNode.value){                               // 부모노드의 값보다 작을 땐 부모노드의 왼쪽에 붙인다
                    currParentNode.left = currNode.right;
                    currNode = null;
                } else {                                                       // 부모노드의 값보다 클 땐 부모노드의 오른쪽에 붙인다
                    currParentNode.right = currNode.right;
                    currNode = null;
                }
                return true;
            } else {                                                           // 해당 노드의 양옆에 데이터가 두 개 다 있는 경우
                if(data < currParentNode.value){                               // 부모노드의 값보다 작은 경우
                    Node changeNode = currNode.right;                          // 자식노드의 오른쪽 값 중 가장 작은 값을 샥제노드로 대체한다
                    Node changeParrentNode = currNode.right;
                    while(currNode.left != null){                              // 삭제할 노드의 오른쪽 자식 중 가장 작은 값 찾기
                        changeParrentNode = currNode;
                        changeNode = currNode.left;
                    }

                    if(changeNode.right != null){                              // 삭제할 노드의 오른쪽 자식 중 가장 작은 값의 오른쪽 자식 노드가 있는 경우
                        changeParrentNode.left = changeNode.right;
                    } else {
                        changeParrentNode.left = null;
                    }

                    currParentNode.left = changeNode;                          // 삭제할 노드의 위치를 바꿔준다

                    changeNode.left = currNode.left;                           // 바뀐 노드의 왼쪽과 오른쪽을 기존과 같이 대체해준다
                    changeNode.right = currNode.right;

                    currNode = null;
                } else {                                                       // 해당 데이터가 부모노드의 값보다 큰 경우

                    Node changeNode = currNode.right;                          // 자식노드의 오른쪽 값 중 가장 작은 값을 삭제노드로 대체 (위와 동일)
                    Node changeParentNode = currNode.right;
                    while(changeNode.left != null){
                        changeParentNode = changeNode;
                        changeNode = changeNode.left;
                    }

                    if(changeNode.right != null){
                        changeParentNode.left = changeNode.right;
                    } else {
                        changeParentNode.left = null;
                    }

                    currParentNode.right = changeNode;

                    if(currNode.right != changeNode) {                  // 이 경우가 어떻게해서 발생하는지에대한 이해가 필요하다
                        changeNode.right = currNode.left;
                    }
                    changeNode.left = currNode.left;

                    currNode = null;
                }
                return true;
            }
        }

        public static void main(String[] args) {
            // Case3-1: 삭제할 Node가 Child Node를 두 개 가지고 있을 경우
            NodeMgmt myTree = new NodeMgmt();
            myTree.insertNode(10);
            myTree.insertNode(15);
            myTree.insertNode(13);
            myTree.insertNode(11);
            myTree.insertNode(14);
            myTree.insertNode(18);
            myTree.insertNode(16);
            myTree.insertNode(19);
            myTree.insertNode(17);
            myTree.insertNode(7);
            myTree.insertNode(8);
            myTree.insertNode(6);
            System.out.println(myTree.delete(15));
            System.out.println("HEAD: " + myTree.head.value);
            System.out.println("HEAD LEFT: " + myTree.head.left.value);
            System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.value);
            System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.value);

            System.out.println("HEAD RIGHT: " + myTree.head.right.value);
            System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.value);
            System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.value);

            System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.value);
            System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.value);
        }
    }
}
