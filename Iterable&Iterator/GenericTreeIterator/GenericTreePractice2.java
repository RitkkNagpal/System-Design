import java.util.*;
import java.io.*;
public class GenericTreePractice2 {
    public static void main(String[] args) {
        MyGenericTree gt=new MyGenericTree();
        gt.construct(new int[] {10, 20, 50, -1, 60, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, 40, 100, -1, -1, -1});    
        for(int val : gt){
            System.out.println(val);
        }
    }

    public static class MyGenericTree implements Iterable<Integer>{
        static class Node{
            int data;
            ArrayList<Node>children;

            Node(){
                this.data = 0;
                this.children = new ArrayList<>();
            }
        }
        Node root;

        void construct(int []arr){
            Stack<Node>st = new Stack<>();
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == -1){
                    st.pop();
                }
                else{
                    Node nn = new Node();
                    nn.data = arr[i];
                    if(st.size() == 0){
                        root = nn;
                    }
                    else{
                        st.peek().children.add(nn);
                    }
                    st.push(nn);
                }
            }
        }

        public Iterator<Integer> iterator(){
            return new MyGTIterator(root);
        }

        static class MyGTIterator implements Iterator<Integer>{
            Stack<Pair> st = new Stack<>();
            Integer curr = null;
            MyGTIterator(Node root){
                st.push(new Pair(root));
                next();
            }
            public Integer next(){
                Integer rval = curr; // return value
                curr = null;
                while(st.size() > 0){
                    Pair top = st.peek();
                    if(top.state == -1){
                        // pre order
                        curr = top.node.data;
                        top.state++;
                        break;
                    }
                    else if(top.state < top.node.children.size()){
                        st.push(new Pair(top.node.children.get(top.state)));
                        top.state++;
                    }
                    else{
                        st.pop();
                    }
                }
                return rval;
            }

            public boolean hasNext(){
                return !st.empty();
            }
        }

        static class Pair{
            Node node;
            int state;

            Pair(){}
            Pair(Node node){
                this.node = node;
                this.state = -1;
            }
        }
    }
}
