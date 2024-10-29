public class FlattenLL{
    static Node flatten(Node root) {
        if(root==null || root.next==null){
            return root;
        }
        Node mergeHead=flatten(root.next);
        root=merge(root,mergeHead);
        return root;
    }
    static Node merge(Node list1,Node list2){
        Node dummyHead=new Node(-1);
        Node result=dummyHead;
        while(list1!=null && list2!=null){
            if(list1.data<=list2.data){
                Node newNode=new Node(list1.data);
                result.bottom=newNode;
                list1=list1.bottom;
            }else{
                Node newNode=new Node(list2.data);
                result.bottom=newNode;
                list2=list2.bottom;
            }
            result=result.bottom;
        }

        if(list1!=null){
            result.bottom=list1;
        }
        if(list2!=null){
            result.bottom=list2;
        }

        if(dummyHead.bottom!=null){
            dummyHead.bottom.next=null;
        }

        return dummyHead.bottom;
    }
}
class Node{
    int data;
    Node next;
    Node bottom;
    Node(int data){
        this.data=data;
        this.next=null;
        this.bottom=null;
    }
}