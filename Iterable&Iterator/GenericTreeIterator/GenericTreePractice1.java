import java.io.IOException;
import java.lang.Iterable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class GenericTreePractice1 {
    public static void main(String[] args)throws NumberFormatException, IOException {
        MyGenericTree gt=new MyGenericTree();
        gt.construct(new int[] {10, 20, 50, -1, 60, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, 40, 100, -1, -1, -1});    
        for(int val : gt){
            System.out.println(val);
        }
    }

    public static class MyGenericTree implements Iterable<Integer>{
        Node root;

        static class Node{
            int data;
            ArrayList<Node> children;

            Node(){
                data = 0;
                children = new ArrayList<>();
            }
        }

        public void construct(int []arr){
            root=null;
            Stack<Node>st=new Stack<>();
            
            for(int i=0;i<arr.length;i++){
                if(arr[i]== -1){
                    st.pop();
                }
                else{
                    Node t=new Node();
                    t.data=arr[i];
                    if(st.size()>0){
                        st.peek().children.add(t);
                    }
                    else{
                        root=t;
                    }
                    st.push(t);
                }
            }
        }
        
        public Iterator<Integer> iterator(){
            return new MyGenericTreeIterator(this.root);
        }
    
        static class MyGenericTreeIterator implements Iterator<Integer>{
            static class Pair{
                Node node;
                int state;

                Pair(){}

                Pair(Node node,int state){
                    this.node = node;
                    this.state = state;
                }
            }
            Stack<Pair>st = new Stack<>();
            Integer curr = null;

            MyGenericTreeIterator(Node root){
                st.push(new Pair(root,-1));
                next();
            }
            public boolean hasNext(){
                if(st.size() == 0){
                    return false;
                }
                else{
                    return true;
                }
            }

            public Integer next(){
                Integer rv = curr;
                curr = null;
                
                while(st.size() > 0){
                    Pair top = st.peek();
                    if(top.state == -1){
                        curr = top.node.data;
                        top.state++;
                        break;
                    }
                    else if(top.state < top.node.children.size()){
                        // push the child
                        Node child = top.node.children.get(top.state);
                        st.push(new Pair(child,-1));
                        top.state++;
                    }
                    else{
                        st.pop();
                    }
                }
                return rv;
            }
        }
    }
}
