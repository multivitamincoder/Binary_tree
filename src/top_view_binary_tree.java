import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class top_view_binary_tree {

     static class Node{
        int data;
         Node left;
         Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }

    }
   static class info{
        Node node;
        int hzd;
        public info(Node node,int hzd){
            this.node=node;
            this.hzd=hzd;
        }
    }

    // public static Node root=new Node();
    public static void top_view(Node root) {




        Queue<info> q=new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();
        int min=0,max=0;
        q.add(new info(root,0));
        q.add(null );
        while(!q.isEmpty()){
            info curr=q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                if(!map.containsKey(curr.hzd)){
                    map.put(curr.hzd,curr.node);
                }
                if(curr.node.left != null){
                    q.add(new info(curr.node.left,curr.hzd-1));
                    min=Math.min(min, curr.hzd-1);
                }
                if(curr.node.right!=null){
                    q.add(new info(curr.node.right,curr.hzd+1));
                    max=Math.max(max,curr.hzd+1);
                }
            }

        }
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");

        }


    }




    public static void main(String args[]){

  Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.right.left=new Node(6);
        root.left.right=new Node(5);
        root.right.right=new Node(7);
        top_view(root);

    }
}
