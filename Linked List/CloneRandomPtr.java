import java.util.HashMap;
import java.util.Map;

public class CloneRandomPtr {
    static Node copyRandomList(Node head) {
        if(head==null)        return null;

        Map<Node,Node> map=new HashMap<>();
        Node temp=head;

        while(temp!=null){
            Node newNode=new Node(temp.val);
            map.put(temp,newNode);
            temp=temp.next;
        }

        for(Node ogNode:map.keySet()){
            map.get(ogNode).next=map.get(ogNode.next);
            map.get(ogNode).random=map.get(ogNode.random);
        }

        return map.get(head);
    }

    //Optimal approach
    static Node insertInBetween(Node head){
        if(head==null)  return null;

        Node temp=head;
        
        while(temp!=null){
            Node copyNode=new Node(temp.val);
            copyNode.next=temp.next;
            temp.next=copyNode;
            temp=temp.next.next;
        }
        return head;
    }
    static Node connectRandomLinks(Node head){
        Node temp=head;
        while(temp!=null){
            Node copyNode=temp.next;
            if(temp.random!=null){
                copyNode.random=temp.random.next;
            }else{
                copyNode.random=null;
            }
            temp=temp.next.next;
        }
        return head;
    }
    static Node getAlternateNodes(Node head){
        Node temp=head;
        Node dummyHead=new Node(-1);
        Node res=dummyHead;
        while(temp!=null){
            res.next=temp.next;
            res=res.next;
            temp.next=temp.next.next;
            temp=temp.next;
        }
        return dummyHead.next;
    }
    static Node clooneLL(Node head){
        if(head==null)  return null;

        head=insertInBetween(head);
        head=connectRandomLinks(head);
        Node newHead=getAlternateNodes(head);

        return newHead;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}