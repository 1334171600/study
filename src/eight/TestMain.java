package eight;

public class TestMain {
    public static void main(String args[]) {
//        Node root = new Node("火车头");
//        Node n1 = new Node("车厢A");
//        Node n2 = new Node("车厢B");
//
//        Node n3 = new Node("车厢C");
//
//        Node n4 = new Node("车厢D");
//        root.setNext(n1);
//        n1.setNext(n2);
//        n2.setNext(n3);
//        n3.setNext(n4);
//        printNode(root);
        Link link = new Link();
        link.addNode("a");
        link.addNode("b");
        link.addNode("c");
        link.addNode("d");
        link.addNode("e");
        link.addNode("f");
        link.addNode("g");
        System.out.println("******************删除之前****************");
        link.printNode();
        link.deleteNode("c");
        link.deleteNode("d");
        System.out.println();
        System.out.println("******************删除之后****************");
        link.printNode();
        System.out.println();
        System.out.println("查询节点:"+link.contains("a"));

    }
//    public static void printNode(Node node){
//        System.out.print(node.getData()+"\t");
//        if (node.getNext()!=null){
//            printNode(node.getNext());
//        }
//    }
}

class Link {
    class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
        }

        public void add(Node newNode) {
            if (this.next == null) {
                this.next = newNode;
            } else {
                this.next.add(newNode);
            }
        }

        public void print() {
            System.out.print(this.data + "\t");
            if (this.next != null) {
                this.next.print();
            }
        }

        public boolean search(String data) {
            if (data.equals(this.data)) {
                return true;
            } else {
                if (this.next != null) {
                    return this.next.search(data);
                } else {
                    return false;
                }
            }
        }

        public void delete(Node previous, String data) {
            if (data.equals(this.data)) {
                previous.next = this.next;
            } else {
                if (this.next != null) {
                    this.next.delete(this, data);
                }
            }
        }

    }

    private Node root;

    public void addNode(String data) {
        Node newNode = new Node(data);
        if (this.root == null) {
            this.root = newNode;
        } else {
            this.root.add(newNode);
        }
    }

    public void printNode() {
        if (this.root != null) {
            this.root.print();
        }
    }

    public boolean contains(String name) {
        return this.root.search(name);
    }

    public void deleteNode(String data) {
        if (this.contains(data)) {
            if (this.root.data.equals(data)) {
                this.root = this.root.next;
            } else {
                this.root.next.delete(root, data);
            }
        }
    }
}

class Node {
    private String data;
    private Node next;

    public Node(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}